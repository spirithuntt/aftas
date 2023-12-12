package com.example.aftas.service;

import com.example.aftas.dto.requests.FishRequestDTO;
import com.example.aftas.dto.responses.FishResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FishService {

    FishResponseDTO save(FishRequestDTO fish);

    List<FishResponseDTO> getAll();

    FishResponseDTO getByName(String name);

    List<FishResponseDTO> getByLevel(Integer code);

    FishResponseDTO getById(Long id);

    FishResponseDTO update(FishRequestDTO fish, Long id);

    void delete(Long id);

}
