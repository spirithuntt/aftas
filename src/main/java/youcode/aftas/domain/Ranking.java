package youcode.aftas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ranking {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int rank;

    private int score;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Competition competition;
}
