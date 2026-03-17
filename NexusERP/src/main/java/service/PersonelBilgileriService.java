package service;

import dto.PersonelBilgileriDTO;
import model.PersonelBilgileri;
import repository.PersonelBilgileriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonelBilgileriService {

    private final PersonelBilgileriRepository personelBilgileriRepository;

    @Autowired
    public PersonelBilgileriService(PersonelBilgileriRepository personelBilgileriRepository) {
        this.personelBilgileriRepository = personelBilgileriRepository;
    }

    // Tüm personel bilgilerini listele
    public List<PersonelBilgileriDTO> getAllPersonel() {
        List<PersonelBilgileri> personelList = personelBilgileriRepository.findAll();
        return personelList.stream()
                .map(personel -> new PersonelBilgileriDTO(
                        personel.getId(),
                        personel.getAd(),
                        personel.getSoyad(),
                        personel.getPozisyon(),
                        personel.getMaas(),
                        personel.getIseGirisTarihi()))
                .collect(Collectors.toList());
    }

    // ID ile personel bilgisi al
    public PersonelBilgileriDTO getPersonelById(Long id) {
        Optional<PersonelBilgileri> personel = personelBilgileriRepository.findById(id);
        return personel.map(p -> new PersonelBilgileriDTO(
                p.getId(),
                p.getAd(),
                p.getSoyad(),
                p.getPozisyon(),
                p.getMaas(),
                p.getIseGirisTarihi())).orElse(null);
    }

    // Yeni personel oluştur
    public PersonelBilgileriDTO createPersonel(PersonelBilgileri personel) {
        PersonelBilgileri createdPersonel = personelBilgileriRepository.save(personel);
        return new PersonelBilgileriDTO(
                createdPersonel.getId(),
                createdPersonel.getAd(),
                createdPersonel.getSoyad(),
                createdPersonel.getPozisyon(),
                createdPersonel.getMaas(),
                createdPersonel.getIseGirisTarihi());
    }

    // Personel bilgilerini güncelle
    public PersonelBilgileriDTO updatePersonel(Long id, PersonelBilgileri personel) {
        Optional<PersonelBilgileri> existingPersonel = personelBilgileriRepository.findById(id);
        if (existingPersonel.isPresent()) {
            personel.setId(id);  // Güncellenen personelin ID'sini ayarlıyoruz
            PersonelBilgileri updatedPersonel = personelBilgileriRepository.save(personel);
            return new PersonelBilgileriDTO(
                    updatedPersonel.getId(),
                    updatedPersonel.getAd(),
                    updatedPersonel.getSoyad(),
                    updatedPersonel.getPozisyon(),
                    updatedPersonel.getMaas(),
                    updatedPersonel.getIseGirisTarihi());
        }
        return null;  // Eğer personel bulunamazsa null döndürülür
    }

    // Personel bilgilerini sil
    public boolean deletePersonel(Long id) {
        if (personelBilgileriRepository.existsById(id)) {
            personelBilgileriRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Pozisyona göre personelleri listele
    public List<PersonelBilgileriDTO> getPersonelByPozisyon(String pozisyon) {
        List<PersonelBilgileri> personelList = personelBilgileriRepository.findByPozisyon(pozisyon);
        return personelList.stream()
                .map(personel -> new PersonelBilgileriDTO(
                        personel.getId(),
                        personel.getAd(),
                        personel.getSoyad(),
                        personel.getPozisyon(),
                        personel.getMaas(),
                        personel.getIseGirisTarihi()))
                .collect(Collectors.toList());
    }
}
