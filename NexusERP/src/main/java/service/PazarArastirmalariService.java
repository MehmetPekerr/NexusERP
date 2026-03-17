package service;

import model.PazarArastirmalari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PazarArastirmalariRepository;

@Service
public class PazarArastirmalariService {

    private final PazarArastirmalariRepository pazarArastirmalariRepository;

    @Autowired
    public PazarArastirmalariService(PazarArastirmalariRepository pazarArastirmalariRepository) {
        this.pazarArastirmalariRepository = pazarArastirmalariRepository;
    }

    // Pazar araştırması ekleme
    public PazarArastirmalari createPazarArastirmalari(PazarArastirmalari pazarArastirmalari) {
        return pazarArastirmalariRepository.save(pazarArastirmalari);
    }

    // Pazar araştırmasını güncelleme
    public PazarArastirmalari updatePazarArastirmalari(Long id, PazarArastirmalari pazarArastirmalari) {
        if (pazarArastirmalariRepository.existsById(id)) {
            pazarArastirmalari.setId(id);
            return pazarArastirmalariRepository.save(pazarArastirmalari);
        }
        return null;
    }

    // Pazar araştırmasını silme
    public boolean deletePazarArastirmalari(Long id) {
        if (pazarArastirmalariRepository.existsById(id)) {
            pazarArastirmalariRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
