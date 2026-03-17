package repository;

import model.SatisKanallari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SatisKanallariRepository extends JpaRepository<SatisKanallari, Long> {
    // Özel sorgular buraya eklenebilir
}
