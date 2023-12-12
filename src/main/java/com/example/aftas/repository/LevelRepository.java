package com.example.aftas.repository;

import com.example.aftas.domain.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {

    Level getLevelById(Long id);

    Level getLevelByCode(Integer code);

}