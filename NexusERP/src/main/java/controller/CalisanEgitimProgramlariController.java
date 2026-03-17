package controller;

import dto.CalisanEgitimProgramlariDTO;
import model.CalisanEgitimProgramlari;
import service.CalisanEgitimProgramlariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/calisan-egitim-programlari")
public class CalisanEgitimProgramlariController {

    @Autowired
    private CalisanEgitimProgramlariService calisanEgitimProgramlariService;

    // Tüm çalışan eğitim programlarını listele
    @GetMapping
    public List<CalisanEgitimProgramlariDTO> getAllCalisanEgitimProgramlari() {
        List<CalisanEgitimProgramlari> calisanEgitimProgramlariList = calisanEgitimProgramlariService.getAllCalisanEgitimProgramlari();
        return calisanEgitimProgramlariList.stream()
                .map(program -> new CalisanEgitimProgramlariDTO(
                        program.getId(),
                        program.getEgitimAdi(),
                        program.getEgitimTarihi(),
                        program.getCalisanAdi(),
                        program.getInsanKaynaklari().getAd()))  // İnsan Kaynakları ilişkisi eklendi
                .collect(Collectors.toList());
    }

    // ID ile çalışan eğitim programını al
    @GetMapping("/{id}")
    public ResponseEntity<CalisanEgitimProgramlariDTO> getCalisanEgitimProgramlariById(@PathVariable Long id) {
        CalisanEgitimProgramlari calisanEgitimProgramlari = calisanEgitimProgramlariService.getCalisanEgitimProgramlariById(id);
        if (calisanEgitimProgramlari == null) {
            return ResponseEntity.notFound().build();
        }
        CalisanEgitimProgramlariDTO calisanEgitimProgramlariDTO = new CalisanEgitimProgramlariDTO(
                calisanEgitimProgramlari.getId(),
                calisanEgitimProgramlari.getEgitimAdi(),
                calisanEgitimProgramlari.getEgitimTarihi(),
                calisanEgitimProgramlari.getCalisanAdi(),
                calisanEgitimProgramlari.getInsanKaynaklari().getAd());  // İnsan Kaynakları bilgisi eklendi
        return ResponseEntity.ok(calisanEgitimProgramlariDTO);
    }

    // Yeni çalışan eğitim programı oluştur
    @PostMapping
    public ResponseEntity<CalisanEgitimProgramlariDTO> createCalisanEgitimProgramlari(@RequestBody CalisanEgitimProgramlari calisanEgitimProgramlari) {
        CalisanEgitimProgramlari createdCalisanEgitimProgramlari = calisanEgitimProgramlariService.createCalisanEgitimProgramlari(calisanEgitimProgramlari);
        CalisanEgitimProgramlariDTO createdDTO = new CalisanEgitimProgramlariDTO(
                createdCalisanEgitimProgramlari.getId(),
                createdCalisanEgitimProgramlari.getEgitimAdi(),
                createdCalisanEgitimProgramlari.getEgitimTarihi(),
                createdCalisanEgitimProgramlari.getCalisanAdi(),
                createdCalisanEgitimProgramlari.getInsanKaynaklari().getAd());  // İnsan Kaynakları bilgisi eklendi
        return ResponseEntity.ok(createdDTO);
    }

    // Çalışan eğitim programını güncelle
    @PutMapping("/{id}")
    public ResponseEntity<CalisanEgitimProgramlariDTO> updateCalisanEgitimProgramlari(
            @PathVariable Long id, @RequestBody CalisanEgitimProgramlari calisanEgitimProgramlari) {
        CalisanEgitimProgramlari updatedCalisanEgitimProgramlari = calisanEgitimProgramlariService.updateCalisanEgitimProgramlari(id, calisanEgitimProgramlari);
        if (updatedCalisanEgitimProgramlari == null) {
            return ResponseEntity.notFound().build();
        }
        CalisanEgitimProgramlariDTO updatedDTO = new CalisanEgitimProgramlariDTO(
                updatedCalisanEgitimProgramlari.getId(),
                updatedCalisanEgitimProgramlari.getEgitimAdi(),
                updatedCalisanEgitimProgramlari.getEgitimTarihi(),
                updatedCalisanEgitimProgramlari.getCalisanAdi(),
                updatedCalisanEgitimProgramlari.getInsanKaynaklari().getAd());  // İnsan Kaynakları bilgisi eklendi
        return ResponseEntity.ok(updatedDTO);
    }

    // Çalışan eğitim programını sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCalisanEgitimProgramlari(@PathVariable Long id) {
        boolean isDeleted = calisanEgitimProgramlariService.deleteCalisanEgitimProgramlari(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
