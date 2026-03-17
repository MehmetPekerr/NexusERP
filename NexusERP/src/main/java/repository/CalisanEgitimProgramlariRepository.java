package repository;

import java.util.List;
import model.CalisanEgitimProgramlari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalisanEgitimProgramlariRepository extends JpaRepository<CalisanEgitimProgramlari, Long> {

    // Örneğin, eğitim adı ile çalışan eğitim programlarını bulmak için:
    List<CalisanEgitimProgramlari> findByEgitimAdi(String egitimAdi);
}
