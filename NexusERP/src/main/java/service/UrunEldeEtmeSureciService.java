package service;

import dto.UrunEldeEtmeSureciDTO;
import model.UrunEldeEtmeSureci;

public interface UrunEldeEtmeSureciService {

    UrunEldeEtmeSureci saveUrunEldeEtmeSureci(UrunEldeEtmeSureciDTO dto);

    UrunEldeEtmeSureci getUrunEldeEtmeSureci(Long id);

    UrunEldeEtmeSureciDTO convertToDTO(UrunEldeEtmeSureci urunEldeEtmeSureci);
}
