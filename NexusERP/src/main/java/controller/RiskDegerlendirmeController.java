package controller;

import dto.RiskDegerlendirmeDTO;
import service.RiskDegerlendirmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-degerlendirme")
public class RiskDegerlendirmeController {

    private final RiskDegerlendirmeService riskDegerlendirmeService;

    @Autowired
    public RiskDegerlendirmeController(RiskDegerlendirmeService riskDegerlendirmeService) {
        this.riskDegerlendirmeService = riskDegerlendirmeService;
    }

    @PostMapping
    public ResponseEntity<String> createRiskDegerlendirme(@RequestBody RiskDegerlendirmeDTO riskDegerlendirmeDTO) {
        riskDegerlendirmeService.createRiskDegerlendirme(riskDegerlendirmeDTO);
        return new ResponseEntity<>("Risk değerlendirmesi başarıyla oluşturuldu!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RiskDegerlendirmeDTO>> getAllRiskDegerlendirmeler() {
        List<RiskDegerlendirmeDTO> riskDegerlendirmeler = riskDegerlendirmeService.getAllRiskDegerlendirmeler();
        return new ResponseEntity<>(riskDegerlendirmeler, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskDegerlendirmeDTO> getRiskDegerlendirmeById(@PathVariable Long id) {
        RiskDegerlendirmeDTO riskDegerlendirmeDTO = riskDegerlendirmeService.getRiskDegerlendirmeById(id);
        return new ResponseEntity<>(riskDegerlendirmeDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRiskDegerlendirme(@PathVariable Long id, @RequestBody RiskDegerlendirmeDTO riskDegerlendirmeDTO) {
        riskDegerlendirmeService.updateRiskDegerlendirme(id, riskDegerlendirmeDTO);
        return new ResponseEntity<>("Risk değerlendirmesi başarıyla güncellendi!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRiskDegerlendirme(@PathVariable Long id) {
        riskDegerlendirmeService.deleteRiskDegerlendirme(id);
        return new ResponseEntity<>("Risk değerlendirmesi başarıyla silindi!", HttpStatus.OK);
    }
}
