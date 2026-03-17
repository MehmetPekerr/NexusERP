package repository;

import model.FaturaBilgileri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaturaBilgileriRepository extends JpaRepository<FaturaBilgileri, Long> {
    // Ek sorgular gerekirse burada tanımlanabilir.
}
