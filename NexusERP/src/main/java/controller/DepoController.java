package controller;

import dto.DepoDTO;
import model.Depo;
import service.DepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/depo")
public class DepoController {

    @Autowired
    private DepoService depoService;

    // Tüm depo verilerini listele
    @GetMapping
    public ResponseEntity<List<DepoDTO>> getAllDepo() {
        List<Depo> depoList = depoService.getAllDepo();
        if (depoList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<DepoDTO> depoDTOList = depoList.stream()
                .map(depo -> new DepoDTO(
                        depo.getId(),
                        depo.getAd(),
                        depo.getKonum(),
                        depo.getKapasite(),
                        depo.getFirma() != null ? depo.getFirma().getId() : null,
                        depo.getTedarikciler().stream().map(t -> t.getId()).collect(Collectors.toList())))
                .collect(Collectors.toList());
        return ResponseEntity.ok(depoDTOList);
    }

    // ID ile depo verisini al
    @GetMapping("/{id}")
    public ResponseEntity<DepoDTO> getDepoById(@PathVariable Long id) {
        Depo depo = depoService.getDepoById(id);
        if (depo == null) {
            return ResponseEntity.notFound().build();
        }
        DepoDTO depoDTO = new DepoDTO(
                depo.getId(),
                depo.getAd(),
                depo.getKonum(),
                depo.getKapasite(),
                depo.getFirma() != null ? depo.getFirma().getId() : null,
                depo.getTedarikciler().stream().map(t -> t.getId()).collect(Collectors.toList()));
        return ResponseEntity.ok(depoDTO);
    }

    // Yeni depo verisi oluştur
    @PostMapping
    public ResponseEntity<DepoDTO> createDepo(@RequestBody Depo depo) {
        Depo createdDepo = depoService.createDepo(depo);
        DepoDTO createdDTO = new DepoDTO(
                createdDepo.getId(),
                createdDepo.getAd(),
                createdDepo.getKonum(),
                createdDepo.getKapasite(),
                createdDepo.getFirma() != null ? createdDepo.getFirma().getId() : null,
                createdDepo.getTedarikciler().stream().map(t -> t.getId()).collect(Collectors.toList()));
        return ResponseEntity.ok(createdDTO);
    }

    // Depo verisini güncelle
    @PutMapping("/{id}")
    public ResponseEntity<DepoDTO> updateDepo(@PathVariable Long id, @RequestBody Depo depo) {
        Depo updatedDepo = depoService.updateDepo(id, depo);
        if (updatedDepo == null) {
            return ResponseEntity.notFound().build();
        }
        DepoDTO updatedDTO = new DepoDTO(
                updatedDepo.getId(),
                updatedDepo.getAd(),
                updatedDepo.getKonum(),
                updatedDepo.getKapasite(),
                updatedDepo.getFirma() != null ? updatedDepo.getFirma().getId() : null,
                updatedDepo.getTedarikciler().stream().map(t -> t.getId()).collect(Collectors.toList()));
        return ResponseEntity.ok(updatedDTO);
    }

    // Depo verisini sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepo(@PathVariable Long id) {
        boolean isDeleted = depoService.deleteDepo(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    // Envanter kaydı yap
    @PostMapping("/envanter")
    public ResponseEntity<String> createEnvanter(@RequestParam String urunId,
                                                 @RequestParam String urunAdi,
                                                 @RequestParam int stokMiktari,
                                                 @RequestParam String depoKonumu) {
        // Envanter oluşturma işlemi
        // Örneğin, depoService.createEnvanter() metodunu çağırabilirsiniz
        // Şu anda sadece basit bir string döndürüyoruz
        return ResponseEntity.ok("Envanter kaydedildi: " + urunAdi + " - " + stokMiktari);
    }

    // Stok güncelleme işlemi
    @PostMapping("/stok-guncelleme")
    public ResponseEntity<String> updateStok(@RequestParam String guncelleId, @RequestParam int yeniStok) {
        // Stok güncelleme işlemi
        // Örneğin, depoService.updateStok() metodunu çağırabilirsiniz
        return ResponseEntity.ok("Stok güncellendi: " + guncelleId + " - Yeni Stok: " + yeniStok);
    }

    // Depo giriş/çıkış işlemi
    @PostMapping("/depo-islemleri")
    public ResponseEntity<String> createDepoIslemi(@RequestParam String islemId,
                                                   @RequestParam String islemTuru,
                                                   @RequestParam String islemTarihi) {
        // Depo işlemi kaydetme
        // Örneğin, depoService.createDepoIslemi() metodunu çağırabilirsiniz
        return ResponseEntity.ok("Depo işlemi kaydedildi: " + islemTuru + " - Tarih: " + islemTarihi);
    }
}
