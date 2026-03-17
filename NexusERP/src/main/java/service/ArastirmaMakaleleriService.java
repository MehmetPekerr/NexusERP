package service;
//FACADE İLE ARASTIRMA MAKALELERİNİN KARMAŞIK YAPISINI DIŞARIYA BASİTÇE SUNARIZ
import model.ArastirmaMakaleleri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ArastirmaMakaleleriRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ArastirmaMakaleleriService {

    @Autowired
    private ArastirmaMakaleleriRepository arastirmaMakaleleriRepository;

    // Facade Pattern - Kullanıcıya karmaşık işlemler yerine basit bir arayüz sağlanıyor.
    public List<ArastirmaMakaleleri> getAllArastirmaMakaleleri() {
        return arastirmaMakaleleriRepository.findAll();
    }

    public ArastirmaMakaleleri getArastirmaMakalesiById(Long id) {
        return arastirmaMakaleleriRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Arastirma Makalesi bulunamadı!"));
    }

    public ArastirmaMakaleleri createArastirmaMakalesi(ArastirmaMakaleleri arastirmaMakalesi) {
        // Burada ekstra işlemler eklenebilir, örneğin validasyon
        return arastirmaMakaleleriRepository.save(arastirmaMakalesi);
    }

    public ArastirmaMakaleleri updateArastirmaMakalesi(Long id, ArastirmaMakaleleri arastirmaMakalesi) {
        if (!arastirmaMakaleleriRepository.existsById(id)) {
            throw new IllegalArgumentException("Arastirma Makalesi bulunamadı! Güncelleme yapılamaz.");
        }
        arastirmaMakalesi.setId(id);
        return arastirmaMakaleleriRepository.save(arastirmaMakalesi);
    }

    public boolean deleteArastirmaMakalesi(Long id) {
        if (!arastirmaMakaleleriRepository.existsById(id)) {
            throw new IllegalArgumentException("Arastirma Makalesi bulunamadı! Silme işlemi yapılamaz.");
        }
        arastirmaMakaleleriRepository.deleteById(id);
        return true;
    }
}
