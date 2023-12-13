package youcode.aftas.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    @NotNull(message = "Shooting Level can not be null")
    private Integer shootingLevel;

    @Size(min = 4, max = 20, message = "Description must be between 7 and 20 characters")
    private String description;

    @Column(unique = true)
    @NotNull(message = "Points can not be null")
    private Integer points;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "level")
    @ToString.Exclude
    private List<Fish> fish;

    /*{
        "shootingLevel": 1,
        "description": "Beginner",
        "points": 10
    }*/

}
