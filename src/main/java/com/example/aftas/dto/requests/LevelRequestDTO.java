package com.example.aftas.dto.requests;

import com.example.aftas.domain.Level;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record LevelRequestDTO(

    @NotNull(message = "the code can't be null")
    @Positive(message = "the code can't be negative")
    Integer code,

    @NotNull(message = "the description can't be null")
    @NotBlank(message = "the description can't be blank")
    @Size(max = 100, message = "the description you entered exceeded the length allowed")
    String description,

    @NotNull(message = "points can't be null")
    @Positive(message = "points can't be negative")
    Integer points
) {
    public Level toLevel() {
        return Level.builder()
                .code(code)
                .description(description)
                .points(points)
                .build();
    }
}