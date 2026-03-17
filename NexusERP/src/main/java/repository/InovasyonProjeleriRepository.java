package repository;

import model.InovasyonProjeleri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InovasyonProjeleriRepository extends JpaRepository<InovasyonProjeleri, Long> {

    // İhtiyaca göre ek sorgular yazılabilir, örneğin proje adı ile arama yapabilirsiniz:
    // List<InovasyonProjeleri> findByProjeAdi(String projeAdi);
}
