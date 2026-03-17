package service;

import model.FaturaBilgileri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.FaturaBilgileriRepository;

import java.util.List;

@Service
public class FaturaBilgileriService {

    private final FaturaBilgileriRepository faturaBilgileriRepository;

    @Autowired
    public FaturaBilgileriService(FaturaBilgileriRepository faturaBilgileriRepository) {
        this.faturaBilgileriRepository = faturaBilgileriRepository;
    }

    // Tüm fatura bilgilerini getir
    public List<FaturaBilgileri> getAllFaturaBilgileri() {
        return faturaBilgileriRepository.findAll();
    }

    // ID'ye göre fatura bilgisi getir
    public FaturaBilgileri getFaturaBilgileriById(Long id) {
        return faturaBilgileriRepository.findById(id).orElse(null);
    }

    // Yeni fatura bilgisi oluştur
    public FaturaBilgileri saveFaturaBilgileri(FaturaBilgileri faturaBilgileri) {
        return faturaBilgileriRepository.save(faturaBilgileri);
    }

    // ID'ye göre fatura bilgisi sil
    public void deleteFaturaBilgileri(Long id) {
        faturaBilgileriRepository.deleteById(id);
    }
}
