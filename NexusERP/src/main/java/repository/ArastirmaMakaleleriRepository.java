package repository;

import model.ArastirmaMakaleleri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArastirmaMakaleleriRepository extends JpaRepository<ArastirmaMakaleleri, Long> {
    // Firma ile ilişkili araştırma makaleleri için ek sorgular yazılabilir.
}
