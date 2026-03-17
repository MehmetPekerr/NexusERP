package service;

import model.Siparis;
import java.util.List;

public interface SiparisService {

    List<Siparis> getAllSiparis();

    Siparis getSiparisById(Long id);

    Siparis createSiparis(Siparis siparis);

    Siparis updateSiparis(Long id, Siparis siparis);

    boolean deleteSiparis(Long id);
}
