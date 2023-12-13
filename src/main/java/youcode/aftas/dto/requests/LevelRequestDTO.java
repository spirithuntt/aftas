package youcode.aftas.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import youcode.aftas.domain.Level;

public record LevelRequestDTO(
        @NotNull(message = "the ShootingLevel can't be null")
        @Positive(message = "the ShootingLevel can't be negative")
        Integer shootingLevel,

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
                .shootingLevel(shootingLevel)
                .description(description)
                .points(points)
                .build();
    }
}
