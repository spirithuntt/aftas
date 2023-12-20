package com.example.aftas.service.implementation;

import com.example.aftas.domain.*;
import com.example.aftas.domain.enums.IdentityDocumentType;
import com.example.aftas.repository.HuntingRepository;
import com.example.aftas.service.CompetitionService;
import com.example.aftas.service.FishService;
import com.example.aftas.service.MemberService;
import com.example.aftas.service.RankingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class HuntingServiceImplTest {

    @Mock
    private FishService fishService;

    @Mock
    private RankingService rankingService;

    @Mock
    private CompetitionService competitionService;

    @Mock
    private MemberService memberService;

    @Mock
    private HuntingRepository huntingRepository;

    @InjectMocks
    private HuntingServiceImpl huntingService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save_WeightGreaterAndRankingNotNull_NewHunt() {
        // Arrange
        Integer number = 20;
        LocalDate date = LocalDate.of(2024, 11, 10);
        LocalTime time = LocalTime.of(11,11);
        Hunting hunting = new Hunting(1L, new Fish(1L, "fish", 10.0, new Level(1L, number, "hard", number)), new Member(1L, number, "name", "last name", date, "morocco", IdentityDocumentType.CIN, "12345"), new Competition(1L, "12345", date, time, time, number, "location", 10.0), number); // Create a Hunting object with necessary properties
        Double weight = 10.0; // Weight greater than averageWeight

        Fish fish = new Fish();
        fish.setName("Trout");
        fish.setAverageWeight(5.0);
        hunting.setFish(fish);

        Member member = new Member();
        member.setNumber(123);
        hunting.setMember(member);

        Competition competition = new Competition();
        competition.setCode("comp1");
        hunting.setCompetition(competition);

        Ranking ranking = new Ranking();
        ranking.setScore(10);

        // Mock the behavior of dependencies
        when(fishService.getByName(anyString())).thenReturn(fish);
        when(rankingService.getByMemberAndCompetition(number, anyString())).thenReturn(ranking);
        when(competitionService.getByCode(anyString())).thenReturn(competition);
        when(memberService.getByNumber(number)).thenReturn(member);
        when(huntingRepository.save(any(Hunting.class))).thenReturn(hunting);

        // Act
        Hunting result = huntingService.save(hunting, weight);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getNumberOfFish());
        verify(huntingRepository).save(hunting);
        verify(rankingService).update(ranking);
        assertEquals(10 + fish.getLevel().getPoints(), ranking.getScore());
    }

}
