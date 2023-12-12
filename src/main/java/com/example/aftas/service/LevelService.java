package com.example.aftas.service;

import com.example.aftas.domain.Level;
import com.example.aftas.dto.requests.LevelRequestDTO;
import com.example.aftas.dto.responses.LevelResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LevelService {

    LevelResponseDTO save(LevelRequestDTO level);

    List<LevelResponseDTO> getAll();

    LevelResponseDTO getById(Long id);

    LevelResponseDTO getByCode(Integer code);

    LevelResponseDTO update(LevelRequestDTO level, Long id);

    void delete(Long id);

    void checkIfLevelIsValid(Level level);

}
