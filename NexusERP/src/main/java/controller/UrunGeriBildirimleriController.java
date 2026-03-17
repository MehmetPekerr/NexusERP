package controller;

import dto.UrunGeriBildirimleriDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UrunGeriBildirimleriService;

import java.util.List;

@RestController
@RequestMapping("/api/urungeribildirimleri")
public class UrunGeriBildirimleriController {

    private final UrunGeriBildirimleriService urunGeriBildirimleriService;

    @Autowired
    public UrunGeriBildirimleriController(UrunGeriBildirimleriService urunGeriBildirimleriService) {
        this.urunGeriBildirimleriService = urunGeriBildirimleriService;
    }

    @PostMapping
    public ResponseEntity<Void> createUrunGeriBildirimleri(@RequestBody UrunGeriBildirimleriDTO urunGeriBildirimleriDTO) {
        urunGeriBildirimleriService.createUrunGeriBildirimi(urunGeriBildirimleriDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<UrunGeriBildirimleriDTO>> getAllUrunGeriBildirimleri() {
        List<UrunGeriBildirimleriDTO> urunGeriBildirimleriList = urunGeriBildirimleriService.getAllUrunGeriBildirimleri();
        return ResponseEntity.ok(urunGeriBildirimleriList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UrunGeriBildirimleriDTO> getUrunGeriBildirimleriById(@PathVariable Long id) {
        UrunGeriBildirimleriDTO urunGeriBildirimleriDTO = urunGeriBildirimleriService.getUrunGeriBildirimleriById(id);
        return ResponseEntity.ok(urunGeriBildirimleriDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUrunGeriBildirimleri(@PathVariable Long id, @RequestBody UrunGeriBildirimleriDTO urunGeriBildirimleriDTO) {
        urunGeriBildirimleriService.updateUrunGeriBildirimleri(id, urunGeriBildirimleriDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUrunGeriBildirimleri(@PathVariable Long id) {
        urunGeriBildirimleriService.deleteUrunGeriBildirimleri(id);
        return ResponseEntity.ok().build();
    }
}
