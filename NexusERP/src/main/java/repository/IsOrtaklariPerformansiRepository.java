package repository;

import model.IsOrtaklariPerformansi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IsOrtaklariPerformansiRepository extends JpaRepository<IsOrtaklariPerformansi, Long> {

    // İş ortağı adına göre performansları listele
    List<IsOrtaklariPerformansi> findByIsOrtakAdi(String isOrtakAdi);

    // Performans skoru belirli bir değerin üzerinde olanları al
    List<IsOrtaklariPerformansi> findByPerformansSkoruGreaterThan(double minSkor);
}
