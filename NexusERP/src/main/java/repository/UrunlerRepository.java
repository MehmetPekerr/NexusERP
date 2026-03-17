package repository;

import model.Urunler;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrunlerRepository extends JpaRepository<Urunler, Long> {
    // Gerekli özel sorgular buraya eklenebilir
}
