package youcode.aftas.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Competition {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Code can not be null")
    @Size(min = 1, max = 20, message = "Code must be between 3 and 20 characters")
    private String Code;

    private Date date;

    private Time startTime;

    private Time endTime;

    @NotNull(message = "Number of participants can not be null")
    private Integer numberOfParticipants;

    @NotNull(message = "Location can not be null")
    @Size(min = 1, max = 20, message = "Location must be between 3 and 20 characters")
    private String location;

    @NotNull(message = "Amount can not be null")
    private Integer amount;

    @OneToMany(mappedBy = "competition")
    private List<Ranking> rankings;
}
