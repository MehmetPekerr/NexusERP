package controller;

import dto.UrunTanitimPlanlariDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UrunTanitimPlanlariService;

import java.util.List;

@RestController
@RequestMapping("/urun-tanitim-planlari")
public class UrunTanitimPlanlariController {

    private final UrunTanitimPlanlariService urunTanitimPlanlariService;

    @Autowired
    public UrunTanitimPlanlariController(UrunTanitimPlanlariService urunTanitimPlanlariService) {
        this.urunTanitimPlanlariService = urunTanitimPlanlariService;
    }

    // Ürün tanıtım planı oluşturma
    @PostMapping
    public ResponseEntity<Void> createUrunTanitimPlani(@RequestBody UrunTanitimPlanlariDTO urunTanitimPlaniDTO) {
        urunTanitimPlanlariService.createUrunTanitimPlani(urunTanitimPlaniDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Tüm ürün tanıtım planlarını listeleme
    @GetMapping
    public ResponseEntity<List<UrunTanitimPlanlariDTO>> getAllUrunTanitimPlanlari() {
        List<UrunTanitimPlanlariDTO> urunTanitimPlanlari = urunTanitimPlanlariService.getAllUrunTanitimPlanlari();
        return new ResponseEntity<>(urunTanitimPlanlari, HttpStatus.OK);
    }

    // ID ile bir ürün tanıtım planını getirme
    @GetMapping("/{id}")
    public ResponseEntity<UrunTanitimPlanlariDTO> getUrunTanitimPlani(@PathVariable Long id) {
        UrunTanitimPlanlariDTO urunTanitimPlaniDTO = urunTanitimPlanlariService.getUrunTanitimPlaniById(id);
        if (urunTanitimPlaniDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(urunTanitimPlaniDTO, HttpStatus.OK);
    }

    // Ürün tanıtım planını güncelleme
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUrunTanitimPlani(@PathVariable Long id, @RequestBody UrunTanitimPlanlariDTO urunTanitimPlaniDTO) {
        boolean isUpdated = urunTanitimPlanlariService.updateUrunTanitimPlani(id, urunTanitimPlaniDTO);
        if (!isUpdated) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Ürün tanıtım planını silme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUrunTanitimPlani(@PathVariable Long id) {
        boolean isDeleted = urunTanitimPlanlariService.deleteUrunTanitimPlani(id);
        if (!isDeleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
