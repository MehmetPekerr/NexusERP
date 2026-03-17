package service;

import dto.TedarikciDTO;
import model.Tedarikci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TedarikciRepository;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TedarikciService {

    private final TedarikciRepository tedarikciRepository;

    @Autowired
    public TedarikciService(TedarikciRepository tedarikciRepository) {
        this.tedarikciRepository = tedarikciRepository;
    }

    @Transactional
    public void createTedarikci(TedarikciDTO tedarikciDTO) {
        Tedarikci tedarikci = new Tedarikci();
        tedarikci.setTedarikciAdi(tedarikciDTO.getTedarikciAdi());
        tedarikci.setTedarikciEmail(tedarikciDTO.getTedarikciEmail());
        tedarikci.setTedarikciTelefon(tedarikciDTO.getTedarikciTelefon());

        tedarikciRepository.save(tedarikci);
    }

    public List<TedarikciDTO> getAllTedarikciler() {
        List<Tedarikci> tedarikciler = tedarikciRepository.findAll();
        return tedarikciler.stream()
                .map(tedarikci -> new TedarikciDTO(
                        tedarikci.getId(),
                        tedarikci.getTedarikciAdi(),
                        tedarikci.getTedarikciEmail(),
                        tedarikci.getTedarikciTelefon()
                ))
                .collect(Collectors.toList());
    }

    public TedarikciDTO getTedarikciById(Long id) {
        Optional<Tedarikci> tedarikci = tedarikciRepository.findById(id);
        if (tedarikci.isPresent()) {
            Tedarikci t = tedarikci.get();
            return new TedarikciDTO(
                    t.getId(),
                    t.getTedarikciAdi(),
                    t.getTedarikciEmail(),
                    t.getTedarikciTelefon()
            );
        } else {
            throw new RuntimeException("Tedarikçi bulunamadı");
        }
    }

    @Transactional
    public void updateTedarikci(Long id, TedarikciDTO tedarikciDTO) {
        Optional<Tedarikci> tedarikciOpt = tedarikciRepository.findById(id);
        if (tedarikciOpt.isPresent()) {
            Tedarikci tedarikci = tedarikciOpt.get();
            tedarikci.setTedarikciAdi(tedarikciDTO.getTedarikciAdi());
            tedarikci.setTedarikciEmail(tedarikciDTO.getTedarikciEmail());
            tedarikci.setTedarikciTelefon(tedarikciDTO.getTedarikciTelefon());
            tedarikciRepository.save(tedarikci);
        } else {
            throw new RuntimeException("Tedarikçi bulunamadı");
        }
    }

    @Transactional
    public void deleteTedarikci(Long id) {
        Optional<Tedarikci> tedarikciOpt = tedarikciRepository.findById(id);
        if (tedarikciOpt.isPresent()) {
            tedarikciRepository.delete(tedarikciOpt.get());
        } else {
            throw new RuntimeException("Tedarikçi bulunamadı");
        }
    }
}
