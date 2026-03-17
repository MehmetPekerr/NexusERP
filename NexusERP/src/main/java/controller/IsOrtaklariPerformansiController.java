package controller;

import dto.IsOrtaklariPerformansiDTO;
import model.IsOrtaklariPerformansi;
import service.IsOrtaklariPerformansiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/is-ortaklari-performansi")
public class IsOrtaklariPerformansiController {

    private final IsOrtaklariPerformansiService isOrtaklariPerformansiService;

    @Autowired
    public IsOrtaklariPerformansiController(IsOrtaklariPerformansiService isOrtaklariPerformansiService) {
        this.isOrtaklariPerformansiService = isOrtaklariPerformansiService;
    }

    // Tüm iş ortakları performansını listele
    @GetMapping
    public List<IsOrtaklariPerformansiDTO> getAllIsOrtaklariPerformansi() {
        List<IsOrtaklariPerformansi> performansList = isOrtaklariPerformansiService.getAllIsOrtaklariPerformansi();
        return performansList.stream()
                .map(performans -> new IsOrtaklariPerformansiDTO(
                        performans.getId(),
                        // PlanAdi burada artık kullanılmıyor
                        performans.getIsOrtakAdi(),
                        performans.getPerformansSkoru(),
                        performans.getYil(),
                        performans.getAylikPerformans()))
                .collect(Collectors.toList());
    }

    // ID ile iş ortağı performansını al
    @GetMapping("/{id}")
    public ResponseEntity<IsOrtaklariPerformansiDTO> getIsOrtaklariPerformansiById(@PathVariable Long id) {
        IsOrtaklariPerformansi performans = isOrtaklariPerformansiService.getIsOrtaklariPerformansiById(id);
        if (performans == null) {
            return ResponseEntity.notFound().build();
        }
        IsOrtaklariPerformansiDTO performansDTO = new IsOrtaklariPerformansiDTO(
                performans.getId(),
                // PlanAdi burada artık kullanılmıyor
                performans.getIsOrtakAdi(),
                performans.getPerformansSkoru(),
                performans.getYil(),
                performans.getAylikPerformans());
        return ResponseEntity.ok(performansDTO);
    }

    // Yeni iş ortağı performansı oluştur
    @PostMapping
    public ResponseEntity<IsOrtaklariPerformansiDTO> createIsOrtaklariPerformansi(@RequestBody IsOrtaklariPerformansi performans) {
        IsOrtaklariPerformansi createdPerformans = isOrtaklariPerformansiService.createIsOrtaklariPerformansi(performans);
        IsOrtaklariPerformansiDTO createdDTO = new IsOrtaklariPerformansiDTO(
                createdPerformans.getId(),
                // PlanAdi burada artık kullanılmıyor
                createdPerformans.getIsOrtakAdi(),
                createdPerformans.getPerformansSkoru(),
                createdPerformans.getYil(),
                createdPerformans.getAylikPerformans());
        return ResponseEntity.ok(createdDTO);
    }

    // İş ortağı performansını güncelle
    @PutMapping("/{id}")
    public ResponseEntity<IsOrtaklariPerformansiDTO> updateIsOrtaklariPerformansi(@PathVariable Long id, @RequestBody IsOrtaklariPerformansi performans) {
        IsOrtaklariPerformansi updatedPerformans = isOrtaklariPerformansiService.updateIsOrtaklariPerformansi(id, performans);
        if (updatedPerformans == null) {
            return ResponseEntity.notFound().build();
        }
        IsOrtaklariPerformansiDTO updatedDTO = new IsOrtaklariPerformansiDTO(
                updatedPerformans.getId(),
                // PlanAdi burada artık kullanılmıyor
                updatedPerformans.getIsOrtakAdi(),
                updatedPerformans.getPerformansSkoru(),
                updatedPerformans.getYil(),
                updatedPerformans.getAylikPerformans());
        return ResponseEntity.ok(updatedDTO);
    }

    // İş ortağı performansını sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIsOrtaklariPerformansi(@PathVariable Long id) {
        boolean isDeleted = isOrtaklariPerformansiService.deleteIsOrtaklariPerformansi(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
