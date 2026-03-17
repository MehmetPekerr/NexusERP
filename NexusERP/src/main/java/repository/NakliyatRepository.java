package repository;

import model.Nakliyat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface NakliyatRepository extends JpaRepository<Nakliyat, Long> {

    // Teslimat tarihi aralığına göre nakliyatları listele
    List<Nakliyat> findByTeslimatTarihiBetween(LocalDate startDate, LocalDate endDate);

    // UrunPaketleme'ye bağlı nakliyatları listele
    List<Nakliyat> findByUrunPaketlemeId(Long urunPaketlemeId);  // UrunPaketleme ile ilişki

    // Satis'a bağlı nakliyatları listele
    List<Nakliyat> findBySatisId(Long satisId);  // Satis ile ilişki

    // Diğer gerekli sorgular (isteğe bağlı)
    List<Nakliyat> findByIslemTipi(String islemTipi);
    List<Nakliyat> findByMiktar(Double miktar);
    List<Nakliyat> findByTeslimatAdresi(String teslimatAdresi);
}
