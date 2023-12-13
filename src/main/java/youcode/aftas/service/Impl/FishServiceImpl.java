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
    public List<Fish> findAllByOrderByLevelAsc() {
        return fishRepository.findAllByOrderByLevelAsc();
    }

    @Override
    public Fish getFishById(long id) {
        return fishRepository.findById(id);
    }

    @Override
    public Fish addFish(Fish fish) {
        if (fishRepository.existsByName(fish.getName())) {
            throw new RuntimeException("Fish already exists");
        }
        else {
            return fishRepository.save(fish);
        }
    }

    @Override
    public Fish updateFish(Fish fish, long id) {
        Fish fishToUpdate = fishRepository.findById(id);
        if (fishToUpdate == null) {
            throw new RuntimeException("Fish not found");
        }
        else {
            fishToUpdate.setName(fish.getName());
            fishToUpdate.setAverageWeight(fish.getAverageWeight());
            return fishRepository.save(fishToUpdate);
        }
    }

    @Override
    public void deleteFish(long id) {
        Fish fish = fishRepository.findById(id);
        if (fish == null) {
            throw new RuntimeException("Fish not found");
        }
        else {
            fishRepository.delete(fish);
        }
    }



}
