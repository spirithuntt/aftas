package com.example.aftas.repository;

import com.example.aftas.domain.Level;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LevelRepository extends JpaRepository<Level, Long> {

    Level getLevelById(Long id);

    Level getLevelByCode(Integer code);

}