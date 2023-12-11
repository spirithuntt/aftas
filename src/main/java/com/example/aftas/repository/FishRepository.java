package com.example.aftas.repository;

import com.example.aftas.domain.Fish;
import com.example.aftas.domain.Level;

import java.util.List;

public interface FishRepository {

    Fish save(Fish fish);

    List<Fish> getAll();

    Fish getByNameFish(String name);

    List<Fish> getByLevelFish(Level level);

    Fish getById(Long id);

    Fish update(Fish fish);

    void delete(Long id);
}
