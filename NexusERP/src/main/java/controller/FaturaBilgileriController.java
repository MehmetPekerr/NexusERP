package controller;

import dto.FaturaBilgileriDTO;
import model.FaturaBilgileri;
import service.FaturaBilgileriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/fatura-bilgileri")
public class FaturaBilgileriController {

    private final FaturaBilgileriService faturaBilgileriService;

    @Autowired
    public FaturaBilgileriController(FaturaBilgileriService faturaBilgileriService) {
        this.faturaBilgileriService = faturaBilgileriService;
    }

    // Tüm fatura bilgilerini listele
    @GetMapping
    public List<FaturaBilgileriDTO> getAllFaturaBilgileri() {
        List<FaturaBilgileri> faturaBilgileriList = faturaBilgileriService.getAllFaturaBilgileri();
        return faturaBilgileriList.stream()
                .map(fatura -> new FaturaBilgileriDTO(
                        fatura.getId(),
                        fatura.getFaturaNo(),
                        fatura.getFaturaTarihi(),
                        fatura.getTutar(),
                        fatura.getMusteriAdi(),
                        fatura.getSiparis().getId()))
                .collect(Collectors.toList());
    }

    // ID ile fatura bilgisini al
    @GetMapping("/{id}")
    public ResponseEntity<FaturaBilgileriDTO> getFaturaBilgileriById(@PathVariable Long id) {
        FaturaBilgileri faturaBilgileri = faturaBilgileriService.getFaturaBilgileriById(id);
        if (faturaBilgileri == null) {
            return ResponseEntity.notFound().build();
        }
        FaturaBilgileriDTO faturaBilgileriDTO = new FaturaBilgileriDTO(
                faturaBilgileri.getId(),
                faturaBilgileri.getFaturaNo(),
                faturaBilgileri.getFaturaTarihi(),
                faturaBilgileri.getTutar(),
                faturaBilgileri.getMusteriAdi(),
                faturaBilgileri.getSiparis().getId());
        return ResponseEntity.ok(faturaBilgileriDTO);
    }
}
