package youcode.aftas.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import youcode.aftas.domain.Fish;
import youcode.aftas.repository.FishRepository;
import youcode.aftas.service.FishService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FishServiceImpl implements FishService {
    private final FishRepository fishRepository;
    @Override
    public void addFish(String name, Double averageWeight) {
        if (fishRepository.existsByName(name)) {
            throw new RuntimeException("Fish already exists");
        }
        else {
            Fish fish = new Fish();
            fish.setName(name);
            fish.setAverageWeight(averageWeight);
            fishRepository.save(fish);
        }
    }


    @Override
    public List<Fish> findAllByOrderByLevelAsc() {
        return fishRepository.findAllByOrderByLevelAsc();
    }



}
