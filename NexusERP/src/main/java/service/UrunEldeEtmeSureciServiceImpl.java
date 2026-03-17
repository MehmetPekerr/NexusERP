package service.impl;

import dto.UrunEldeEtmeSureciDTO;
import model.UrunEldeEtmeSureci;
import model.Firma;
import model.Urunler;
import model.UrunMaliyetAnalizi;
import repository.UrunEldeEtmeSureciRepository;
import service.UrunEldeEtmeSureciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UrunEldeEtmeSureciServiceImpl implements UrunEldeEtmeSureciService {

    @Autowired
    private UrunEldeEtmeSureciRepository urunEldeEtmeSureciRepository;

    @Override
    public UrunEldeEtmeSureciDTO convertToDTO(UrunEldeEtmeSureci urunEldeEtmeSureci) {
        UrunEldeEtmeSureciDTO dto = new UrunEldeEtmeSureciDTO();
        dto.setId(urunEldeEtmeSureci.getId());
        dto.setUrunAdi(urunEldeEtmeSureci.getUrunAdi());
        dto.setTedarikciAdi(urunEldeEtmeSureci.getTedarikciAdi());
        dto.setEldeEtmeTarihi(urunEldeEtmeSureci.getEldeEtmeTarihi());
        dto.setDurum(urunEldeEtmeSureci.getDurum());
        dto.setFirmaId(urunEldeEtmeSureci.getFirma().getId());

        Set<Long> urunIds = new HashSet<>();
        urunEldeEtmeSureci.getUrunler().forEach(urun -> urunIds.add(urun.getId()));
        dto.setUrunIds(urunIds);

        Set<Long> urunMaliyetAnaliziIds = new HashSet<>();
        urunEldeEtmeSureci.getUrunMaliyetAnalizleri().forEach(maliyet -> urunMaliyetAnaliziIds.add(maliyet.getId()));
        dto.setUrunMaliyetAnaliziIds(urunMaliyetAnaliziIds);

        return dto;
    }

    @Override
    public UrunEldeEtmeSureci saveUrunEldeEtmeSureci(UrunEldeEtmeSureciDTO dto) {
        UrunEldeEtmeSureci urunEldeEtmeSureci = new UrunEldeEtmeSureci();
        urunEldeEtmeSureci.setUrunAdi(dto.getUrunAdi());
        urunEldeEtmeSureci.setTedarikciAdi(dto.getTedarikciAdi());
        urunEldeEtmeSureci.setEldeEtmeTarihi(dto.getEldeEtmeTarihi());
        urunEldeEtmeSureci.setDurum(dto.getDurum());

        // Firma bağlantısı
        Firma firma = new Firma();
        firma.setId(dto.getFirmaId());
        urunEldeEtmeSureci.setFirma(firma);

        // Urunler ve UrunMaliyetAnalizleri bağlantıları
        Set<Urunler> urunler = new HashSet<>();
        dto.getUrunIds().forEach(id -> {
            Urunler urun = new Urunler();
            urun.setId(id);
            urunler.add(urun);
        });
        urunEldeEtmeSureci.setUrunler(urunler);

        Set<UrunMaliyetAnalizi> urunMaliyetAnalizleri = new HashSet<>();
        dto.getUrunMaliyetAnaliziIds().forEach(id -> {
            UrunMaliyetAnalizi maliyet = new UrunMaliyetAnalizi();
            maliyet.setId(id);
            urunMaliyetAnalizleri.add(maliyet);
        });
        urunEldeEtmeSureci.setUrunMaliyetAnalizleri(urunMaliyetAnalizleri);

        return urunEldeEtmeSureciRepository.save(urunEldeEtmeSureci);
    }

    @Override
    public UrunEldeEtmeSureci getUrunEldeEtmeSureci(Long id) {
        return urunEldeEtmeSureciRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UrunEldeEtmeSureci not found"));
    }
}
