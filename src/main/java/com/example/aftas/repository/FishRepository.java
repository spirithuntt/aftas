package com.example.aftas.repository;

import com.example.aftas.domain.Fish;
import com.example.aftas.domain.Level;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FishRepository extends JpaRepository<Fish, Long> {

    Fish getFishByName(String name);

    List<Fish> getFishByLevel(Level level);

    Fish getFishById(Long id);

}
