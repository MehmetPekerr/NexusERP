package repository;

import model.UrunTestRaporlari;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrunTestRaporlariRepository extends JpaRepository<UrunTestRaporlari, Long> {
    // Burada ihtiyaca göre özel sorgular eklenebilir
}
