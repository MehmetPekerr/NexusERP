package repository;

import model.IsPlani;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IsPlaniRepository extends JpaRepository<IsPlani, Long> {
    // Ekstra sorgu metotları burada tanımlanabilir
}
