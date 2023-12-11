package youcode.aftas.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hunting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Code can not be null")
    private Integer numberOfFish;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Fish fish;

}
