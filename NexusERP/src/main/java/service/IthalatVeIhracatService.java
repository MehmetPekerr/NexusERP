package service;

import dto.IthalatVeIhracatDTO;
import model.IthalatVeIhracat;
import model.Firma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.FirmaRepository;
import repository.IthalatVeIhracatRepository;

import java.util.List;
import java.util.Optional;

@Service
public class IthalatVeIhracatService {

    private final IthalatVeIhracatRepository ithalatVeIhracatRepository;
    private final FirmaRepository firmaRepository;

    @Autowired
    public IthalatVeIhracatService(IthalatVeIhracatRepository ithalatVeIhracatRepository, FirmaRepository firmaRepository) {
        this.ithalatVeIhracatRepository = ithalatVeIhracatRepository;
        this.firmaRepository = firmaRepository;
    }

    // Firma ID'sine göre ithalat ve ihracat işlemlerini listeleme
    public List<IthalatVeIhracat> getIthalatVeIhracatByFirma(Long firmaId) {
        return ithalatVeIhracatRepository.findByFirmaId(firmaId);
    }

    // Yeni ithalat ve ihracat kaydı oluşturma
    public IthalatVeIhracat createIthalatVeIhracat(IthalatVeIhracatDTO dto) {
        Optional<Firma> firmaOptional = firmaRepository.findById(dto.getFirmaId());
        if (firmaOptional.isEmpty()) {
            throw new IllegalArgumentException("Firma bulunamadı!");
        }
        Firma firma = firmaOptional.get();

        IthalatVeIhracat ithalatVeIhracat = new IthalatVeIhracat(
                dto.getIslemTarihi(),
                dto.getIslemTipi(),
                dto.getMiktar(),
                dto.getBirim(),
                dto.getTutar(),
                firma
        );

        return ithalatVeIhracatRepository.save(ithalatVeIhracat);
    }

    // Var olan ithalat kaydını güncelleme
    public IthalatVeIhracat updateIthalatVeIhracat(Long id, IthalatVeIhracatDTO dto) {
        IthalatVeIhracat existingIthalat = ithalatVeIhracatRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Kayıt bulunamadı!"));

        Optional<Firma> firmaOptional = firmaRepository.findById(dto.getFirmaId());
        if (firmaOptional.isEmpty()) {
            throw new IllegalArgumentException("Firma bulunamadı!");
        }
        Firma firma = firmaOptional.get();

        existingIthalat.setIslemTarihi(dto.getIslemTarihi());
        existingIthalat.setIslemTipi(dto.getIslemTipi());
        existingIthalat.setMiktar(dto.getMiktar());
        existingIthalat.setBirim(dto.getBirim());
        existingIthalat.setTutar(dto.getTutar());
        existingIthalat.setFirma(firma);

        return ithalatVeIhracatRepository.save(existingIthalat);
    }

    // Kayıt silme
    public void deleteIthalatVeIhracat(Long id) {
        if (!ithalatVeIhracatRepository.existsById(id)) {
            throw new IllegalArgumentException("Kayıt bulunamadı!");
        }
        ithalatVeIhracatRepository.deleteById(id);
    }

    // Tüm ithalat ve ihracat kayıtlarını getirme
    public List<IthalatVeIhracat> getAllIthalatVeIhracat() {
        return ithalatVeIhracatRepository.findAll();
    }

    // Tek bir ithalat ve ihracat kaydını getirme
    public IthalatVeIhracat getIthalatVeIhracat(Long id) {
        return ithalatVeIhracatRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Kayıt bulunamadı!"));
    }
}
