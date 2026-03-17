package repository;

import model.InsanKaynaklari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsanKaynaklariRepository extends JpaRepository<InsanKaynaklari, Long> {
    // Burada ihtiyaca göre custom query'ler yazılabilir
}
