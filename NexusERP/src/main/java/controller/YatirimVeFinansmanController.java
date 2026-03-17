package controller;

import dto.YatirimVeFinansmanDTO;
import service.YatirimVeFinansmanService;
import model.Firma;  // Firma modelini import ediyoruz
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/yatirim-ve-finansman")
public class YatirimVeFinansmanController {

    private final YatirimVeFinansmanService yatirimVeFinansmanService;

    @Autowired
    public YatirimVeFinansmanController(YatirimVeFinansmanService yatirimVeFinansmanService) {
        this.yatirimVeFinansmanService = yatirimVeFinansmanService;
    }

    // Yeni bir yatırım ve finansman kaydı oluşturmak için endpoint
    @PostMapping
    public ResponseEntity<String> createYatirimVeFinansman(@RequestBody YatirimVeFinansmanDTO yatirimVeFinansmanDTO) {
        yatirimVeFinansmanService.createYatirimVeFinansman(yatirimVeFinansmanDTO);
        return new ResponseEntity<>("Yatırım ve finansman başarıyla oluşturuldu!", HttpStatus.CREATED);
    }

    // Tüm yatırım ve finansman kayıtlarını listelemek için endpoint
    @GetMapping
    public ResponseEntity<List<YatirimVeFinansmanDTO>> getAllYatirimVeFinansman() {
        List<YatirimVeFinansmanDTO> yatirimVeFinansmanList = yatirimVeFinansmanService.getAllYatirimVeFinansman();
        return new ResponseEntity<>(yatirimVeFinansmanList, HttpStatus.OK);
    }

    // Belirli bir yatırım ve finansman kaydını ID ile getirmek için endpoint
    @GetMapping("/{id}")
    public ResponseEntity<YatirimVeFinansmanDTO> getYatirimVeFinansmanById(@PathVariable Long id) {
        YatirimVeFinansmanDTO yatirimVeFinansman = yatirimVeFinansmanService.getYatirimVeFinansmanById(id);
        return new ResponseEntity<>(yatirimVeFinansman, HttpStatus.OK);
    }

    // Yatırım ve finansman kaydını güncelleme işlemi
    @PutMapping("/{id}")
    public ResponseEntity<String> updateYatirimVeFinansman(@PathVariable Long id, @RequestBody YatirimVeFinansmanDTO yatirimVeFinansmanDTO) {
        yatirimVeFinansmanService.updateYatirimVeFinansman(id, yatirimVeFinansmanDTO);
        return new ResponseEntity<>("Yatırım ve finansman başarıyla güncellendi!", HttpStatus.OK);
    }

    // Yatırım ve finansman kaydını silme işlemi
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteYatirimVeFinansman(@PathVariable Long id) {
        yatirimVeFinansmanService.deleteYatirimVeFinansman(id);
        return new ResponseEntity<>("Yatırım ve finansman başarıyla silindi!", HttpStatus.OK);
    }

    // Firma ID'sine göre yatırım ve finansmanları listelemek için endpoint
    @GetMapping("/firma/{firmaId}")
    public ResponseEntity<List<YatirimVeFinansmanDTO>> getYatirimVeFinansmanByFirmaId(@PathVariable Long firmaId) {
        List<YatirimVeFinansmanDTO> yatirimVeFinansmanList = yatirimVeFinansmanService.getYatirimVeFinansmanByFirmaId(firmaId);
        return new ResponseEntity<>(yatirimVeFinansmanList, HttpStatus.OK);
    }
}
