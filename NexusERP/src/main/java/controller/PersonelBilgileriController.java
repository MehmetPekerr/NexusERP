package controller;

import dto.PersonelBilgileriDTO;
import model.PersonelBilgileri;
import model.InsanKaynaklari;
import service.PersonelBilgileriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personel-bilgileri")
public class PersonelBilgileriController {

    private final PersonelBilgileriService personelBilgileriService;

    @Autowired
    public PersonelBilgileriController(PersonelBilgileriService personelBilgileriService) {
        this.personelBilgileriService = personelBilgileriService;
    }

    // Tüm personel bilgilerini listele
    @GetMapping
    public List<PersonelBilgileriDTO> getAllPersonel() {
        return personelBilgileriService.getAllPersonel();
    }

    // ID ile personel bilgisi al
    @GetMapping("/{id}")
    public ResponseEntity<PersonelBilgileriDTO> getPersonelById(@PathVariable Long id) {
        PersonelBilgileriDTO personelDTO = personelBilgileriService.getPersonelById(id);
        if (personelDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personelDTO);
    }

    // Yeni personel ekle
    @PostMapping
    public ResponseEntity<PersonelBilgileriDTO> createPersonel(@RequestBody PersonelBilgileri personel) {
        PersonelBilgileriDTO createdPersonelDTO = personelBilgileriService.createPersonel(personel);
        return ResponseEntity.status(201).body(createdPersonelDTO);  // HTTP 201 - Created
    }

    // Personel bilgilerini güncelle
    @PutMapping("/{id}")
    public ResponseEntity<PersonelBilgileriDTO> updatePersonel(@PathVariable Long id, @RequestBody PersonelBilgileri personel) {
        PersonelBilgileriDTO updatedPersonelDTO = personelBilgileriService.updatePersonel(id, personel);
        if (updatedPersonelDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedPersonelDTO);
    }

    // Personel bilgilerini sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonel(@PathVariable Long id) {
        boolean isDeleted = personelBilgileriService.deletePersonel(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();  // HTTP 204 - No Content
    }

    // Belirli pozisyondaki personelleri listele
    @GetMapping("/pozisyon")
    public List<PersonelBilgileriDTO> getPersonelByPozisyon(@RequestParam String pozisyon) {
        return personelBilgileriService.getPersonelByPozisyon(pozisyon);
    }
}
