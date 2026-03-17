package controller;

import dto.BilgiGuvenligiPolitikalariDTO;
import model.BilgiGuvenligiPolitikalari;
import service.BilgiGuvenligiPolitikalariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/bilgi-guvenligi-politikalari")
public class BilgiGuvenligiPolitikalariController {

    @Autowired
    private BilgiGuvenligiPolitikalariService bilgiGuvenligiPolitikalariService;

    // Tüm bilgi güvenliği politikalarını listele
    @GetMapping
    public List<BilgiGuvenligiPolitikalariDTO> getAllBilgiGuvenligiPolitikalari() {
        List<BilgiGuvenligiPolitikalari> bilgiGuvenligiPolitikalariList = bilgiGuvenligiPolitikalariService.getAllPolitikalari();
        return bilgiGuvenligiPolitikalariList.stream()
                .map(politika -> new BilgiGuvenligiPolitikalariDTO(
                        politika.getId(),
                        politika.getPolitikaAdi(),
                        politika.getGuncellemeTarihi(),
                        politika.getUygulamaAlanlari()))
                .collect(Collectors.toList());
    }

    // ID ile bilgi güvenliği politikasını al
    @GetMapping("/{id}")
    public ResponseEntity<BilgiGuvenligiPolitikalariDTO> getBilgiGuvenligiPolitikalariById(@PathVariable Long id) {
        BilgiGuvenligiPolitikalari bilgiGuvenligiPolitikalari = bilgiGuvenligiPolitikalariService.getPolitikaById(id).orElse(null);
        if (bilgiGuvenligiPolitikalari == null) {
            return ResponseEntity.notFound().build();
        }
        BilgiGuvenligiPolitikalariDTO bilgiGuvenligiPolitikalariDTO = new BilgiGuvenligiPolitikalariDTO(
                bilgiGuvenligiPolitikalari.getId(),
                bilgiGuvenligiPolitikalari.getPolitikaAdi(),
                bilgiGuvenligiPolitikalari.getGuncellemeTarihi(),
                bilgiGuvenligiPolitikalari.getUygulamaAlanlari());
        return ResponseEntity.ok(bilgiGuvenligiPolitikalariDTO);
    }

    // Yeni bilgi güvenliği politikası oluştur
    @PostMapping
    public ResponseEntity<BilgiGuvenligiPolitikalariDTO> createBilgiGuvenligiPolitikalari(@RequestBody BilgiGuvenligiPolitikalari bilgiGuvenligiPolitikalari) {
        BilgiGuvenligiPolitikalari createdBilgiGuvenligiPolitikalari = bilgiGuvenligiPolitikalariService.createPolitika(bilgiGuvenligiPolitikalari);
        BilgiGuvenligiPolitikalariDTO createdDTO = new BilgiGuvenligiPolitikalariDTO(
                createdBilgiGuvenligiPolitikalari.getId(),
                createdBilgiGuvenligiPolitikalari.getPolitikaAdi(),
                createdBilgiGuvenligiPolitikalari.getGuncellemeTarihi(),
                createdBilgiGuvenligiPolitikalari.getUygulamaAlanlari());
        return ResponseEntity.ok(createdDTO);
    }

    // Bilgi güvenliği politikasını güncelle
    @PutMapping("/{id}")
    public ResponseEntity<BilgiGuvenligiPolitikalariDTO> updateBilgiGuvenligiPolitikalari(
            @PathVariable Long id, @RequestBody BilgiGuvenligiPolitikalari bilgiGuvenligiPolitikalari) {
        BilgiGuvenligiPolitikalari updatedBilgiGuvenligiPolitikalari = bilgiGuvenligiPolitikalariService.updatePolitika(id, bilgiGuvenligiPolitikalari);
        if (updatedBilgiGuvenligiPolitikalari == null) {
            return ResponseEntity.notFound().build();
        }
        BilgiGuvenligiPolitikalariDTO updatedDTO = new BilgiGuvenligiPolitikalariDTO(
                updatedBilgiGuvenligiPolitikalari.getId(),
                updatedBilgiGuvenligiPolitikalari.getPolitikaAdi(),
                updatedBilgiGuvenligiPolitikalari.getGuncellemeTarihi(),
                updatedBilgiGuvenligiPolitikalari.getUygulamaAlanlari());
        return ResponseEntity.ok(updatedDTO);
    }

    // Bilgi güvenliği politikasını sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBilgiGuvenligiPolitikalari(@PathVariable Long id) {
        boolean isDeleted = bilgiGuvenligiPolitikalariService.deletePolitika(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
