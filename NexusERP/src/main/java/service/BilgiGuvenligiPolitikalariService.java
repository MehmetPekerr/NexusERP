package service;

import model.BilgiGuvenligiPolitikalari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BilgiGuvenligiPolitikalariRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BilgiGuvenligiPolitikalariService {

    private final BilgiGuvenligiPolitikalariRepository bilgiGuvenligiPolitikalariRepository;

    @Autowired
    public BilgiGuvenligiPolitikalariService(BilgiGuvenligiPolitikalariRepository bilgiGuvenligiPolitikalariRepository) {
        this.bilgiGuvenligiPolitikalariRepository = bilgiGuvenligiPolitikalariRepository;
    }

    // Tüm politikaları getirme
    public List<BilgiGuvenligiPolitikalari> getAllPolitikalari() {
        return bilgiGuvenligiPolitikalariRepository.findAll();
    }

    // ID ile politika getirme
    public Optional<BilgiGuvenligiPolitikalari> getPolitikaById(Long id) {
        return bilgiGuvenligiPolitikalariRepository.findById(id);
    }

    // Politika adı ile politika arama
    public BilgiGuvenligiPolitikalari getPolitikaByName(String politikaAdi) {
        return bilgiGuvenligiPolitikalariRepository.findByPolitikaAdi(politikaAdi);
    }

    // Yeni politika ekleme
    public BilgiGuvenligiPolitikalari createPolitika(BilgiGuvenligiPolitikalari yeniPolitika) {
        return bilgiGuvenligiPolitikalariRepository.save(yeniPolitika);
    }

    // Mevcut bir politikayı güncelleme
    public BilgiGuvenligiPolitikalari updatePolitika(Long id, BilgiGuvenligiPolitikalari guncellenmisPolitika) {
        if (bilgiGuvenligiPolitikalariRepository.existsById(id)) {
            guncellenmisPolitika.setId(id);
            return bilgiGuvenligiPolitikalariRepository.save(guncellenmisPolitika);
        } else {
            return null; // ID bulunamadıysa null döner
        }
    }

    // Politika silme
    public boolean deletePolitika(Long id) {
        if (bilgiGuvenligiPolitikalariRepository.existsById(id)) {
            bilgiGuvenligiPolitikalariRepository.deleteById(id);
            return true;
        } else {
            return false; // ID bulunamadıysa false döner
        }
    }
}
