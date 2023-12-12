package com.example.aftas.dto.responses;

import com.example.aftas.domain.Fish;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Range;

public record FishResponseDTO(
    String name,
    Double averageWeight,
    Integer level
) {
    public static FishResponseDTO fromFish(Fish fish){
        return new FishResponseDTO(
                fish.getName(),
                fish.getAverageWeight(),
                fish.getLevel() != null ? fish.getLevel().getCode() : null
        );
    }
}
