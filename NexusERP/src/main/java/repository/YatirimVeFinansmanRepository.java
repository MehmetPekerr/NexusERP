package repository;

import model.YatirimVeFinansman;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface YatirimVeFinansmanRepository extends JpaRepository<YatirimVeFinansman, Long> {

    // Firma ID'sine göre Yatırım ve Finansmanları listeleyen özel sorgu
    List<YatirimVeFinansman> findByFirma_Id(Long firmaId);

}
