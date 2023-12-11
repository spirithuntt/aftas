package youcode.aftas.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import youcode.aftas.domain.Fish;
import youcode.aftas.repository.FishRepository;
import youcode.aftas.service.FishService;

@Component
@RequiredArgsConstructor
public class FishServiceImpl implements FishService {
    private final FishRepository fishRepository;
    public void addFish(String name, Double averageWeight) {
        if (fishRepository.existsByName(name)) {
            System.out.println("Fish already exists");
        } else {

        }
    }




}
