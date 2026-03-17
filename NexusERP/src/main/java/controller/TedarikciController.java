package controller;

import dto.TedarikciDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.TedarikciService;

import java.util.List;

@RestController
@RequestMapping("/api/tedarikciler")
public class TedarikciController {

    private final TedarikciService tedarikciService;

    @Autowired
    public TedarikciController(TedarikciService tedarikciService) {
        this.tedarikciService = tedarikciService;
    }

    @GetMapping
    public ResponseEntity<List<TedarikciDTO>> getAllTedarikciler() {
        List<TedarikciDTO> tedarikciler = tedarikciService.getAllTedarikciler();
        return ResponseEntity.ok(tedarikciler);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TedarikciDTO> getTedarikciById(@PathVariable Long id) {
        TedarikciDTO tedarikciDTO = tedarikciService.getTedarikciById(id);
        return ResponseEntity.ok(tedarikciDTO);
    }

    @PostMapping
    public ResponseEntity<Void> createTedarikci(@RequestBody TedarikciDTO tedarikciDTO) {
        tedarikciService.createTedarikci(tedarikciDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTedarikci(@PathVariable Long id, @RequestBody TedarikciDTO tedarikciDTO) {
        tedarikciService.updateTedarikci(id, tedarikciDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTedarikci(@PathVariable Long id) {
        tedarikciService.deleteTedarikci(id);
        return ResponseEntity.ok().build();
    }
}
