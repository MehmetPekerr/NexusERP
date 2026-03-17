package service;

import model.EkipmanBakim;
import java.util.List;

public interface EkipmanBakimService {

    List<EkipmanBakim> getAllEkipmanBakimlar();

    EkipmanBakim getEkipmanBakimById(Long id);

    EkipmanBakim createEkipmanBakim(EkipmanBakim ekipmanBakim);

    EkipmanBakim updateEkipmanBakim(Long id, EkipmanBakim ekipmanBakim);

    boolean deleteEkipmanBakim(Long id);
}
