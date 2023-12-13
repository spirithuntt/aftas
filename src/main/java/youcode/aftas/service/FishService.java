package youcode.aftas.service;

import org.springframework.stereotype.Service;
import youcode.aftas.domain.Fish;

import java.util.List;

@Service
public interface FishService {
    List<Fish> findAllByOrderByLevelAsc();
    Fish getFishById(long id);
    Fish addFish(Fish fish);
    Fish updateFish(Fish fish, long id);
    void deleteFish(long id);
}
