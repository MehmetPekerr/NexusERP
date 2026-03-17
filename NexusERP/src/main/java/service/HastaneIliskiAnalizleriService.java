package service;

import model.HastaneIliskiAnalizleri;
import repository.HastaneIliskiAnalizleriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HastaneIliskiAnalizleriService {

    private final HastaneIliskiAnalizleriRepository hastaneIliskiAnalizleriRepository;

    @Autowired
    public HastaneIliskiAnalizleriService(HastaneIliskiAnalizleriRepository hastaneIliskiAnalizleriRepository) {
        this.hastaneIliskiAnalizleriRepository = hastaneIliskiAnalizleriRepository;
    }

    // Tüm hastane ilişki analizlerini getir
    public List<HastaneIliskiAnalizleri> getAllHastaneIliskiAnalizleri() {
        return hastaneIliskiAnalizleriRepository.findAll();
    }

    // ID ile hastane ilişki analizini getir
    public HastaneIliskiAnalizleri getHastaneIliskiAnalizleriById(Long id) {
        Optional<HastaneIliskiAnalizleri> result = hastaneIliskiAnalizleriRepository.findById(id);
        return result.orElse(null);  // Eğer bulunmazsa null döner
    }

    // Yeni hastane ilişki analizi oluştur
    public HastaneIliskiAnalizleri createHastaneIliskiAnalizleri(HastaneIliskiAnalizleri hastaneIliskiAnalizleri) {
        return hastaneIliskiAnalizleriRepository.save(hastaneIliskiAnalizleri);
    }

    // Hastane ilişki analizini güncelle
    public HastaneIliskiAnalizleri updateHastaneIliskiAnalizleri(Long id, HastaneIliskiAnalizleri hastaneIliskiAnalizleri) {
        if (hastaneIliskiAnalizleriRepository.existsById(id)) {
            hastaneIliskiAnalizleri.setId(id);
            return hastaneIliskiAnalizleriRepository.save(hastaneIliskiAnalizleri);
        }
        return null;  // Eğer kayıt yoksa null döner
    }

    // Hastane ilişki analizini sil
    public boolean deleteHastaneIliskiAnalizleri(Long id) {
        if (hastaneIliskiAnalizleriRepository.existsById(id)) {
            hastaneIliskiAnalizleriRepository.deleteById(id);
            return true;
        }
        return false;  // Eğer kayıt yoksa false döner
    }
}
