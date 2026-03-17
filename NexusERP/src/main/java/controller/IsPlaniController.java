package controller;

import dto.IsPlaniDTO;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import model.IsPlani;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.IsPlani1Service;

import java.util.List;

@RestController
@RequestMapping("/is-plani")
public class IsPlaniController {

    private final IsPlani1Service isPlani1Service;

    @Autowired
    public IsPlaniController(IsPlani1Service isPlani1Service) {
        this.isPlani1Service = isPlani1Service;
    }

    @GetMapping
    public List<IsPlani> getAllIsPlani() {
        return isPlani1Service.getAllIsPlani();
    }

    @GetMapping("/{id}")
    public IsPlani getIsPlaniById(@PathVariable Long id) {
        return isPlani1Service.getIsPlaniById(id);
    }

    @PostMapping
    public IsPlani createIsPlani(@RequestBody IsPlaniDTO isPlaniDTO) {
        IsPlani isPlani = new IsPlani();
        isPlani.setIsAdi(isPlaniDTO.getIsAdi());
        isPlani.setBaslangicTarihi(isPlaniDTO.getBaslangicTarihi());
        isPlani.setBitisTarihi(isPlaniDTO.getBitisTarihi());
        isPlani.setDurum(isPlaniDTO.getDurum());
        return isPlani1Service.createIsPlani(isPlani);
    }

    @PutMapping("/{id}")
    public IsPlani updateIsPlani(@PathVariable Long id, @RequestBody IsPlaniDTO isPlaniDTO) {
        IsPlani isPlani = new IsPlani();
        isPlani.setIsAdi(isPlaniDTO.getIsAdi());
        isPlani.setBaslangicTarihi(isPlaniDTO.getBaslangicTarihi());
        isPlani.setBitisTarihi(isPlaniDTO.getBitisTarihi());
        isPlani.setDurum(isPlaniDTO.getDurum());
        return isPlani1Service.updateIsPlani(id, isPlani);
    }

    @DeleteMapping("/{id}")
    public boolean deleteIsPlani(@PathVariable Long id) {
        return isPlani1Service.deleteIsPlani(id);
    }

    @PostMapping("/{id}/execute")
    public void executeIsPlani(@PathVariable Long id) {
        isPlani1Service.executeIsPlani(id);
    }
}
