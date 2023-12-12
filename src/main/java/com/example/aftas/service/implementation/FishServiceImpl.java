package com.example.aftas.service.implementation;

import com.example.aftas.dto.requests.FishRequestDTO;
import com.example.aftas.dto.responses.FishResponseDTO;
import com.example.aftas.service.FishService;

import java.util.List;

public class FishServiceImpl implements FishService {
    @Override
    public FishResponseDTO save(FishRequestDTO fish) {
        return null;
    }

    @Override
    public List<FishResponseDTO> getAll() {
        return null;
    }

    @Override
    public FishResponseDTO getByName(String name) {
        return null;
    }

    @Override
    public List<FishResponseDTO> getByLevel(Integer code) {
        return null;
    }

    @Override
    public FishResponseDTO getById(Long id) {
        return null;
    }

    @Override
    public FishResponseDTO update(FishRequestDTO fish, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
