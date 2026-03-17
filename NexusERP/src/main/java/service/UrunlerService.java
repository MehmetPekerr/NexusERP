package service;

import dto.UrunlerDTO;
import model.Urunler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UrunlerRepository;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UrunlerService {

    private final UrunlerRepository urunlerRepository;

    @Autowired
    public UrunlerService(UrunlerRepository urunlerRepository) {
        this.urunlerRepository = urunlerRepository;
    }

    // Yeni bir ürün oluşturma
    @Transactional
    public UrunlerDTO createUrun(UrunlerDTO dto) {
        Urunler urun = new Urunler();
        urun.setUrunAdi(dto.getUrunAdi());
        urun.setUrunKodu(dto.getUrunKodu());
        urun.setFiyat(dto.getFiyat());
        urun.setStokMiktari(dto.getStokMiktari());

        Urunler savedUrun = urunlerRepository.save(urun);

        return new UrunlerDTO(savedUrun.getId(), savedUrun.getUrunAdi(), savedUrun.getUrunKodu(), savedUrun.getFiyat(), savedUrun.getStokMiktari());
    }

    // Tüm ürünleri listeleme
    public List<UrunlerDTO> getAllUrunler() {
        List<Urunler> urunlerList = urunlerRepository.findAll();
        return urunlerList.stream()
                .map(urun -> new UrunlerDTO(
                        urun.getId(),
                        urun.getUrunAdi(),
                        urun.getUrunKodu(),
                        urun.getFiyat(),
                        urun.getStokMiktari()))
                .collect(Collectors.toList());
    }

    // ID ile ürün bulma
    public UrunlerDTO getUrunById(Long id) {
        Optional<Urunler> urunOpt = urunlerRepository.findById(id);
        if (urunOpt.isPresent()) {
            Urunler urun = urunOpt.get();
            return new UrunlerDTO(urun.getId(), urun.getUrunAdi(), urun.getUrunKodu(), urun.getFiyat(), urun.getStokMiktari());
        }
        return null; // Ürün bulunamadı
    }

    // Ürün güncelleme
    @Transactional
    public boolean updateUrun(Long id, UrunlerDTO dto) {
        Optional<Urunler> urunOpt = urunlerRepository.findById(id);

        if (urunOpt.isPresent()) {
            Urunler urun = urunOpt.get();
            urun.setUrunAdi(dto.getUrunAdi());
            urun.setUrunKodu(dto.getUrunKodu());
            urun.setFiyat(dto.getFiyat());
            urun.setStokMiktari(dto.getStokMiktari());

            urunlerRepository.save(urun);
            return true;
        } else {
            return false; // Ürün bulunamadı
        }
    }

    // Ürün silme
    @Transactional
    public boolean deleteUrun(Long id) {
        Optional<Urunler> urunOpt = urunlerRepository.findById(id);
        if (urunOpt.isPresent()) {
            urunlerRepository.delete(urunOpt.get());
            return true;
        }
        return false; // Ürün bulunamadı
    }
}
