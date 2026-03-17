package service;

import model.EkipmanBakim;
import repository.EkipmanBakimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EkipmanBakimServiceImpl implements EkipmanBakimService {

    private final EkipmanBakimRepository ekipmanBakimRepository;

    @Autowired
    public EkipmanBakimServiceImpl(EkipmanBakimRepository ekipmanBakimRepository) {
        this.ekipmanBakimRepository = ekipmanBakimRepository;
    }

    @Override
    public List<EkipmanBakim> getAllEkipmanBakimlar() {
        return ekipmanBakimRepository.findAll();
    }

    @Override
    public EkipmanBakim getEkipmanBakimById(Long id) {
        Optional<EkipmanBakim> ekipmanBakim = ekipmanBakimRepository.findById(id);
        return ekipmanBakim.orElse(null);
    }

    @Override
    public EkipmanBakim createEkipmanBakim(EkipmanBakim ekipmanBakim) {
        return ekipmanBakimRepository.save(ekipmanBakim);
    }

    @Override
    public EkipmanBakim updateEkipmanBakim(Long id, EkipmanBakim ekipmanBakim) {
        if (ekipmanBakimRepository.existsById(id)) {
            ekipmanBakim.setId(id);
            return ekipmanBakimRepository.save(ekipmanBakim);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteEkipmanBakim(Long id) {
        if (ekipmanBakimRepository.existsById(id)) {
            ekipmanBakimRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
