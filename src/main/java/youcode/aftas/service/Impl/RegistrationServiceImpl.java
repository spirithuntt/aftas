package youcode.aftas.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import youcode.aftas.domain.Competition;
import youcode.aftas.domain.Member;
import youcode.aftas.domain.Ranking;
import youcode.aftas.repository.RankingRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RequiredArgsConstructor
@Component
public class RegistrationServiceImpl {

        private final RankingRepository rankingRepository;

        public boolean isRegistrationAllowed(Member member, Competition competition) {
            LocalDateTime accessDateTime = member.getAccessDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            LocalDateTime competitionStartDateTime = competition.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

            Duration duration = Duration.between(accessDateTime, competitionStartDateTime);
            return duration.toHours() >= 24;
        }

        public boolean isUserAlreadyRegistered(Member member, Competition competition) {
            return rankingRepository.existsByMemberAndCompetition(member, competition);
        }

        public void registerUser(Member member, Competition competition) {
            if (!isRegistrationAllowed(member, competition))
                throw new RuntimeException("Registration is not allowed");
            if (isUserAlreadyRegistered(member, competition))
                throw new RuntimeException("User is already registered");
            Ranking ranking = new Ranking();
            ranking.setMember(member);
            ranking.setCompetition(competition);
            rankingRepository.save(ranking);
        }

    }

