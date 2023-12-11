package youcode.aftas.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import youcode.aftas.domain.Competition;
import youcode.aftas.domain.Member;
import youcode.aftas.domain.Ranking;
import youcode.aftas.repository.RankingRepository;
import youcode.aftas.service.RegistrationService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RequiredArgsConstructor
@Component
public class RegistrationServiceImpl implements RegistrationService {

        private final RankingRepository rankingRepository;

        @Override
        public boolean isRegistrationAllowed(Member member, Competition competition) {
            LocalDateTime accessDateTime = member.getAccessDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            LocalDateTime competitionStartDateTime = competition.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

            Duration duration = Duration.between(accessDateTime, competitionStartDateTime);
            return duration.toHours() >= 24;
        }

        @Override
        public boolean isUserAlreadyRegistered(Member member, Competition competition) {
            return rankingRepository.existsByMemberAndCompetition(member, competition);
        }


        @Override
        public void registerUser(Member member, Competition competition) {
            if (!isRegistrationAllowed(member, competition))
                throw new RuntimeException("Registration is not allowed");
            if (isUserAlreadyRegistered(member, competition))
                throw new RuntimeException("User is already registered");
            if (countByParticipantsId(competition.getId()) >= competition.getNumberOfParticipants())
                throw new RuntimeException("Competition is full");
            Ranking ranking = new Ranking();
            ranking.setMember(member);
            ranking.setCompetition(competition);
            rankingRepository.save(ranking);
        }

        @Override
        public int countByParticipantsId(Long competitionId) {
            return rankingRepository.countByParticipantsId(competitionId);
        }
    }

