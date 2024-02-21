package com.example.aftas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ranking {

    @EmbeddedId
    private RankId id;

    @Column(columnDefinition = "integer default 0", name = "`rank`")
    private Integer rank;

    @Column(columnDefinition = "integer default 0")
    private Integer score;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @MapsId("memberId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "competition_id")
    @MapsId("competitionId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Competition competition;

}
