package com.example.aftas.service.implementation;

import com.example.aftas.domain.Level;
import com.example.aftas.dto.requests.LevelRequestDTO;
import com.example.aftas.dto.responses.LevelResponseDTO;
import com.example.aftas.service.LevelService;

import java.util.List;

public class LevelServiceImpl implements LevelService {
    @Override
    public LevelResponseDTO save(LevelRequestDTO level) {
        return null;
    }

    @Override
    public List<LevelResponseDTO> getAll() {
        return null;
    }

    @Override
    public LevelResponseDTO getById(Long id) {
        return null;
    }

    @Override
    public LevelResponseDTO getByCode(Integer code) {
        return null;
    }

    @Override
    public LevelResponseDTO update(LevelRequestDTO level, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void checkIfLevelIsValid(Level level) {

    }
}
