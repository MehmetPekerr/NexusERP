package controller;

import dto.PromosyonlarDTO;
import service.PromosyonlarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promosyonlar")
public class PromosyonlarController {

    private final PromosyonlarService promosyonlarService;

    @Autowired
    public PromosyonlarController(PromosyonlarService promosyonlarService) {
        this.promosyonlarService = promosyonlarService;
    }

    // Promosyon eklemek için endpoint
    @PostMapping
    public ResponseEntity<String> createPromosyon(@RequestBody PromosyonlarDTO promosyonlarDTO) {
        promosyonlarService.createPromosyon(promosyonlarDTO);
        return new ResponseEntity<>("Promosyon başarıyla oluşturuldu!", HttpStatus.CREATED);
    }

    // Tüm promosyonları listelemek için endpoint
    @GetMapping
    public ResponseEntity<List<PromosyonlarDTO>> getAllPromosyonlar() {
        List<PromosyonlarDTO> promosyonlar = promosyonlarService.getAllPromosyonlar();
        return new ResponseEntity<>(promosyonlar, HttpStatus.OK);
    }

    // Belirli bir promosyonu ID ile getirmek için endpoint
    @GetMapping("/{id}")
    public ResponseEntity<PromosyonlarDTO> getPromosyonById(@PathVariable Long id) {
        PromosyonlarDTO promosyon = promosyonlarService.getPromosyonById(id);
        return new ResponseEntity<>(promosyon, HttpStatus.OK);
    }

    // Promosyonu güncellemek için endpoint
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePromosyon(@PathVariable Long id, @RequestBody PromosyonlarDTO promosyonlarDTO) {
        promosyonlarService.updatePromosyon(id, promosyonlarDTO);
        return new ResponseEntity<>("Promosyon başarıyla güncellendi!", HttpStatus.OK);
    }

    // Promosyonu silmek için endpoint
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePromosyon(@PathVariable Long id) {
        promosyonlarService.deletePromosyon(id);
        return new ResponseEntity<>("Promosyon başarıyla silindi!", HttpStatus.OK);
    }
}
