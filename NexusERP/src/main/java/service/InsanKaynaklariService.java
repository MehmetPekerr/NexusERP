package service;

import dto.InsanKaynaklariDTO;
import model.InsanKaynaklari;
import repository.InsanKaynaklariRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsanKaynaklariService {

    @Autowired
    private InsanKaynaklariRepository insanKaynaklariRepository;

    // Tüm İnsan Kaynakları bilgilerini getir
    public List<InsanKaynaklari> getAllInsanKaynaklari() {
        return insanKaynaklariRepository.findAll();
    }

    // ID'ye göre İnsan Kaynakları bilgisi getir
    public Optional<InsanKaynaklari> getInsanKaynaklariById(Long id) {
        return insanKaynaklariRepository.findById(id);
    }

    // Yeni İnsan Kaynakları kaydet
    public InsanKaynaklari createInsanKaynaklari(InsanKaynaklariDTO insanKaynaklariDTO) {
        InsanKaynaklari insanKaynaklari = new InsanKaynaklari();
        insanKaynaklari.setId(insanKaynaklariDTO.getId());
        insanKaynaklari.setAd(insanKaynaklariDTO.getAd());
        insanKaynaklari.setSoyad(insanKaynaklariDTO.getSoyad());
        insanKaynaklari.setPozisyon(insanKaynaklariDTO.getPozisyon());
        insanKaynaklari.setMaas(insanKaynaklariDTO.getMaas());
        insanKaynaklari.setIseGirisTarihi(insanKaynaklariDTO.getIseGirisTarihi());

        // Firma ID ile ilişkili firma alınacak ve set edilecek
        // Firma repository kullanarak firma nesnesi alınabilir, burada örnek olması açısından firmaId verisi set edilebilir.

        return insanKaynaklariRepository.save(insanKaynaklari);
    }

    // İnsan Kaynakları güncelle
    public InsanKaynaklari updateInsanKaynaklari(Long id, InsanKaynaklariDTO insanKaynaklariDTO) {
        InsanKaynaklari insanKaynaklari = insanKaynaklariRepository.findById(id).orElseThrow(() -> new RuntimeException("İnsan Kaynakları bulunamadı"));
        insanKaynaklari.setAd(insanKaynaklariDTO.getAd());
        insanKaynaklari.setSoyad(insanKaynaklariDTO.getSoyad());
        insanKaynaklari.setPozisyon(insanKaynaklariDTO.getPozisyon());
        insanKaynaklari.setMaas(insanKaynaklariDTO.getMaas());
        insanKaynaklari.setIseGirisTarihi(insanKaynaklariDTO.getIseGirisTarihi());

        return insanKaynaklariRepository.save(insanKaynaklari);
    }

    // İnsan Kaynakları sil
    public void deleteInsanKaynaklari(Long id) {
        insanKaynaklariRepository.deleteById(id);
    }
}
