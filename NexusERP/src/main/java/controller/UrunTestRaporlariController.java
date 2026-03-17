package controller;

import dto.UrunTestRaporlariDTO;
import service.UrunTestRaporlariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/uruntestraporlari")
public class UrunTestRaporlariController {

    private final UrunTestRaporlariService urunTestRaporlariService;

    @Autowired
    public UrunTestRaporlariController(UrunTestRaporlariService urunTestRaporlariService) {
        this.urunTestRaporlariService = urunTestRaporlariService;
    }

    // Yeni bir test raporu oluşturmak için endpoint
    @PostMapping
    public ResponseEntity<String> createUrunTestRapor(@RequestBody UrunTestRaporlariDTO urunTestRaporlariDTO) {
        urunTestRaporlariService.createUrunTestRapor(urunTestRaporlariDTO);
        return new ResponseEntity<>("Ürün test raporu başarıyla oluşturuldu!", HttpStatus.CREATED);
    }

    // Tüm ürün test raporlarını listelemek için endpoint
    @GetMapping
    public ResponseEntity<List<UrunTestRaporlariDTO>> getAllUrunTestRaporlari() {
        List<UrunTestRaporlariDTO> raporlar = urunTestRaporlariService.getAllUrunTestRaporlari();
        if (raporlar == null || raporlar.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Eğer listede hiç veri yoksa 204 döner
        }
        return new ResponseEntity<>(raporlar, HttpStatus.OK); // Eğer listede veri varsa 200 döner
    }

    // Belirli bir ürün test raporunu ID ile getirmek için endpoint
    @GetMapping("/{id}")
    public ResponseEntity<UrunTestRaporlariDTO> getUrunTestRaporById(@PathVariable Long id) {
        UrunTestRaporlariDTO rapor = urunTestRaporlariService.getUrunTestRaporById(id);
        if (rapor != null) {
            return new ResponseEntity<>(rapor, HttpStatus.OK); // Eğer rapor bulunduysa 200 döner
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Eğer rapor bulunamadıysa 404 döner
        }
    }

    // Ürün test raporunu güncellemek için endpoint
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUrunTestRapor(@PathVariable Long id, @RequestBody UrunTestRaporlariDTO urunTestRaporlariDTO) {
        boolean isUpdated = urunTestRaporlariService.updateUrunTestRapor(id, urunTestRaporlariDTO);
        if (isUpdated) {
            return new ResponseEntity<>("Ürün test raporu başarıyla güncellendi!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Test raporu bulunamadı", HttpStatus.NOT_FOUND);
        }
    }

    // Ürün test raporunu silmek için endpoint
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUrunTestRapor(@PathVariable Long id) {
        boolean isDeleted = urunTestRaporlariService.deleteUrunTestRapor(id);
        if (isDeleted) {
            return new ResponseEntity<>("Ürün test raporu başarıyla silindi!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Test raporu bulunamadı", HttpStatus.NOT_FOUND);
        }
    }
}
