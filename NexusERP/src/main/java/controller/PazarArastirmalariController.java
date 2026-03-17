package controller;

import model.PazarArastirmalari;
import service.PazarArastirmalariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pazar-arastirmalari")
public class PazarArastirmalariController {

    private final PazarArastirmalariService pazarArastirmalariService;

    @Autowired
    public PazarArastirmalariController(PazarArastirmalariService pazarArastirmalariService) {
        this.pazarArastirmalariService = pazarArastirmalariService;
    }

    // Yeni pazar araştırması oluştur
    @PostMapping
    public ResponseEntity<PazarArastirmalari> createPazarArastirmalari(@RequestBody PazarArastirmalari pazarArastirmalari) {
        PazarArastirmalari created = pazarArastirmalariService.createPazarArastirmalari(pazarArastirmalari);
        return ResponseEntity.ok(created);
    }

    // Pazar araştırmasını güncelle
    @PutMapping("/{id}")
    public ResponseEntity<PazarArastirmalari> updatePazarArastirmalari(@PathVariable Long id, @RequestBody PazarArastirmalari pazarArastirmalari) {
        PazarArastirmalari updated = pazarArastirmalariService.updatePazarArastirmalari(id, pazarArastirmalari);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    // Pazar araştırmasını sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePazarArastirmalari(@PathVariable Long id) {
        boolean isDeleted = pazarArastirmalariService.deletePazarArastirmalari(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
