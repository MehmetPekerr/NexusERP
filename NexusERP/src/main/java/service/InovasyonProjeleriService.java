package service;

import model.InovasyonProjeleri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.InovasyonProjeleriRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InovasyonProjeleriService {

    private final InovasyonProjeleriRepository inovasyonProjeleriRepository;

    @Autowired
    public InovasyonProjeleriService(InovasyonProjeleriRepository inovasyonProjeleriRepository) {
        this.inovasyonProjeleriRepository = inovasyonProjeleriRepository;
    }

    // Tüm inovasyon projelerini listele
    public List<InovasyonProjeleri> getAllInovasyonProjeleri() {
        return inovasyonProjeleriRepository.findAll();
    }

    // ID ile inovasyon projesini al
    public InovasyonProjeleri getInovasyonProjesiById(Long id) {
        Optional<InovasyonProjeleri> inovasyonProjeleri = inovasyonProjeleriRepository.findById(id);
        return inovasyonProjeleri.orElse(null);
    }

    // Yeni inovasyon projesi oluştur
    public InovasyonProjeleri createInovasyonProjesi(InovasyonProjeleri inovasyonProjeleri) {
        return inovasyonProjeleriRepository.save(inovasyonProjeleri);
    }

    // Inovasyon projesini güncelle
    public InovasyonProjeleri updateInovasyonProjesi(InovasyonProjeleri inovasyonProjeleri) {
        return inovasyonProjeleriRepository.save(inovasyonProjeleri);
    }

    // Inovasyon projesini sil
    public boolean deleteInovasyonProjesi(Long id) {
        Optional<InovasyonProjeleri> inovasyonProjeleri = inovasyonProjeleriRepository.findById(id);
        if (inovasyonProjeleri.isPresent()) {
            inovasyonProjeleriRepository.delete(inovasyonProjeleri.get());
            return true;
        }
        return false;
    }
}
