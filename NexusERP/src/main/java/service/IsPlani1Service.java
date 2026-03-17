package service;

import model.IsPlani;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IsPlaniRepository;

import java.util.List;
import java.util.Optional;

@Service
public class IsPlani1Service extends IsPlaniService {

    private final IsPlaniRepository isPlaniRepository;

    @Autowired
    public IsPlani1Service(IsPlaniRepository isPlaniRepository) {
        this.isPlaniRepository = isPlaniRepository;
    }

    @Override
    public List<IsPlani> getAllIsPlani() {
        return isPlaniRepository.findAll();
    }

    @Override
    public IsPlani createIsPlani(IsPlani isPlani) {
        return isPlaniRepository.save(isPlani);
    }

    @Override
    public IsPlani updateIsPlani(Long id, IsPlani isPlani) {
        if (isPlaniRepository.existsById(id)) {
            isPlani.setId(id);
            return isPlaniRepository.save(isPlani);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteIsPlani(Long id) {
        if (isPlaniRepository.existsById(id)) {
            isPlaniRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void executeIsPlani(Long id) {
        Optional<IsPlani> isPlani = isPlaniRepository.findById(id);
        isPlani.ifPresent(IsPlani::executePlan);
    }

    public IsPlani getIsPlaniById(Long id) {
        Optional<IsPlani> isPlani = isPlaniRepository.findById(id);
        return isPlani.orElse(null); // Eğer bulamazsa null döner
    }
}
