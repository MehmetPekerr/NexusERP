package controller;

import dto.UrunEldeEtmeSureciDTO;
import model.UrunEldeEtmeSureci;
import service.UrunEldeEtmeSureciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/urun-elde-etme-sureci")
public class UrunEldeEtmeSureciController {

    @Autowired
    private UrunEldeEtmeSureciService urunEldeEtmeSureciService;

    // UrunEldeEtmeSureci oluşturma
    @PostMapping
    public UrunEldeEtmeSureci createUrunEldeEtmeSureci(@RequestBody UrunEldeEtmeSureciDTO dto) {
        return urunEldeEtmeSureciService.saveUrunEldeEtmeSureci(dto);
    }

    // ID'ye göre UrunEldeEtmeSureci alma
    @GetMapping("/{id}")
    public UrunEldeEtmeSureciDTO getUrunEldeEtmeSureci(@PathVariable Long id) {
        UrunEldeEtmeSureci urunEldeEtmeSureci = urunEldeEtmeSureciService.getUrunEldeEtmeSureci(id);
        return urunEldeEtmeSureciService.convertToDTO(urunEldeEtmeSureci);
    }
}
