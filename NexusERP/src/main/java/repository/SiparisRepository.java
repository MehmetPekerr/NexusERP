package repository;

import model.Siparis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiparisRepository extends JpaRepository<Siparis, Long> {
    // Siparişlerle ilgili özel sorgular burada tanımlanabilir
}
