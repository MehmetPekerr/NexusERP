package controller;

import dto.SatisStratejileriDTO;
import model.SatisStratejileri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.SatisStratejileriService;

import java.util.List;

@RestController
@RequestMapping("/api/satis-stratejileri")
public class SatisStratejileriController {

    private final SatisStratejileriService satisStratejileriService;

    @Autowired
    public SatisStratejileriController(SatisStratejileriService satisStratejileriService) {
        this.satisStratejileriService = satisStratejileriService;
    }

    // Tüm satış stratejilerini listeleme
    @GetMapping
    public ResponseEntity<List<SatisStratejileriDTO>> getAllSatisStratejileri() {
        List<SatisStratejileriDTO> satisStratejileriList = satisStratejileriService.getAllSatisStratejileri();
        return ResponseEntity.ok(satisStratejileriList);
    }

    // ID ile satış stratejisi bulma
    @GetMapping("/{id}")
    public ResponseEntity<SatisStratejileriDTO> getSatisStratejisiById(@PathVariable Long id) {
        SatisStratejileriDTO satisStratejisiDTO = satisStratejileriService.getSatisStratejisiById(id);
        return ResponseEntity.ok(satisStratejisiDTO);
    }

    // Yeni satış stratejisi oluşturma
    @PostMapping
    public ResponseEntity<Void> createSatisStratejisi(@RequestBody SatisStratejileriDTO satisStratejileriDTO) {
        satisStratejileriService.createSatisStratejisi(satisStratejileriDTO);
        return ResponseEntity.ok().build();
    }

    // Satış stratejisini güncelleme
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSatisStratejisi(@PathVariable Long id, @RequestBody SatisStratejileriDTO satisStratejileriDTO) {
        satisStratejileriService.updateSatisStratejisi(id, satisStratejileriDTO);
        return ResponseEntity.ok().build();
    }

    // Satış stratejisini silme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSatisStratejisi(@PathVariable Long id) {
        satisStratejileriService.deleteSatisStratejisi(id);
        return ResponseEntity.ok().build();
    }
}
