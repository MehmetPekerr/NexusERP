package service;

import model.Depo;
import repository.DepoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepoService {

    @Autowired
    private DepoRepository depoRepository;

    // Tüm depo verilerini getir
    public List<Depo> getAllDepo() {
        return depoRepository.findAll();
    }

    // ID ile depo verisini getir
    public Depo getDepoById(Long id) {
        Optional<Depo> depo = depoRepository.findById(id);
        return depo.orElse(null);
    }

    // Yeni depo verisi oluştur
    public Depo createDepo(Depo depo) {
        return depoRepository.save(depo);
    }

    // Depo verisini güncelle
    public Depo updateDepo(Long id, Depo depo) {
        if (depoRepository.existsById(id)) {
            depo.setId(id); // var olan ID'yi güncelle
            return depoRepository.save(depo);
        }
        return null; // Eğer ID mevcut değilse null döner
    }

    // Depo verisini sil
    public boolean deleteDepo(Long id) {
        if (depoRepository.existsById(id)) {
            depoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
