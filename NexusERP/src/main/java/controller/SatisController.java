package controller;

import dto.SatisDTO;
import model.Satis;
import service.SatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/satis")
public class SatisController {

    private final SatisService satisService;

    @Autowired
    public SatisController(SatisService satisService) {
        this.satisService = satisService;
    }

    @GetMapping
    public List<SatisDTO> getAllSatis() {
        List<Satis> satisList = satisService.getAllSatis();
        return satisList.stream()
                .map(satis -> new SatisDTO(
                        satis.getId(),
                        satis.getMusteriAdi(),
                        satis.getSatisTarihi(),
                        satis.getToplamTutar()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SatisDTO> getSatisById(@PathVariable Long id) {
        Satis satis = satisService.getSatisById(id);
        if (satis == null) {
            return ResponseEntity.notFound().build();
        }
        SatisDTO satisDTO = new SatisDTO(
                satis.getId(),
                satis.getMusteriAdi(),
                satis.getSatisTarihi(),
                satis.getToplamTutar());
        return ResponseEntity.ok(satisDTO);
    }

    @PostMapping
    public ResponseEntity<SatisDTO> createSatis(@RequestBody Satis satis) {
        Satis createdSatis = satisService.createSatis(satis);
        SatisDTO createdDTO = new SatisDTO(
                createdSatis.getId(),
                createdSatis.getMusteriAdi(),
                createdSatis.getSatisTarihi(),
                createdSatis.getToplamTutar());
        return ResponseEntity.ok(createdDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SatisDTO> updateSatis(@PathVariable Long id, @RequestBody Satis satis) {
        Satis updatedSatis = satisService.updateSatis(id, satis);
        if (updatedSatis == null) {
            return ResponseEntity.notFound().build();
        }
        SatisDTO updatedDTO = new SatisDTO(
                updatedSatis.getId(),
                updatedSatis.getMusteriAdi(),
                updatedSatis.getSatisTarihi(),
                updatedSatis.getToplamTutar());
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSatis(@PathVariable Long id) {
        boolean isDeleted = satisService.deleteSatis(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
