package repository;

import model.Depo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepoRepository extends JpaRepository<Depo, Long> {
    // Ekstra sorgular buraya eklenebilir, örneğin:
    // List<Depo> findByAd(String ad);
}
