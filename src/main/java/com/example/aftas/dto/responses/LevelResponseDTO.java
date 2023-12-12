package com.example.aftas.dto.responses;

import com.example.aftas.domain.Level;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record LevelResponseDTO(
    Integer code,
    String description,
    Integer points
) {
    public static LevelResponseDTO fromLevel(Level level){
        return new LevelResponseDTO(
                level.getCode(),
                level.getDescription(),
                level.getPoints()
        );
    }
}
