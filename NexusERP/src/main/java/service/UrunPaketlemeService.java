package service;

import dto.UrunPaketlemeDTO;
import model.Nakliyat;
import model.Siparis;
import model.UrunPaketleme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UrunPaketlemeRepository;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UrunPaketlemeService {

    private final UrunPaketlemeRepository urunPaketlemeRepository;

    @Autowired
    public UrunPaketlemeService(UrunPaketlemeRepository urunPaketlemeRepository) {
        this.urunPaketlemeRepository = urunPaketlemeRepository;
    }

    @Transactional
    public void createUrunPaketleme(UrunPaketlemeDTO urunPaketlemeDTO) {
        UrunPaketleme urunPaketleme = new UrunPaketleme();
        urunPaketleme.setUrunAdi(urunPaketlemeDTO.getUrunAdi());
        urunPaketleme.setPaketlemeTipi(urunPaketlemeDTO.getPaketlemeTipi());
        urunPaketleme.setPaketBoyutu(urunPaketlemeDTO.getPaketBoyutu());
        urunPaketleme.setTarih(urunPaketlemeDTO.getTarih());
        urunPaketlemeRepository.save(urunPaketleme);
    }

    public List<UrunPaketlemeDTO> getAllUrunPaketleme() {
        List<UrunPaketleme> urunPaketlemeList = urunPaketlemeRepository.findAll();
        return urunPaketlemeList.stream()
                .map(urunPaketleme -> new UrunPaketlemeDTO(
                        urunPaketleme.getId(),
                        urunPaketleme.getUrunAdi(),
                        urunPaketleme.getPaketlemeTipi(),
                        urunPaketleme.getPaketBoyutu(),
                        urunPaketleme.getTarih(),
                        urunPaketleme.getSiparisListesi(),
                        urunPaketleme.getNakliyatListesi()
                ))
                .collect(Collectors.toList());
    }

    public UrunPaketlemeDTO getUrunPaketlemeById(Long id) {
        Optional<UrunPaketleme> urunPaketleme = urunPaketlemeRepository.findById(id);
        if (urunPaketleme.isPresent()) {
            UrunPaketleme u = urunPaketleme.get();
            return new UrunPaketlemeDTO(
                    u.getId(),
                    u.getUrunAdi(),
                    u.getPaketlemeTipi(),
                    u.getPaketBoyutu(),
                    u.getTarih(),
                    u.getSiparisListesi(),
                    u.getNakliyatListesi()
            );
        } else {
            throw new RuntimeException("Ürün paketleme kaydı bulunamadı");
        }
    }

    @Transactional
    public void updateUrunPaketleme(Long id, UrunPaketlemeDTO urunPaketlemeDTO) {
        Optional<UrunPaketleme> urunPaketlemeOpt = urunPaketlemeRepository.findById(id);
        if (urunPaketlemeOpt.isPresent()) {
            UrunPaketleme urunPaketleme = urunPaketlemeOpt.get();
            urunPaketleme.setUrunAdi(urunPaketlemeDTO.getUrunAdi());
            urunPaketleme.setPaketlemeTipi(urunPaketlemeDTO.getPaketlemeTipi());
            urunPaketleme.setPaketBoyutu(urunPaketlemeDTO.getPaketBoyutu());
            urunPaketleme.setTarih(urunPaketlemeDTO.getTarih());
            urunPaketlemeRepository.save(urunPaketleme);
        } else {
            throw new RuntimeException("Ürün paketleme kaydı bulunamadı");
        }
    }

    @Transactional
    public void deleteUrunPaketleme(Long id) {
        Optional<UrunPaketleme> urunPaketlemeOpt = urunPaketlemeRepository.findById(id);
        if (urunPaketlemeOpt.isPresent()) {
            urunPaketlemeRepository.delete(urunPaketlemeOpt.get());
        } else {
            throw new RuntimeException("Ürün paketleme kaydı bulunamadı");
        }
    }

    public List<Siparis> getSiparislerByUrunPaketlemeId(Long id) {
        UrunPaketleme urunPaketleme = urunPaketlemeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ürün paketleme kaydı bulunamadı"));
        return urunPaketleme.getSiparisListesi();
    }

    public List<Nakliyat> getNakliyatlarByUrunPaketlemeId(Long id) {
        UrunPaketleme urunPaketleme = urunPaketlemeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ürün paketleme kaydı bulunamadı"));
        return urunPaketleme.getNakliyatListesi();
    }
}
