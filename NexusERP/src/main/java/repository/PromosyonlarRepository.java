package repository;

import java.time.LocalDate;
import model.Promosyonlar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromosyonlarRepository extends JpaRepository<Promosyonlar, Long> {
    
    // Kampanya adını alarak promosyonları sorgulamak için özel bir metot örneği
    List<Promosyonlar> findByAd(String ad);

    // Belirli bir tarih aralığındaki promosyonları getiren özel bir metot örneği
    List<Promosyonlar> findByBaslangicTarihiAfterAndBitisTarihiBefore(LocalDate baslangicTarihi, LocalDate bitisTarihi);
}
