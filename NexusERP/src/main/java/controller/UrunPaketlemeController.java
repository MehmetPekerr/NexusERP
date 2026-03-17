package controller;

import dto.UrunPaketlemeDTO;
import model.Nakliyat;
import model.Siparis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UrunPaketlemeService;

import java.util.List;

@RestController
@RequestMapping("/api/urunpaketleme")
public class UrunPaketlemeController {

    private final UrunPaketlemeService urunPaketlemeService;

    @Autowired
    public UrunPaketlemeController(UrunPaketlemeService urunPaketlemeService) {
        this.urunPaketlemeService = urunPaketlemeService;
    }

    @PostMapping
    public ResponseEntity<Void> createUrunPaketleme(@RequestBody UrunPaketlemeDTO urunPaketlemeDTO) {
        urunPaketlemeService.createUrunPaketleme(urunPaketlemeDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<UrunPaketlemeDTO>> getAllUrunPaketleme() {
        List<UrunPaketlemeDTO> urunPaketlemeList = urunPaketlemeService.getAllUrunPaketleme();
        return ResponseEntity.ok(urunPaketlemeList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UrunPaketlemeDTO> getUrunPaketlemeById(@PathVariable Long id) {
        UrunPaketlemeDTO urunPaketlemeDTO = urunPaketlemeService.getUrunPaketlemeById(id);
        return ResponseEntity.ok(urunPaketlemeDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUrunPaketleme(@PathVariable Long id, @RequestBody UrunPaketlemeDTO urunPaketlemeDTO) {
        urunPaketlemeService.updateUrunPaketleme(id, urunPaketlemeDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUrunPaketleme(@PathVariable Long id) {
        urunPaketlemeService.deleteUrunPaketleme(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/siparisler")
    public ResponseEntity<List<Siparis>> getSiparislerByUrunPaketlemeId(@PathVariable Long id) {
        List<Siparis> siparisList = urunPaketlemeService.getSiparislerByUrunPaketlemeId(id);
        return ResponseEntity.ok(siparisList);
    }

    @GetMapping("/{id}/nakliyatlar")
    public ResponseEntity<List<Nakliyat>> getNakliyatlarByUrunPaketlemeId(@PathVariable Long id) {
        List<Nakliyat> nakliyatList = urunPaketlemeService.getNakliyatlarByUrunPaketlemeId(id);
        return ResponseEntity.ok(nakliyatList);
    }
}
