package controller;

import dto.NakliyatDTO;
import model.Nakliyat;
import service.NakliyatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/nakliyat")
public class NakliyatController {

    private final NakliyatService nakliyatService;

    @Autowired
    public NakliyatController(NakliyatService nakliyatService) {
        this.nakliyatService = nakliyatService;
    }

    // Tüm nakliyatları listele
    @GetMapping
    public List<NakliyatDTO> getAllNakliyat() {
        List<Nakliyat> nakliyatList = nakliyatService.getAllNakliyat();
        return nakliyatList.stream()
                .map(nakliyat -> new NakliyatDTO(
                        nakliyat.getId(),
                        nakliyat.getIslemTipi(),
                        nakliyat.getTeslimatTarihi(),
                        nakliyat.getMiktar(),
                        nakliyat.getTeslimatAdresi(),
                        nakliyat.getUrunPaketleme() != null ? nakliyat.getUrunPaketleme().getId() : null,
                        nakliyat.getSatis() != null ? nakliyat.getSatis().getId() : null))
                .collect(Collectors.toList());
    }

    // ID ile nakliyat kaydını al
    @GetMapping("/{id}")
    public ResponseEntity<NakliyatDTO> getNakliyatById(@PathVariable Long id) {
        Nakliyat nakliyat = nakliyatService.getNakliyatById(id);
        if (nakliyat == null) {
            return ResponseEntity.notFound().build();
        }
        NakliyatDTO nakliyatDTO = new NakliyatDTO(
                nakliyat.getId(),
                nakliyat.getIslemTipi(),
                nakliyat.getTeslimatTarihi(),
                nakliyat.getMiktar(),
                nakliyat.getTeslimatAdresi(),
                nakliyat.getUrunPaketleme() != null ? nakliyat.getUrunPaketleme().getId() : null,
                nakliyat.getSatis() != null ? nakliyat.getSatis().getId() : null);
        return ResponseEntity.ok(nakliyatDTO);
    }

    // Yeni nakliyat kaydı oluştur
    @PostMapping
    public ResponseEntity<NakliyatDTO> createNakliyat(@RequestBody Nakliyat nakliyat) {
        Nakliyat createdNakliyat = nakliyatService.createNakliyat(nakliyat);
        NakliyatDTO createdDTO = new NakliyatDTO(
                createdNakliyat.getId(),
                createdNakliyat.getIslemTipi(),
                createdNakliyat.getTeslimatTarihi(),
                createdNakliyat.getMiktar(),
                createdNakliyat.getTeslimatAdresi(),
                createdNakliyat.getUrunPaketleme() != null ? createdNakliyat.getUrunPaketleme().getId() : null,
                createdNakliyat.getSatis() != null ? createdNakliyat.getSatis().getId() : null);
        return ResponseEntity.ok(createdDTO);
    }

    // Nakliyat kaydını güncelle
    @PutMapping("/{id}")
    public ResponseEntity<NakliyatDTO> updateNakliyat(@PathVariable Long id, @RequestBody Nakliyat nakliyat) {
        Nakliyat updatedNakliyat = nakliyatService.updateNakliyat(id, nakliyat);
        if (updatedNakliyat == null) {
            return ResponseEntity.notFound().build();
        }
        NakliyatDTO updatedDTO = new NakliyatDTO(
                updatedNakliyat.getId(),
                updatedNakliyat.getIslemTipi(),
                updatedNakliyat.getTeslimatTarihi(),
                updatedNakliyat.getMiktar(),
                updatedNakliyat.getTeslimatAdresi(),
                updatedNakliyat.getUrunPaketleme() != null ? updatedNakliyat.getUrunPaketleme().getId() : null,
                updatedNakliyat.getSatis() != null ? updatedNakliyat.getSatis().getId() : null);
        return ResponseEntity.ok(updatedDTO);
    }

    // Nakliyat kaydını sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNakliyat(@PathVariable Long id) {
        boolean isDeleted = nakliyatService.deleteNakliyat(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    // Teslimat tarihi aralığına göre nakliyatları listele
    @GetMapping("/teslimat-tarihi")
    public List<NakliyatDTO> getNakliyatByTeslimatTarihiBetween(@RequestParam String startDate, @RequestParam String endDate) {
        List<Nakliyat> nakliyatList = nakliyatService.getNakliyatByTeslimatTarihiBetween(startDate, endDate);
        return nakliyatList.stream()
                .map(nakliyat -> new NakliyatDTO(
                        nakliyat.getId(),
                        nakliyat.getIslemTipi(),
                        nakliyat.getTeslimatTarihi(),
                        nakliyat.getMiktar(),
                        nakliyat.getTeslimatAdresi(),
                        nakliyat.getUrunPaketleme() != null ? nakliyat.getUrunPaketleme().getId() : null,
                        nakliyat.getSatis() != null ? nakliyat.getSatis().getId() : null))
                .collect(Collectors.toList());
    }
}
