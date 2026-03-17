package repository;

import model.PersonelBilgileri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonelBilgileriRepository extends JpaRepository<PersonelBilgileri, Long> {  // PersonelBilgileri ile çalışıyoruz

    // Pozisyona göre arama
    List<PersonelBilgileri> findByPozisyon(String pozisyon);
}
