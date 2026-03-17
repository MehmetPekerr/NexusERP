package repository;

import model.GuncellemeBilgileri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuncellemeBilgileriRepository extends JpaRepository<GuncellemeBilgileri, Long> {
    // Burada ek olarak gerekli metodlar varsa tanımlayabilirsiniz
}
