package youcode.aftas.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Pattern;

import java.sql.Time;
import java.util.Collection;
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

    //ex :  Imsouane: pattern: ims-22-12-23 (ims-yy-mm-dd)
    @Nullable
    @Pattern(regexp = "[a-z]{3}-[0-9]{2}-[0-9]{2}-[0-9]{2}", message = "Code must be like ims-22-12-23")
    private String code;

    private Date date;


    private Time startTime;

    private Time endTime;

    private int numberOfParticipants;

    @NotNull(message = "Location can not be null")
    @Size(min = 1, max = 20, message = "Location must be between 3 and 20 characters")
    private String location;

    @NotNull(message = "Amount can not be null")
    private Double amount;

    @OneToMany(mappedBy = "competition")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Ranking> ranking;

    @OneToMany(mappedBy = "competition")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Hunting> hunting;

}
