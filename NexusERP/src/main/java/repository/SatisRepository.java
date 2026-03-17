package repository;

import model.Satis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SatisRepository extends JpaRepository<Satis, Long> {
    // Özel sorgular buraya eklenebilir
}
