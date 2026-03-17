package controller;

import dto.UrunMaliyetAnaliziDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UrunMaliyetAnaliziService;

import java.util.List;

@RestController
@RequestMapping("/api/urun-maliyet-analizi")
public class UrunMaliyetAnaliziController {

    private final UrunMaliyetAnaliziService urunMaliyetAnaliziService;

    @Autowired
    public UrunMaliyetAnaliziController(UrunMaliyetAnaliziService urunMaliyetAnaliziService) {
        this.urunMaliyetAnaliziService = urunMaliyetAnaliziService;
    }

    // Yeni bir ürün maliyet analizi oluşturma
    @PostMapping
    public ResponseEntity<Void> createUrunMaliyetAnalizi(@RequestBody UrunMaliyetAnaliziDTO urunMaliyetAnaliziDTO) {
        urunMaliyetAnaliziService.createUrunMaliyetAnalizi(urunMaliyetAnaliziDTO);
        return ResponseEntity.ok().build();
    }

    // Tüm ürün maliyet analizlerini listeleme
    @GetMapping
    public List<UrunMaliyetAnaliziDTO> getAllUrunMaliyetAnalizleri() {
        return urunMaliyetAnaliziService.getAllUrunMaliyetAnalizleri();
    }

    // ID ile bir ürün maliyet analizi getirme
    @GetMapping("/{id}")
    public ResponseEntity<UrunMaliyetAnaliziDTO> getUrunMaliyetAnaliziById(@PathVariable Long id) {
        UrunMaliyetAnaliziDTO urunMaliyetAnaliziDTO = urunMaliyetAnaliziService.getUrunMaliyetAnaliziById(id);
        return ResponseEntity.ok(urunMaliyetAnaliziDTO);
    }

    // Ürün maliyet analizini güncelleme
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUrunMaliyetAnalizi(@PathVariable Long id, @RequestBody UrunMaliyetAnaliziDTO urunMaliyetAnaliziDTO) {
        urunMaliyetAnaliziService.updateUrunMaliyetAnalizi(id, urunMaliyetAnaliziDTO);
        return ResponseEntity.ok().build();
    }

    // Ürün maliyet analizini silme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUrunMaliyetAnalizi(@PathVariable Long id) {
        urunMaliyetAnaliziService.deleteUrunMaliyetAnalizi(id);
        return ResponseEntity.ok().build();
    }
}
