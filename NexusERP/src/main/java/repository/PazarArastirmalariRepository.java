package repository;

import model.PazarArastirmalari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PazarArastirmalariRepository extends JpaRepository<PazarArastirmalari, Long> {
}
