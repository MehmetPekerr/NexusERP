package service;

import model.Satis;
import java.util.List;

public interface SatisService {

    List<Satis> getAllSatis();

    Satis getSatisById(Long id);

    Satis createSatis(Satis satis);

    Satis updateSatis(Long id, Satis satis);

    boolean deleteSatis(Long id);
}
