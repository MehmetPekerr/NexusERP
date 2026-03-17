package repository;

import model.BilgiGuvenligiPolitikalari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilgiGuvenligiPolitikalariRepository extends JpaRepository<BilgiGuvenligiPolitikalari, Long> {
    // Politika adı ile arama yapılabilir
    BilgiGuvenligiPolitikalari findByPolitikaAdi(String politikaAdi);
}
