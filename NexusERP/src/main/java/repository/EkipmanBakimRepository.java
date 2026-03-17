package repository;

import model.EkipmanBakim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EkipmanBakimRepository extends JpaRepository<EkipmanBakim, Long> {
    // Özel sorgular buraya eklenebilir
}
