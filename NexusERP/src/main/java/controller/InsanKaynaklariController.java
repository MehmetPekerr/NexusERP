package controller;

import dto.InsanKaynaklariDTO;
import model.InsanKaynaklari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import service.InsanKaynaklariService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/insan-kaynaklari")
public class InsanKaynaklariController {

    @Autowired
    private InsanKaynaklariService insanKaynaklariService;

    // Tüm insan kaynaklarını getir
    @GetMapping
    public List<InsanKaynaklari> getAllInsanKaynaklari() {
        return insanKaynaklariService.getAllInsanKaynaklari();
    }

    // ID'ye göre insan kaynağı getir
    @GetMapping("/{id}")
    public ResponseEntity<InsanKaynaklari> getInsanKaynaklariById(@PathVariable Long id) {
        Optional<InsanKaynaklari> insanKaynaklari = insanKaynaklariService.getInsanKaynaklariById(id);
        return insanKaynaklari.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Yeni insan kaynağı oluştur
    @PostMapping
    public ResponseEntity<InsanKaynaklari> createInsanKaynaklari(@RequestBody InsanKaynaklariDTO insanKaynaklariDTO) {
        InsanKaynaklari insanKaynaklari = insanKaynaklariService.createInsanKaynaklari(insanKaynaklariDTO);
        return ResponseEntity.ok(insanKaynaklari);
    }

    // İnsan kaynağını güncelle
    @PutMapping("/{id}")
    public ResponseEntity<InsanKaynaklari> updateInsanKaynaklari(@PathVariable Long id, @RequestBody InsanKaynaklariDTO insanKaynaklariDTO) {
        InsanKaynaklari insanKaynaklari = insanKaynaklariService.updateInsanKaynaklari(id, insanKaynaklariDTO);
        return ResponseEntity.ok(insanKaynaklari);
    }

    // İnsan kaynağını sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInsanKaynaklari(@PathVariable Long id) {
        insanKaynaklariService.deleteInsanKaynaklari(id);
        return ResponseEntity.noContent().build();
    }
}
