package com.example.aftas.service.implementation;

import com.example.aftas.domain.Level;
import com.example.aftas.service.LevelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelServiceImpl implements LevelService {
    @Override
    public Level save(Level level) {
        return null;
    }

    @Override
    public List<Level> getAll() {
        return null;
    }

    @Override
    public Level getById(Long id) {
        return null;
    }

    @Override
    public Level getByCode(Integer code){ return null; }

    @Override
    public Level update(Level level, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void checkIfLevelIsValid(Level level) {

    }
}
