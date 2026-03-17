package controller;

import dto.SatisKanallariDTO;
import model.SatisKanallari;
import service.SatisKanallariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/satis-kanallari")
public class SatisKanallariController {

    private final SatisKanallariService satisKanallariService;

    @Autowired
    public SatisKanallariController(SatisKanallariService satisKanallariService) {
        this.satisKanallariService = satisKanallariService;
    }

    // Satış kanallarının listesini döndürür
    @GetMapping
    public ResponseEntity<List<SatisKanallariDTO>> getAllSatisKanallari() {
        List<SatisKanallari> satisKanallariList = satisKanallariService.getAllSatisKanallari();
        List<SatisKanallariDTO> satisKanallariDTOList = satisKanallariList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(satisKanallariDTOList);
    }

    // Belirli bir satış kanalını ID'ye göre döndürür
    @GetMapping("/{id}")
    public ResponseEntity<SatisKanallariDTO> getSatisKanallariById(@PathVariable Long id) {
        SatisKanallari satisKanallari = satisKanallariService.getSatisKanallariById(id);
        if (satisKanallari == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(convertToDTO(satisKanallari));
    }

    // Yeni bir satış kanalı oluşturur
    @PostMapping
    public ResponseEntity<SatisKanallariDTO> createSatisKanallari(@RequestBody SatisKanallari satisKanallari) {
        SatisKanallari createdSatisKanallari = satisKanallariService.createSatisKanallari(satisKanallari);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDTO(createdSatisKanallari));
    }

    // Var olan bir satış kanalını günceller
    @PutMapping("/{id}")
    public ResponseEntity<SatisKanallariDTO> updateSatisKanallari(@PathVariable Long id, @RequestBody SatisKanallari satisKanallari) {
        SatisKanallari updatedSatisKanallari = satisKanallariService.updateSatisKanallari(id, satisKanallari);
        if (updatedSatisKanallari == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(convertToDTO(updatedSatisKanallari));
    }

    // Satış kanalını siler
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSatisKanallari(@PathVariable Long id) {
        boolean isDeleted = satisKanallariService.deleteSatisKanallari(id);
        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // SatisKanallari modelini SatisKanallariDTO'ya dönüştürür
    private SatisKanallariDTO convertToDTO(SatisKanallari satisKanallari) {
        return new SatisKanallariDTO(
                satisKanallari.getId(),
                satisKanallari.getKanaliAdi(),
                satisKanallari.getAciklama());
    }
}
