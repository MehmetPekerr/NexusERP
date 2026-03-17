package service;

import model.IsPlani;

import java.util.List;

public abstract class IsPlaniService {

    public abstract List<IsPlani> getAllIsPlani();

    public abstract IsPlani createIsPlani(IsPlani isPlani);

    public abstract IsPlani updateIsPlani(Long id, IsPlani isPlani);

    public abstract boolean deleteIsPlani(Long id);

    public abstract void executeIsPlani(Long id);
}
