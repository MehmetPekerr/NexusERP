package controller;

import dto.EkipmanBakimDTO;
import model.EkipmanBakim;
import service.EkipmanBakimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller  // Bu sınıf bir Controller olarak çalışacak
@RequestMapping("/bakim")  // Bakım sayfasının URL yolu
public class EkipmanBakimController {

    private final EkipmanBakimService ekipmanBakimService;

    @Autowired
    public EkipmanBakimController(EkipmanBakimService ekipmanBakimService) {
        this.ekipmanBakimService = ekipmanBakimService;
    }

    @GetMapping
    public String showBakimPage() {
        return "bakim"; // bakim.html dosyasına yönlendirir
    }

    @GetMapping("/api")
    public ResponseEntity<List<EkipmanBakimDTO>> getAllEkipmanBakimlar() {
        List<EkipmanBakim> ekipmanBakimlar = ekipmanBakimService.getAllEkipmanBakimlar();
        List<EkipmanBakimDTO> ekipmanBakimDTOList = ekipmanBakimlar.stream()
                .map(ekipmanBakim -> new EkipmanBakimDTO(
                        ekipmanBakim.getId(),
                        ekipmanBakim.getEkipmanAdi(),
                        ekipmanBakim.getBakimTarihi(),
                        ekipmanBakim.getBakimYapanPersonel()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(ekipmanBakimDTOList);
    }

    @GetMapping("/api/{id}")
    public ResponseEntity<EkipmanBakimDTO> getEkipmanBakimById(@PathVariable Long id) {
        EkipmanBakim ekipmanBakim = ekipmanBakimService.getEkipmanBakimById(id);
        if (ekipmanBakim == null) {
            return ResponseEntity.notFound().build();
        }
        EkipmanBakimDTO ekipmanBakimDTO = new EkipmanBakimDTO(
                ekipmanBakim.getId(),
                ekipmanBakim.getEkipmanAdi(),
                ekipmanBakim.getBakimTarihi(),
                ekipmanBakim.getBakimYapanPersonel());
        return ResponseEntity.ok(ekipmanBakimDTO);
    }

    @PostMapping("/api")
    public ResponseEntity<EkipmanBakimDTO> createEkipmanBakim(@RequestBody EkipmanBakim ekipmanBakim) {
        EkipmanBakim createdEkipmanBakim = ekipmanBakimService.createEkipmanBakim(ekipmanBakim);
        EkipmanBakimDTO createdDTO = new EkipmanBakimDTO(
                createdEkipmanBakim.getId(),
                createdEkipmanBakim.getEkipmanAdi(),
                createdEkipmanBakim.getBakimTarihi(),
                createdEkipmanBakim.getBakimYapanPersonel());
        return ResponseEntity.ok(createdDTO);
    }

    @PutMapping("/api/{id}")
    public ResponseEntity<EkipmanBakimDTO> updateEkipmanBakim(@PathVariable Long id, @RequestBody EkipmanBakim ekipmanBakim) {
        EkipmanBakim updatedEkipmanBakim = ekipmanBakimService.updateEkipmanBakim(id, ekipmanBakim);
        if (updatedEkipmanBakim == null) {
            return ResponseEntity.notFound().build();
        }
        EkipmanBakimDTO updatedDTO = new EkipmanBakimDTO(
                updatedEkipmanBakim.getId(),
                updatedEkipmanBakim.getEkipmanAdi(),
                updatedEkipmanBakim.getBakimTarihi(),
                updatedEkipmanBakim.getBakimYapanPersonel());
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/api/{id}")
    public ResponseEntity<Void> deleteEkipmanBakim(@PathVariable Long id) {
        boolean isDeleted = ekipmanBakimService.deleteEkipmanBakim(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
