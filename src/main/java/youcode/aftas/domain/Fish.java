package youcode.aftas.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Fish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "name can not be null")
    @Size(min = 3, max = 20, message = "name must be between 3 and 20 characters")
    private String name;

    @NotNull(message = "Average weight can not be null")
    private Double averageWeight;

    @OneToMany(mappedBy = "fish")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Hunting> hunting;

    @ManyToOne
    private Level level;


}
