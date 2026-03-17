package controller;

import dto.InovasyonProjeleriDTO;
import model.InovasyonProjeleri;
import service.InovasyonProjeleriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/inovasyon-projeleri")
public class InovasyonProjeleriController {

    private final InovasyonProjeleriService inovasyonProjeleriService;

    @Autowired
    public InovasyonProjeleriController(InovasyonProjeleriService inovasyonProjeleriService) {
        this.inovasyonProjeleriService = inovasyonProjeleriService;
    }

    // Tüm inovasyon projelerini listele
    @GetMapping
    public ResponseEntity<List<InovasyonProjeleriDTO>> getAllInovasyonProjeleri() {
        List<InovasyonProjeleri> inovasyonProjeleriList = inovasyonProjeleriService.getAllInovasyonProjeleri();
        List<InovasyonProjeleriDTO> dtoList = inovasyonProjeleriList.stream()
                .map(proje -> new InovasyonProjeleriDTO(
                        proje.getId(),
                        proje.getProjeAdi(),
                        proje.getProjeAciklama(),
                        proje.getProjeBaslangicTarihi(),
                        proje.getProjeBitisTarihi()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(dtoList);
    }

    // ID ile inovasyon projesini al
    @GetMapping("/{id}")
    public ResponseEntity<InovasyonProjeleriDTO> getInovasyonProjesiById(@PathVariable Long id) {
        InovasyonProjeleri inovasyonProjeleri = inovasyonProjeleriService.getInovasyonProjesiById(id);
        if (inovasyonProjeleri == null) {
            return ResponseEntity.notFound().build();
        }
        InovasyonProjeleriDTO inovasyonProjeleriDTO = new InovasyonProjeleriDTO(
                inovasyonProjeleri.getId(),
                inovasyonProjeleri.getProjeAdi(),
                inovasyonProjeleri.getProjeAciklama(),
                inovasyonProjeleri.getProjeBaslangicTarihi(),
                inovasyonProjeleri.getProjeBitisTarihi());
        return ResponseEntity.ok(inovasyonProjeleriDTO);
    }

    // Yeni inovasyon projesi oluştur
    @PostMapping
    public ResponseEntity<InovasyonProjeleriDTO> createInovasyonProjesi(@RequestBody InovasyonProjeleriDTO inovasyonProjeleriDTO) {
        // DTO'dan entity'ye dönüştür
        InovasyonProjeleri inovasyonProjeleri = new InovasyonProjeleri();
        inovasyonProjeleri.setProjeAdi(inovasyonProjeleriDTO.getProjeAdi());
        inovasyonProjeleri.setProjeAciklama(inovasyonProjeleriDTO.getProjeAciklama());
        inovasyonProjeleri.setProjeBaslangicTarihi(inovasyonProjeleriDTO.getProjeBaslangicTarihi());
        inovasyonProjeleri.setProjeBitisTarihi(inovasyonProjeleriDTO.getProjeBitisTarihi());

        InovasyonProjeleri createdInovasyonProjesi = inovasyonProjeleriService.createInovasyonProjesi(inovasyonProjeleri);
        InovasyonProjeleriDTO createdDTO = new InovasyonProjeleriDTO(
                createdInovasyonProjesi.getId(),
                createdInovasyonProjesi.getProjeAdi(),
                createdInovasyonProjesi.getProjeAciklama(),
                createdInovasyonProjesi.getProjeBaslangicTarihi(),
                createdInovasyonProjesi.getProjeBitisTarihi());

        return ResponseEntity.status(201).body(createdDTO);  // HTTP 201 - Created
    }

    // Inovasyon projesini güncelle
    @PutMapping("/{id}")
    public ResponseEntity<InovasyonProjeleriDTO> updateInovasyonProjesi(@PathVariable Long id, @RequestBody InovasyonProjeleriDTO inovasyonProjeleriDTO) {
        InovasyonProjeleri inovasyonProjeleri = inovasyonProjeleriService.getInovasyonProjesiById(id);
        if (inovasyonProjeleri == null) {
            return ResponseEntity.notFound().build();
        }

        inovasyonProjeleri.setProjeAdi(inovasyonProjeleriDTO.getProjeAdi());
        inovasyonProjeleri.setProjeAciklama(inovasyonProjeleriDTO.getProjeAciklama());
        inovasyonProjeleri.setProjeBaslangicTarihi(inovasyonProjeleriDTO.getProjeBaslangicTarihi());
        inovasyonProjeleri.setProjeBitisTarihi(inovasyonProjeleriDTO.getProjeBitisTarihi());

        InovasyonProjeleri updatedInovasyonProjesi = inovasyonProjeleriService.updateInovasyonProjesi(inovasyonProjeleri);
        InovasyonProjeleriDTO updatedDTO = new InovasyonProjeleriDTO(
                updatedInovasyonProjesi.getId(),
                updatedInovasyonProjesi.getProjeAdi(),
                updatedInovasyonProjesi.getProjeAciklama(),
                updatedInovasyonProjesi.getProjeBaslangicTarihi(),
                updatedInovasyonProjesi.getProjeBitisTarihi());

        return ResponseEntity.ok(updatedDTO);
    }

    // Inovasyon projesini sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInovasyonProjesi(@PathVariable Long id) {
        boolean isDeleted = inovasyonProjeleriService.deleteInovasyonProjesi(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
