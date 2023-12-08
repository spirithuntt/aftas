package youcode.aftas.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Level can not be null")
    private Integer level;

    @Size(min = 4, max = 20, message = "Description must be between 7 and 20 characters")
    private String description;

    @NotNull(message = "Points can not be null")
    private Integer points;

    @OneToMany(mappedBy = "level")
    private List<Member> members;
}
