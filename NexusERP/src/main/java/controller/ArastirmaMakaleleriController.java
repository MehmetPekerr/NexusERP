package controller;

import dto.ArastirmaMakaleleriDTO;
import model.ArastirmaMakaleleri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ArastirmaMakaleleriService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/arastirma-makaleleri")
public class ArastirmaMakaleleriController {

    @Autowired
    private ArastirmaMakaleleriService arastirmaMakaleleriService;

    @GetMapping
    public List<ArastirmaMakaleleriDTO> getAllArastirmaMakaleleri() {
        List<ArastirmaMakaleleri> arastirmaMakaleleriList = arastirmaMakaleleriService.getAllArastirmaMakaleleri();
        return arastirmaMakaleleriList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArastirmaMakaleleriDTO> getArastirmaMakalesiById(@PathVariable Long id) {
        ArastirmaMakaleleri arastirmaMakalesi = arastirmaMakaleleriService.getArastirmaMakalesiById(id);
        if (arastirmaMakalesi == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(convertToDTO(arastirmaMakalesi));
    }

    @PostMapping
    public ResponseEntity<ArastirmaMakaleleriDTO> createArastirmaMakalesi(@RequestBody ArastirmaMakaleleriDTO arastirmaMakaleleriDTO) {
        ArastirmaMakaleleri arastirmaMakalesi = convertToEntity(arastirmaMakaleleriDTO);
        ArastirmaMakaleleri createdArastirmaMakalesi = arastirmaMakaleleriService.createArastirmaMakalesi(arastirmaMakalesi);
        return ResponseEntity.ok(convertToDTO(createdArastirmaMakalesi));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArastirmaMakaleleriDTO> updateArastirmaMakalesi(@PathVariable Long id, @RequestBody ArastirmaMakaleleriDTO arastirmaMakaleleriDTO) {
        ArastirmaMakaleleri arastirmaMakalesi = convertToEntity(arastirmaMakaleleriDTO);
        ArastirmaMakaleleri updatedArastirmaMakalesi = arastirmaMakaleleriService.updateArastirmaMakalesi(id, arastirmaMakalesi);
        if (updatedArastirmaMakalesi == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(convertToDTO(updatedArastirmaMakalesi));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArastirmaMakalesi(@PathVariable Long id) {
        boolean isDeleted = arastirmaMakaleleriService.deleteArastirmaMakalesi(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    private ArastirmaMakaleleri convertToEntity(ArastirmaMakaleleriDTO dto) {
        ArastirmaMakaleleri entity = new ArastirmaMakaleleri();
        entity.setId(dto.getId());
        entity.setMakaleAdi(dto.getMakaleAdi());
        entity.setYazar(dto.getYazar());
        entity.setDergiAdi(dto.getDergiAdi());
        entity.setYayinTarihi(dto.getYayinTarihi());
        entity.setKonu(dto.getKonu());
        // Firma ile ilişkili
        // entity.setFirma(findFirmaById(dto.getFirmaId())); 
        return entity;
    }

    private ArastirmaMakaleleriDTO convertToDTO(ArastirmaMakaleleri entity) {
        ArastirmaMakaleleriDTO dto = new ArastirmaMakaleleriDTO();
        dto.setId(entity.getId());
        dto.setMakaleAdi(entity.getMakaleAdi());
        dto.setYazar(entity.getYazar());
        dto.setDergiAdi(entity.getDergiAdi());
        dto.setYayinTarihi(entity.getYayinTarihi());
        dto.setKonu(entity.getKonu());
        // Firma ID'sini ekle
        dto.setFirmaId(entity.getFirma().getId());
        return dto;
    }
}
