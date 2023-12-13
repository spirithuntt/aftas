package youcode.aftas.dto.responses;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import youcode.aftas.domain.Level;

public record LevelResponseDTO(
        Integer code,
        String description,
        Integer points
) {
    public static LevelResponseDTO fromLevel(Level level){
        return new LevelResponseDTO(
                level.getShootingLevel(),
                level.getDescription(),
                level.getPoints()
        );
    }
}