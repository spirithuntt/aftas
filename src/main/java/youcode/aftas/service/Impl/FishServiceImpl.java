package youcode.aftas.service.Impl;

import org.springframework.stereotype.Service;
import youcode.aftas.domain.Fish;
import youcode.aftas.repository.FishRepository;

@Service
public class FishServiceImpl {
    private final FishRepository fishRepository;

    public FishServiceImpl(FishRepository fishRepository) {
        this.fishRepository = fishRepository;
    }

    //À chaque niveau de tir est associé un nombre de points: plus le niveau est élevé plus le nombre
    // de points est important (doit être vérifié à l’insertion des niveaux de tir).


}
