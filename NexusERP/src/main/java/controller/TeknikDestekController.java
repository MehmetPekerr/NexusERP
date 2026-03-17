import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teknikdestek")
public class TeknikDestekController {

    @Autowired
    private TeknikDestekService teknikDestekService;

    // Teknik Destek kaydını oluşturma
    @PostMapping
    public ResponseEntity<TeknikDestekDTO> saveTeknikDestek(@RequestBody TeknikDestekDTO teknikDestekDTO) {
        TeknikDestekDTO savedTeknikDestek = teknikDestekService.saveTeknikDestek(teknikDestekDTO);
        return new ResponseEntity<>(savedTeknikDestek, HttpStatus.CREATED);
    }

    // Tüm Teknik Destekleri listeleme
    @GetMapping
    public ResponseEntity<List<TeknikDestekDTO>> getAllTeknikDestek() {
        List<TeknikDestekDTO> teknikDestekList = teknikDestekService.getAllTeknikDestek();
        return new ResponseEntity<>(teknikDestekList, HttpStatus.OK);
    }

    // Belirli bir Teknik Destek kaydını ID ile getirme
    @GetMapping("/{id}")
    public ResponseEntity<TeknikDestekDTO> getTeknikDestekById(@PathVariable Long id) {
        TeknikDestekDTO teknikDestekDTO = teknikDestekService.getTeknikDestekById(id);
        return new ResponseEntity<>(teknikDestekDTO, HttpStatus.OK);
    }

    // Teknik Destek kaydını güncelleme
    @PutMapping("/{id}")
    public ResponseEntity<TeknikDestekDTO> updateTeknikDestek(@PathVariable Long id, @RequestBody TeknikDestekDTO teknikDestekDTO) {
        TeknikDestekDTO updatedTeknikDestek = teknikDestekService.updateTeknikDestek(id, teknikDestekDTO);
        return new ResponseEntity<>(updatedTeknikDestek, HttpStatus.OK);
    }

    // Teknik Destek kaydını silme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeknikDestek(@PathVariable Long id) {
        teknikDestekService.deleteTeknikDestek(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
