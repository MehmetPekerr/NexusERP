package service;

import model.SatisKanallari;
import java.util.List;

public interface SatisKanallariService {

    List<SatisKanallari> getAllSatisKanallari();

    SatisKanallari getSatisKanallariById(Long id);

    SatisKanallari createSatisKanallari(SatisKanallari satisKanallari);

    SatisKanallari updateSatisKanallari(Long id, SatisKanallari satisKanallari);

    boolean deleteSatisKanallari(Long id);
}
