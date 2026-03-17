package controller;

import dto.IthalatVeIhracatDTO;
import model.IthalatVeIhracat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.IthalatVeIhracatService;

import java.util.List;

@RestController
@RequestMapping("/ithalat-ve-ihracat")
public class IthalatVeIhracatController {

    @Autowired
    private IthalatVeIhracatService ithalatVeIhracatService;

    // Ithalat ve ihracat oluşturma
    @PostMapping
    public ResponseEntity<IthalatVeIhracat> createIthalatVeIhracat(@RequestBody IthalatVeIhracatDTO dto) {
        try {
            IthalatVeIhracat ithalatVeIhracat = ithalatVeIhracatService.createIthalatVeIhracat(dto);
            return new ResponseEntity<>(ithalatVeIhracat, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Ithalat ve ihracat güncelleme (isteğe bağlı)
    @PutMapping("/{id}")
    public ResponseEntity<IthalatVeIhracat> updateIthalatVeIhracat(@PathVariable Long id, @RequestBody IthalatVeIhracatDTO dto) {
        try {
            IthalatVeIhracat updatedIthalatVeIhracat = ithalatVeIhracatService.updateIthalatVeIhracat(id, dto);
            return new ResponseEntity<>(updatedIthalatVeIhracat, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Ithalat ve ihracat verisini getirme
    @GetMapping("/{id}")
    public ResponseEntity<IthalatVeIhracat> getIthalatVeIhracat(@PathVariable Long id) {
        try {
            IthalatVeIhracat ithalatVeIhracat = ithalatVeIhracatService.getIthalatVeIhracat(id);
            return new ResponseEntity<>(ithalatVeIhracat, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Ithalat ve ihracat listesini getirme
    @GetMapping
    public ResponseEntity<List<IthalatVeIhracat>> getAllIthalatVeIhracat() {
        List<IthalatVeIhracat> ithalatVeIhracatList = ithalatVeIhracatService.getAllIthalatVeIhracat();
        return new ResponseEntity<>(ithalatVeIhracatList, HttpStatus.OK);
    }

    // Ithalat ve ihracat silme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIthalatVeIhracat(@PathVariable Long id) {
        try {
            ithalatVeIhracatService.deleteIthalatVeIhracat(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
