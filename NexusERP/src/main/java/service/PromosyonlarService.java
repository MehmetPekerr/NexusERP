package service;

import dto.PromosyonlarDTO;
import model.Promosyonlar;
import repository.PromosyonlarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PromosyonlarService {

    private final PromosyonlarRepository promosyonlarRepository;

    @Autowired
    public PromosyonlarService(PromosyonlarRepository promosyonlarRepository) {
        this.promosyonlarRepository = promosyonlarRepository;
    }

    // Promosyon oluşturma
    public void createPromosyon(PromosyonlarDTO promosyonlarDTO) {
        Promosyonlar promosyon = new Promosyonlar();
        promosyon.setAd(promosyonlarDTO.getAd());
        promosyon.setAciklama(promosyonlarDTO.getAciklama());
        promosyon.setIndirimOrani(promosyonlarDTO.getIndirimOrani());
        promosyon.setBaslangicTarihi(promosyonlarDTO.getBaslangicTarihi());
        promosyon.setBitisTarihi(promosyonlarDTO.getBitisTarihi());
        promosyonlarRepository.save(promosyon);
    }

    // Tüm promosyonları listeleme
    public List<PromosyonlarDTO> getAllPromosyonlar() {
        List<Promosyonlar> promosyonlar = promosyonlarRepository.findAll();
        return promosyonlar.stream()
                .map(promosyon -> new PromosyonlarDTO(
                        promosyon.getId(),
                        promosyon.getAd(),
                        promosyon.getAciklama(),
                        promosyon.getIndirimOrani(),
                        promosyon.getBaslangicTarihi(),
                        promosyon.getBitisTarihi()))
                .collect(Collectors.toList());
    }

    // ID ile promosyon getirme
    public PromosyonlarDTO getPromosyonById(Long id) {
        Optional<Promosyonlar> promosyonOpt = promosyonlarRepository.findById(id);
        if (promosyonOpt.isEmpty()) {
            throw new RuntimeException("Promosyon bulunamadı! ID: " + id);
        }
        Promosyonlar promosyon = promosyonOpt.get();
        return new PromosyonlarDTO(
                promosyon.getId(),
                promosyon.getAd(),
                promosyon.getAciklama(),
                promosyon.getIndirimOrani(),
                promosyon.getBaslangicTarihi(),
                promosyon.getBitisTarihi());
    }

    // Promosyonu güncelleme
    public void updatePromosyon(Long id, PromosyonlarDTO promosyonlarDTO) {
        Optional<Promosyonlar> promosyonOpt = promosyonlarRepository.findById(id);
        if (promosyonOpt.isEmpty()) {
            throw new RuntimeException("Promosyon bulunamadı! ID: " + id);
        }
        Promosyonlar promosyon = promosyonOpt.get();
        promosyon.setAd(promosyonlarDTO.getAd());
        promosyon.setAciklama(promosyonlarDTO.getAciklama());
        promosyon.setIndirimOrani(promosyonlarDTO.getIndirimOrani());
        promosyon.setBaslangicTarihi(promosyonlarDTO.getBaslangicTarihi());
        promosyon.setBitisTarihi(promosyonlarDTO.getBitisTarihi());
        promosyonlarRepository.save(promosyon);
    }

    // Promosyonu silme
    public void deletePromosyon(Long id) {
        Optional<Promosyonlar> promosyonOpt = promosyonlarRepository.findById(id);
        if (promosyonOpt.isEmpty()) {
            throw new RuntimeException("Promosyon bulunamadı! ID: " + id);
        }
        Promosyonlar promosyon = promosyonOpt.get();
        promosyonlarRepository.delete(promosyon);
    }
}
