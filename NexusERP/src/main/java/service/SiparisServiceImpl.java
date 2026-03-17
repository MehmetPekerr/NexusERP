package service;

import model.Siparis;
import repository.SiparisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiparisServiceImpl implements SiparisService {

    private final SiparisRepository siparisRepository;

    @Autowired
    public SiparisServiceImpl(SiparisRepository siparisRepository) {
        this.siparisRepository = siparisRepository;
    }

    @Override
    public List<Siparis> getAllSiparis() {
        return siparisRepository.findAll();
    }

    @Override
    public Siparis getSiparisById(Long id) {
        Optional<Siparis> siparis = siparisRepository.findById(id);
        return siparis.orElse(null);
    }

    @Override
    public Siparis createSiparis(Siparis siparis) {
        return siparisRepository.save(siparis);
    }

    @Override
    public Siparis updateSiparis(Long id, Siparis siparis) {
        if (siparisRepository.existsById(id)) {
            siparis.setId(id);
            return siparisRepository.save(siparis);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteSiparis(Long id) {
        if (siparisRepository.existsById(id)) {
            siparisRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
