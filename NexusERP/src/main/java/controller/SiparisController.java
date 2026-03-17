package controller;

import dto.SiparisDTO;
import model.Siparis;
import service.SiparisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/siparis")
public class SiparisController {

    private final SiparisService siparisService;

    @Autowired
    public SiparisController(SiparisService siparisService) {
        this.siparisService = siparisService;
    }

    @GetMapping
    public List<SiparisDTO> getAllSiparis() {
        List<Siparis> siparisList = siparisService.getAllSiparis();
        return siparisList.stream()
                .map(siparis -> new SiparisDTO(
                        siparis.getId(),
                        siparis.getMusteriAdi(),
                        siparis.getSiparisTarihi(),
                        siparis.getToplamTutar()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SiparisDTO> getSiparisById(@PathVariable Long id) {
        Siparis siparis = siparisService.getSiparisById(id);
        if (siparis == null) {
            return ResponseEntity.notFound().build();
        }
        SiparisDTO siparisDTO = new SiparisDTO(
                siparis.getId(),
                siparis.getMusteriAdi(),
                siparis.getSiparisTarihi(),
                siparis.getToplamTutar());
        return ResponseEntity.ok(siparisDTO);
    }

    @PostMapping
    public ResponseEntity<SiparisDTO> createSiparis(@RequestBody Siparis siparis) {
        Siparis createdSiparis = siparisService.createSiparis(siparis);
        SiparisDTO createdDTO = new SiparisDTO(
                createdSiparis.getId(),
                createdSiparis.getMusteriAdi(),
                createdSiparis.getSiparisTarihi(),
                createdSiparis.getToplamTutar());
        return ResponseEntity.ok(createdDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SiparisDTO> updateSiparis(@PathVariable Long id, @RequestBody Siparis siparis) {
        Siparis updatedSiparis = siparisService.updateSiparis(id, siparis);
        if (updatedSiparis == null) {
            return ResponseEntity.notFound().build();
        }
        SiparisDTO updatedDTO = new SiparisDTO(
                updatedSiparis.getId(),
                updatedSiparis.getMusteriAdi(),
                updatedSiparis.getSiparisTarihi(),
                updatedSiparis.getToplamTutar());
        return ResponseEntity.ok(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSiparis(@PathVariable Long id) {
        boolean isDeleted = siparisService.deleteSiparis(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
