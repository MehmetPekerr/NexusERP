package service;

import model.Nakliyat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.NakliyatRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class NakliyatService {

    private final NakliyatRepository nakliyatRepository;

    @Autowired
    public NakliyatService(NakliyatRepository nakliyatRepository) {
        this.nakliyatRepository = nakliyatRepository;
    }

    // Tüm nakliyatları listele
    public List<Nakliyat> getAllNakliyat() {
        return nakliyatRepository.findAll();
    }

    // ID ile nakliyat kaydını al
    public Nakliyat getNakliyatById(Long id) {
        return nakliyatRepository.findById(id).orElse(null);
    }

    // Yeni nakliyat kaydı oluştur
    public Nakliyat createNakliyat(Nakliyat nakliyat) {
        return nakliyatRepository.save(nakliyat);
    }

    // Nakliyat kaydını güncelle
    public Nakliyat updateNakliyat(Long id, Nakliyat nakliyat) {
        if (nakliyatRepository.existsById(id)) {
            nakliyat.setId(id);
            return nakliyatRepository.save(nakliyat);
        }
        return null;
    }

    // Nakliyat kaydını sil
    public boolean deleteNakliyat(Long id) {
        if (nakliyatRepository.existsById(id)) {
            nakliyatRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Teslimat tarihi aralığına göre nakliyatları listele
    public List<Nakliyat> getNakliyatByTeslimatTarihiBetween(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);

        return nakliyatRepository.findByTeslimatTarihiBetween(start, end);  // Doğru metod ismi
    }
}
