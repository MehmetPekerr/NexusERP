package repository;

import java.util.List;
import model.IthalatVeIhracat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IthalatVeIhracatRepository extends JpaRepository<IthalatVeIhracat, Long> {
    // JpaRepository sağladığı bazı otomatik metodlarla birlikte, gerektiğinde özel sorgular eklenebilir.
    // Örnek: Firma ID'sine göre IthalatVeIhracat kayıtlarını listelemek için bir yöntem
    List<IthalatVeIhracat> findByFirmaId(Long firmaId);
}
