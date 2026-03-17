package service;

import model.CalisanEgitimProgramlari;
import repository.CalisanEgitimProgramlariRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalisanEgitimProgramlariService {

    @Autowired
    private CalisanEgitimProgramlariRepository calisanEgitimProgramlariRepository;

    // Tüm çalışan eğitim programlarını getir
    public List<CalisanEgitimProgramlari> getAllCalisanEgitimProgramlari() {
        return calisanEgitimProgramlariRepository.findAll();
    }

    // ID ile çalışan eğitim programını getir
    public CalisanEgitimProgramlari getCalisanEgitimProgramlariById(Long id) {
        Optional<CalisanEgitimProgramlari> calisanEgitimProgramlari = calisanEgitimProgramlariRepository.findById(id);
        return calisanEgitimProgramlari.orElse(null);
    }

    // Yeni çalışan eğitim programı oluştur
    public CalisanEgitimProgramlari createCalisanEgitimProgramlari(CalisanEgitimProgramlari calisanEgitimProgramlari) {
        return calisanEgitimProgramlariRepository.save(calisanEgitimProgramlari);
    }

    // Çalışan eğitim programını güncelle
    public CalisanEgitimProgramlari updateCalisanEgitimProgramlari(Long id, CalisanEgitimProgramlari calisanEgitimProgramlari) {
        if (!calisanEgitimProgramlariRepository.existsById(id)) {
            return null;
        }
        calisanEgitimProgramlari.setId(id);
        return calisanEgitimProgramlariRepository.save(calisanEgitimProgramlari);
    }

    // Çalışan eğitim programını sil
    public boolean deleteCalisanEgitimProgramlari(Long id) {
        if (calisanEgitimProgramlariRepository.existsById(id)) {
            calisanEgitimProgramlariRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
