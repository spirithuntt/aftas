package youcode.aftas.dto.requests;


import youcode.aftas.domain.Fish;
import youcode.aftas.domain.Level;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;
import youcode.aftas.service.LevelService;
    public record FishRequestDTO(
            @NotNull(message = "Name is required")
            @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
            @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Name must be alphanumeric")
            String name,

            @NotNull(message = "Average weight is required")
            @Range(min = 0, max = 1000, message = "Weight must be between 0 and 1000")
            @Positive(message = "Weight must be greater than 0")
            Double averageWeight,

            Level level

    ) {
        public Fish toFish() {
            Fish.FishBuilder fishBuilder = new Fish().builder()
                    .name(name)
                    .averageWeight(averageWeight);
            if (level != null) {
                fishBuilder.level(level);
            }
            else {
                throw new IllegalArgumentException("Level id is required");
            }
            return fishBuilder.build();
        }
    }
