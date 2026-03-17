package repository;

import model.UrunMaliyetAnalizi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrunMaliyetAnaliziRepository extends JpaRepository<UrunMaliyetAnalizi, Long> {
    // İhtiyaç duyulursa özel sorgular eklenebilir
}
