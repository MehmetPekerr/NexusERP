package controller;

import dto.FirmaDTO;
import model.Firma;
import service.FirmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/firma")
public class FirmaController {

    private final FirmaService firmaService;

    @Autowired
    public FirmaController(FirmaService firmaService) {
        this.firmaService = firmaService;
    }

    // Tüm firmaları listele
    @GetMapping
    public List<FirmaDTO> getAllFirmalar() {
        List<Firma> firmalar = firmaService.getAllFirmalar();
        return firmalar.stream()
                .map(firma -> new FirmaDTO(
                        firma.getId(),
                        firma.getFirmaAdi(),
                        firma.getFirmaAdres(),
                        firma.getFirmaTelefon()))
                .collect(Collectors.toList());
    }

    // ID ile firma bilgilerini al
    @GetMapping("/{id}")
    public ResponseEntity<FirmaDTO> getFirmaById(@PathVariable Long id) {
        Firma firma = firmaService.getFirmaById(id);
        if (firma == null) {
            return ResponseEntity.notFound().build();
        }
        FirmaDTO firmaDTO = new FirmaDTO(
                firma.getId(),
                firma.getFirmaAdi(),
                firma.getFirmaAdres(),
                firma.getFirmaTelefon());
        return ResponseEntity.ok(firmaDTO);
    }

    // Yeni firma oluştur
    @PostMapping
    public ResponseEntity<FirmaDTO> createFirma(@RequestBody Firma firma) {
        Firma createdFirma = firmaService.createFirma(firma);
        FirmaDTO createdDTO = new FirmaDTO(
                createdFirma.getId(),
                createdFirma.getFirmaAdi(),
                createdFirma.getFirmaAdres(),
                createdFirma.getFirmaTelefon());
        return ResponseEntity.ok(createdDTO);
    }

    // Firma bilgilerini güncelle
    @PutMapping("/{id}")
    public ResponseEntity<FirmaDTO> updateFirma(@PathVariable Long id, @RequestBody Firma firma) {
        Firma updatedFirma = firmaService.updateFirma(id, firma);
        if (updatedFirma == null) {
            return ResponseEntity.notFound().build();
        }
        FirmaDTO updatedDTO = new FirmaDTO(
                updatedFirma.getId(),
                updatedFirma.getFirmaAdi(),
                updatedFirma.getFirmaAdres(),
                updatedFirma.getFirmaTelefon());
        return ResponseEntity.ok(updatedDTO);
    }

    // Firma sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFirma(@PathVariable Long id) {
        boolean isDeleted = firmaService.deleteFirma(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
