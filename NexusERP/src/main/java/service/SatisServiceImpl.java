package service;

import model.Satis;
import repository.SatisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SatisServiceImpl implements SatisService {

    private final SatisRepository satisRepository;

    @Autowired
    public SatisServiceImpl(SatisRepository satisRepository) {
        this.satisRepository = satisRepository;
    }

    @Override
    public List<Satis> getAllSatis() {
        return satisRepository.findAll();
    }

    @Override
    public Satis getSatisById(Long id) {
        Optional<Satis> satis = satisRepository.findById(id);
        return satis.orElse(null);
    }

    @Override
    public Satis createSatis(Satis satis) {
        return satisRepository.save(satis);
    }

    @Override
    public Satis updateSatis(Long id, Satis satis) {
        if (satisRepository.existsById(id)) {
            satis.setId(id);
            return satisRepository.save(satis);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteSatis(Long id) {
        if (satisRepository.existsById(id)) {
            satisRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
