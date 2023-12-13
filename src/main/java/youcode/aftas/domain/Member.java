package youcode.aftas.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import youcode.aftas.enums.IdentityDocumentType;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "name can not be null")
    @Size(min = 3, max = 20, message = "name must be between 3 and 20 characters")
    private String name;

    @NotNull(message = "Family name can not be null")
    @Size(min = 3, max = 20, message = "Family name must be between 3 and 20 characters")
    private String familyName;

    @PastOrPresent(message = "Access date must be in the past or present")
    @Temporal(TemporalType.DATE)
    private Date accessDate;

    @NotNull(message = "Nationality can not be null")
    private String nationality;

    @Enumerated(EnumType.STRING)
    private IdentityDocumentType identityDocumentType;

    @NotNull(message = "Identity number can not be null")
    @Column(unique = true)
    private String identityNumber;

    @OneToMany(mappedBy = "member")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Ranking> ranking;


    @OneToMany(mappedBy = "member")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Hunting> hunting;

}
