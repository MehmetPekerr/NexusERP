package service;

import dto.UrunGeriBildirimleriDTO;
import model.UrunGeriBildirimleri;
import model.Satis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UrunGeriBildirimleriRepository;
import repository.SatisRepository;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UrunGeriBildirimleriService {

    private final UrunGeriBildirimleriRepository urunGeriBildirimleriRepository;
    private final SatisRepository satisRepository;

    @Autowired
    public UrunGeriBildirimleriService(UrunGeriBildirimleriRepository urunGeriBildirimleriRepository, SatisRepository satisRepository) {
        this.urunGeriBildirimleriRepository = urunGeriBildirimleriRepository;
        this.satisRepository = satisRepository;
    }

    @Transactional
    public void createUrunGeriBildirimi(UrunGeriBildirimleriDTO urunGeriBildirimleriDTO) {
        UrunGeriBildirimleri urunGeriBildirimleri = new UrunGeriBildirimleri();
        urunGeriBildirimleri.setUrunAdi(urunGeriBildirimleriDTO.getUrunAdi());
        urunGeriBildirimleri.setGeriBildirim(urunGeriBildirimleriDTO.getGeriBildirim());
        urunGeriBildirimleri.setMusteriAdi(urunGeriBildirimleriDTO.getMusteriAdi());
        urunGeriBildirimleri.setPuan(urunGeriBildirimleriDTO.getPuan());
        urunGeriBildirimleri.setTarih(urunGeriBildirimleriDTO.getTarih());

        List<Satis> satislar = satisRepository.findAllById(urunGeriBildirimleriDTO.getSatisIdListesi());
        urunGeriBildirimleri.setSatislar(satislar);

        urunGeriBildirimleriRepository.save(urunGeriBildirimleri);
    }

    public List<UrunGeriBildirimleriDTO> getAllUrunGeriBildirimleri() {
        List<UrunGeriBildirimleri> urunGeriBildirimleriList = urunGeriBildirimleriRepository.findAll();
        return urunGeriBildirimleriList.stream()
                .map(urunGeriBildirimleri -> new UrunGeriBildirimleriDTO(
                        urunGeriBildirimleri.getId(),
                        urunGeriBildirimleri.getUrunAdi(),
                        urunGeriBildirimleri.getGeriBildirim(),
                        urunGeriBildirimleri.getMusteriAdi(),
                        urunGeriBildirimleri.getPuan(),
                        urunGeriBildirimleri.getTarih(),
                        urunGeriBildirimleri.getSatislar().stream().map(Satis::getId).collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    public UrunGeriBildirimleriDTO getUrunGeriBildirimleriById(Long id) {
        Optional<UrunGeriBildirimleri> urunGeriBildirimleri = urunGeriBildirimleriRepository.findById(id);
        if (urunGeriBildirimleri.isPresent()) {
            UrunGeriBildirimleri u = urunGeriBildirimleri.get();
            return new UrunGeriBildirimleriDTO(
                    u.getId(),
                    u.getUrunAdi(),
                    u.getGeriBildirim(),
                    u.getMusteriAdi(),
                    u.getPuan(),
                    u.getTarih(),
                    u.getSatislar().stream().map(Satis::getId).collect(Collectors.toList())
            );
        }
        return null;
    }

    @Transactional
    public void updateUrunGeriBildirimleri(Long id, UrunGeriBildirimleriDTO urunGeriBildirimleriDTO) {
        Optional<UrunGeriBildirimleri> existing = urunGeriBildirimleriRepository.findById(id);
        if (existing.isPresent()) {
            UrunGeriBildirimleri urunGeriBildirimleri = existing.get();
            urunGeriBildirimleri.setUrunAdi(urunGeriBildirimleriDTO.getUrunAdi());
            urunGeriBildirimleri.setGeriBildirim(urunGeriBildirimleriDTO.getGeriBildirim());
            urunGeriBildirimleri.setMusteriAdi(urunGeriBildirimleriDTO.getMusteriAdi());
            urunGeriBildirimleri.setPuan(urunGeriBildirimleriDTO.getPuan());
            urunGeriBildirimleri.setTarih(urunGeriBildirimleriDTO.getTarih());

            List<Satis> satislar = satisRepository.findAllById(urunGeriBildirimleriDTO.getSatisIdListesi());
            urunGeriBildirimleri.setSatislar(satislar);

            urunGeriBildirimleriRepository.save(urunGeriBildirimleri);
        }
    }

    @Transactional
    public void deleteUrunGeriBildirimleri(Long id) {
        urunGeriBildirimleriRepository.deleteById(id);
    }
}
