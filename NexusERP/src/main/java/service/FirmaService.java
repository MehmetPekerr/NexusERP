package service;

import model.Firma;
import repository.FirmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FirmaService {

    private final FirmaRepository firmaRepository;

    @Autowired
    public FirmaService(FirmaRepository firmaRepository) {
        this.firmaRepository = firmaRepository;
    }

    // Tüm firmaları listele
    public List<Firma> getAllFirmalar() {
        return firmaRepository.findAll();
    }

    // ID ile firma getir
    public Firma getFirmaById(Long id) {
        Optional<Firma> firma = firmaRepository.findById(id);
        return firma.orElse(null); // Eğer firma bulunamazsa null döner
    }

    // Yeni firma oluştur
    public Firma createFirma(Firma firma) {
        return firmaRepository.save(firma);
    }

    // Firma güncelle
    public Firma updateFirma(Long id, Firma firma) {
        // Firma var mı kontrol et
        if (firmaRepository.existsById(id)) {
            firma.setId(id); // Güncelleme yapmak için id'yi ayarla
            return firmaRepository.save(firma);
        }
        return null;
    }

    // Firma sil
    public boolean deleteFirma(Long id) {
        if (firmaRepository.existsById(id)) {
            firmaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
