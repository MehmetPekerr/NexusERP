package service;

import model.SatisKanallari;
import repository.SatisKanallariRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SatisKanallariServiceImpl implements SatisKanallariService {

    private final SatisKanallariRepository satisKanallariRepository;

    @Autowired
    public SatisKanallariServiceImpl(SatisKanallariRepository satisKanallariRepository) {
        this.satisKanallariRepository = satisKanallariRepository;
    }

    @Override
    public List<SatisKanallari> getAllSatisKanallari() {
        return satisKanallariRepository.findAll();
    }

    @Override
    public SatisKanallari getSatisKanallariById(Long id) {
        Optional<SatisKanallari> satisKanallari = satisKanallariRepository.findById(id);
        return satisKanallari.orElse(null);
    }

    @Override
    public SatisKanallari createSatisKanallari(SatisKanallari satisKanallari) {
        return satisKanallariRepository.save(satisKanallari);
    }

    @Override
    public SatisKanallari updateSatisKanallari(Long id, SatisKanallari satisKanallari) {
        if (satisKanallariRepository.existsById(id)) {
            satisKanallari.setId(id);
            return satisKanallariRepository.save(satisKanallari);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteSatisKanallari(Long id) {
        if (satisKanallariRepository.existsById(id)) {
            satisKanallariRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
