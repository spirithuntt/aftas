package youcode.aftas.service;

import org.springframework.stereotype.Service;
import youcode.aftas.domain.Fish;

import java.util.List;

@Service
public interface FishService {
    void addFish(String name, Double averageWeight);

    List<Fish> findAllByOrderByLevelAsc();
}
