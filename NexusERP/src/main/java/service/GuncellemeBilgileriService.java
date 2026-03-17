package service;

import model.GuncellemeBilgileri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.GuncellemeBilgileriRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GuncellemeBilgileriService {

    private final GuncellemeBilgileriRepository guncellemeBilgileriRepository;

    @Autowired
    public GuncellemeBilgileriService(GuncellemeBilgileriRepository guncellemeBilgileriRepository) {
        this.guncellemeBilgileriRepository = guncellemeBilgileriRepository;
    }

    // Tüm güncelleme bilgilerini listele
    public List<GuncellemeBilgileri> getAllGuncellemeBilgileri() {
        return guncellemeBilgileriRepository.findAll();
    }

    // ID ile güncelleme bilgisi al
    public GuncellemeBilgileri getGuncellemeBilgileriById(Long id) {
        Optional<GuncellemeBilgileri> guncellemeBilgileri = guncellemeBilgileriRepository.findById(id);
        return guncellemeBilgileri.orElse(null); // Eğer bulunamazsa null döner
    }

    // Yeni güncelleme bilgisi oluştur
    public GuncellemeBilgileri createGuncellemeBilgileri(GuncellemeBilgileri guncellemeBilgileri) {
        return guncellemeBilgileriRepository.save(guncellemeBilgileri);
    }

    // Güncelleme bilgisi güncelle
    public GuncellemeBilgileri updateGuncellemeBilgileri(Long id, GuncellemeBilgileri guncellemeBilgileri) {
        if (guncellemeBilgileriRepository.existsById(id)) {
            guncellemeBilgileri.setId(id); // Mevcut ID'yi güncelleme nesnesine set ediyoruz
            return guncellemeBilgileriRepository.save(guncellemeBilgileri);
        }
        return null; // Eğer ID bulunamazsa null döner
    }

    // Güncelleme bilgisi sil
    public boolean deleteGuncellemeBilgileri(Long id) {
        if (guncellemeBilgileriRepository.existsById(id)) {
            guncellemeBilgileriRepository.deleteById(id);
            return true;
        }
        return false; // Eğer ID bulunamazsa false döner
    }
}
