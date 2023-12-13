package com.example.aftas.service.implementation;

import com.example.aftas.domain.Fish;
import com.example.aftas.repository.FishRepository;
import com.example.aftas.service.FishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FishServiceImpl implements FishService {

    private final FishRepository fishRepository;

    @Override
    public Fish save(Fish fish) {
        return fishRepository.save(fish);
    }

    @Override
    public List<Fish> getAll() {
        return fishRepository.findAll();
    }

    @Override
    public Fish getByName(String name) {
        return fishRepository.getFishByName(name);
    }

    @Override
    public List<Fish> getByLevel(Integer level) {
        return null;
    }

    @Override
    public Fish getById(Long id) {
        return fishRepository.getFishById(id);
    }

    @Override
    public Fish update(Fish fish, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
