package controller;

import dto.UrunlerDTO;
import service.UrunlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/urunler")
public class UrunlerController {

    private final UrunlerService urunlerService;

    @Autowired
    public UrunlerController(UrunlerService urunlerService) {
        this.urunlerService = urunlerService;
    }

    // Yeni bir ürün oluşturmak için endpoint
    @PostMapping
    public ResponseEntity<String> createUrun(@RequestBody UrunlerDTO urunlerDTO) {
        urunlerService.createUrun(urunlerDTO);
        return new ResponseEntity<>("Ürün başarıyla oluşturuldu!", HttpStatus.CREATED);
    }

    // Tüm ürünleri listelemek için endpoint
    @GetMapping
    public ResponseEntity<List<UrunlerDTO>> getAllUrunler() {
        List<UrunlerDTO> urunler = urunlerService.getAllUrunler();
        return new ResponseEntity<>(urunler, HttpStatus.OK);
    }

    // Belirli bir ürünü ID ile getirmek için endpoint
    @GetMapping("/{id}")
    public ResponseEntity<UrunlerDTO> getUrunById(@PathVariable Long id) {
        UrunlerDTO urun = urunlerService.getUrunById(id);
        return new ResponseEntity<>(urun, HttpStatus.OK);
    }

    // Ürün güncelleme işlemi
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUrun(@PathVariable Long id, @RequestBody UrunlerDTO urunlerDTO) {
        urunlerService.updateUrun(id, urunlerDTO);
        return new ResponseEntity<>("Ürün başarıyla güncellendi!", HttpStatus.OK);
    }

    // Ürün silme işlemi
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUrun(@PathVariable Long id) {
        urunlerService.deleteUrun(id);
        return new ResponseEntity<>("Ürün başarıyla silindi!", HttpStatus.OK);
    }
}
