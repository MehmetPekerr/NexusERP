package service;

import model.IsOrtaklariPerformansi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IsOrtaklariPerformansiRepository;

import java.util.List;
import java.util.Optional;

@Service
public class IsOrtaklariPerformansiService {

    private final IsOrtaklariPerformansiRepository isOrtaklariPerformansiRepository;

    @Autowired
    public IsOrtaklariPerformansiService(IsOrtaklariPerformansiRepository isOrtaklariPerformansiRepository) {
        this.isOrtaklariPerformansiRepository = isOrtaklariPerformansiRepository;
    }

    // Tüm performansları listele
    public List<IsOrtaklariPerformansi> getAllIsOrtaklariPerformansi() {
        return isOrtaklariPerformansiRepository.findAll();
    }

    // ID ile performans verisini al
    public IsOrtaklariPerformansi getIsOrtaklariPerformansiById(Long id) {
        Optional<IsOrtaklariPerformansi> performans = isOrtaklariPerformansiRepository.findById(id);
        return performans.orElse(null); // Performans bulunmazsa null döner
    }

    // Yeni performans kaydı oluştur
    public IsOrtaklariPerformansi createIsOrtaklariPerformansi(IsOrtaklariPerformansi performans) {
        return isOrtaklariPerformansiRepository.save(performans); // Yeni kaydı veritabanına kaydeder
    }

    // Performans kaydını güncelle
    public IsOrtaklariPerformansi updateIsOrtaklariPerformansi(Long id, IsOrtaklariPerformansi performans) {
        if (isOrtaklariPerformansiRepository.existsById(id)) {
            performans.setId(id); // Güncellenmek istenen ID ile eşleştir
            return isOrtaklariPerformansiRepository.save(performans); // Kaydı günceller
        }
        return null; // ID bulunmazsa null döner
    }

    // Performans kaydını sil
    public boolean deleteIsOrtaklariPerformansi(Long id) {
        if (isOrtaklariPerformansiRepository.existsById(id)) {
            isOrtaklariPerformansiRepository.deleteById(id); // Kaydı siler
            return true;
        }
        return false; // ID bulunmazsa false döner
    }

    // İş ortağı adına göre performansları listele
    public List<IsOrtaklariPerformansi> getIsOrtaklariPerformansiByIsOrtakAdi(String isOrtakAdi) {
        return isOrtaklariPerformansiRepository.findByIsOrtakAdi(isOrtakAdi); // Özel sorgu kullanılır
    }

    // Performans skoru belirli bir değerin üzerinde olanları al
    public List<IsOrtaklariPerformansi> getIsOrtaklariPerformansiBySkor(double minSkor) {
        return isOrtaklariPerformansiRepository.findByPerformansSkoruGreaterThan(minSkor); // Performans skoru >= minSkor olanları döndürür
    }
}
