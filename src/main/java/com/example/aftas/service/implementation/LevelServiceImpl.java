package com.example.aftas.service.implementation;

import com.example.aftas.domain.Level;
import com.example.aftas.repository.LevelRepository;
import com.example.aftas.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;

    @Override
    public Level save(Level level) {
        if (checkIfLevelIsValid(level)) return levelRepository.save(level);
        return null;
    }

    @Override
    public List<Level> getAll() {
        return levelRepository.findAll();
    }

    @Override
    public Level getById(Long id) {
        return levelRepository.getLevelById(id);
    }

    @Override
    public Level getByCode(Integer code) {
        return levelRepository.getLevelByCode(code);
    }

    @Override
    public Level update(Level level, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Level level = getById(id);
        if (level != null) {
            levelRepository.delete(level);
        }
    }

    @Override
    public Boolean checkIfLevelIsValid(Level level) {
        List<Level> levels = getAll();
        if (levels.isEmpty())return true;
        Level lastLevel = getAll().stream().sorted(Comparator.comparing(Level::getCode)).toList().get(getAll().size()-1);
        return level.getPoints() > lastLevel.getPoints();
    }
}
