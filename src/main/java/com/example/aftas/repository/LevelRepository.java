package com.example.aftas.repository;

import com.example.aftas.domain.Level;

import java.util.List;

public interface LevelRepository {

    Level save(Level level);

    List<Level> getAll();

    Level getById(Long id);

    Level update(Level level);

    void delete(Long id);

}