package controller;

import dto.GuncellemeBilgileriDTO;
import model.GuncellemeBilgileri;
import service.GuncellemeBilgileriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/guncelleme-bilgileri")
public class GuncellemeBilgileriController {

    private final GuncellemeBilgileriService guncellemeBilgileriService;

    @Autowired
    public GuncellemeBilgileriController(GuncellemeBilgileriService guncellemeBilgileriService) {
        this.guncellemeBilgileriService = guncellemeBilgileriService;
    }

    // Tüm güncelleme bilgilerini listele
    @GetMapping
    public List<GuncellemeBilgileriDTO> getAllGuncellemeBilgileri() {
        List<GuncellemeBilgileri> guncellemeBilgileriList = guncellemeBilgileriService.getAllGuncellemeBilgileri();
        return guncellemeBilgileriList.stream()
                .map(guncellemeBilgileri -> new GuncellemeBilgileriDTO(
                        guncellemeBilgileri.getId(),
                        guncellemeBilgileri.getGuncellemeTarihi(),
                        guncellemeBilgileri.getAciklama(),
                        guncellemeBilgileri.getUrunler().stream()
                            .map(urun -> urun.getId()) // Urunlerin ID'lerini almak
                            .collect(Collectors.toSet())))
                .collect(Collectors.toList());
    }

    // ID ile güncelleme bilgisi al
    @GetMapping("/{id}")
    public ResponseEntity<GuncellemeBilgileriDTO> getGuncellemeBilgileriById(@PathVariable Long id) {
        GuncellemeBilgileri guncellemeBilgileri = guncellemeBilgileriService.getGuncellemeBilgileriById(id);
        if (guncellemeBilgileri == null) {
            return ResponseEntity.notFound().build();
        }

        GuncellemeBilgileriDTO guncellemeBilgileriDTO = new GuncellemeBilgileriDTO(
                guncellemeBilgileri.getId(),
                guncellemeBilgileri.getGuncellemeTarihi(),
                guncellemeBilgileri.getAciklama(),
                guncellemeBilgileri.getUrunler().stream()
                    .map(urun -> urun.getId()) // Urunlerin ID'lerini almak
                    .collect(Collectors.toSet()));
        return ResponseEntity.ok(guncellemeBilgileriDTO);
    }

    // Yeni güncelleme bilgisi oluştur
    @PostMapping
    public ResponseEntity<GuncellemeBilgileriDTO> createGuncellemeBilgileri(@RequestBody GuncellemeBilgileri guncellemeBilgileri) {
        GuncellemeBilgileri createdGuncellemeBilgileri = guncellemeBilgileriService.createGuncellemeBilgileri(guncellemeBilgileri);
        GuncellemeBilgileriDTO createdDTO = new GuncellemeBilgileriDTO(
                createdGuncellemeBilgileri.getId(),
                createdGuncellemeBilgileri.getGuncellemeTarihi(),
                createdGuncellemeBilgileri.getAciklama(),
                createdGuncellemeBilgileri.getUrunler().stream()
                    .map(urun -> urun.getId()) // Urunlerin ID'lerini almak
                    .collect(Collectors.toSet()));
        return ResponseEntity.ok(createdDTO);
    }

    // Güncelleme bilgisini güncelle
    @PutMapping("/{id}")
    public ResponseEntity<GuncellemeBilgileriDTO> updateGuncellemeBilgileri(@PathVariable Long id, @RequestBody GuncellemeBilgileri guncellemeBilgileri) {
        GuncellemeBilgileri updatedGuncellemeBilgileri = guncellemeBilgileriService.updateGuncellemeBilgileri(id, guncellemeBilgileri);
        if (updatedGuncellemeBilgileri == null) {
            return ResponseEntity.notFound().build();
        }

        GuncellemeBilgileriDTO updatedDTO = new GuncellemeBilgileriDTO(
                updatedGuncellemeBilgileri.getId(),
                updatedGuncellemeBilgileri.getGuncellemeTarihi(),
                updatedGuncellemeBilgileri.getAciklama(),
                updatedGuncellemeBilgileri.getUrunler().stream()
                    .map(urun -> urun.getId()) // Urunlerin ID'lerini almak
                    .collect(Collectors.toSet()));
        return ResponseEntity.ok(updatedDTO);
    }

    // Güncelleme bilgisini sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuncellemeBilgileri(@PathVariable Long id) {
        boolean isDeleted = guncellemeBilgileriService.deleteGuncellemeBilgileri(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
