package com.example.aftas.repository;

import com.example.aftas.domain.Fish;
import com.example.aftas.domain.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FishRepository extends JpaRepository<Fish, Long> {

    Fish getFishByName(String name);

    List<Fish> getFishByLevel(Level level);

    Fish getFishById(Long id);

}
