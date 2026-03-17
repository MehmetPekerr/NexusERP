package controller;

import dto.HastaneIliskiAnalizleriDTO;
import model.HastaneIliskiAnalizleri;
import model.Firma;
import service.HastaneIliskiAnalizleriService;
import service.FirmaService; // FirmaService'i ekliyoruz
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hastane-iliski-analizleri")
public class HastaneIliskiAnalizleriController {

    private final HastaneIliskiAnalizleriService hastaneIliskiAnalizleriService;
    private final FirmaService firmaService; // FirmaService dependency

    @Autowired
    public HastaneIliskiAnalizleriController(HastaneIliskiAnalizleriService hastaneIliskiAnalizleriService, FirmaService firmaService) {
        this.hastaneIliskiAnalizleriService = hastaneIliskiAnalizleriService;
        this.firmaService = firmaService;
    }

    // Yeni hastane ilişki analizi oluştur
    @PostMapping
    public ResponseEntity<HastaneIliskiAnalizleriDTO> createHastaneIliskiAnalizleri(@RequestBody HastaneIliskiAnalizleriDTO hastaneIliskiAnalizleriDTO) {
        Firma firma = firmaService.getFirmaById(hastaneIliskiAnalizleriDTO.getFirmaId());
        if (firma == null) {
            return ResponseEntity.notFound().build();
        }

        HastaneIliskiAnalizleri hastaneIliskiAnalizleri = new HastaneIliskiAnalizleri(
                null,
                hastaneIliskiAnalizleriDTO.getHastaneAdi(),
                hastaneIliskiAnalizleriDTO.getIliskiTuru(),
                hastaneIliskiAnalizleriDTO.getAnalizTarihi(),
                hastaneIliskiAnalizleriDTO.getSonuc(),
                firma
        );

        HastaneIliskiAnalizleri createdHastaneIliskiAnalizleri = hastaneIliskiAnalizleriService.createHastaneIliskiAnalizleri(hastaneIliskiAnalizleri);
        HastaneIliskiAnalizleriDTO createdDTO = new HastaneIliskiAnalizleriDTO(
                createdHastaneIliskiAnalizleri.getId(),
                createdHastaneIliskiAnalizleri.getHastaneAdi(),
                createdHastaneIliskiAnalizleri.getIliskiTuru(),
                createdHastaneIliskiAnalizleri.getAnalizTarihi(),
                createdHastaneIliskiAnalizleri.getSonuc(),
                createdHastaneIliskiAnalizleri.getFirma().getId()
        );

        return ResponseEntity.ok(createdDTO);
    }
}
