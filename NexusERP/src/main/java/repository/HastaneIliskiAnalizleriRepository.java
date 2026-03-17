package repository;

import model.HastaneIliskiAnalizleri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HastaneIliskiAnalizleriRepository extends JpaRepository<HastaneIliskiAnalizleri, Long> {
    // Burada ekstra sorgular ekleyebilirsiniz, örneğin:
    // List<HastaneIliskiAnalizleri> findByHastaneAdi(String hastaneAdi);
}
