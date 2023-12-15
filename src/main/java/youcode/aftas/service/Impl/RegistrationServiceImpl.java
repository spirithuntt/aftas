package youcode.aftas.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import youcode.aftas.domain.Competition;
import youcode.aftas.domain.Member;
import youcode.aftas.domain.Ranking;
import youcode.aftas.domain.RankId;
import youcode.aftas.dto.requests.RegistrationRequestDTO;
import youcode.aftas.repository.CompetitionRepository;
import youcode.aftas.repository.RankingRepository;
import youcode.aftas.service.CompetitionService;
import youcode.aftas.service.MemberService;
import youcode.aftas.service.RegistrationService;

@Component
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final MemberService  memberService;
    private final CompetitionService competitionService;
    private final RankingRepository rankingRepository;
    private final CompetitionRepository competitionRepository;

    @Override
    public Ranking registerUserInCompetition(RegistrationRequestDTO registrationRequestDTO) {
        Member member = memberService.getMemberById(registrationRequestDTO.member());
        if(member == null){
            throw new IllegalArgumentException();
        }
        Competition competition = competitionService.getCompetitionById(registrationRequestDTO.competition());
        if(competition == null){
            throw new IllegalArgumentException();
        }
        if(!competitionService.isCompetitionAvailableForRegistration(competition.getId())){
            throw new IllegalArgumentException();
        }

        if (rankingRepository.existsByMemberAndCompetition(member, competition)) {
            throw new RuntimeException("User already registered");
        }
        Ranking ranking = Ranking.builder()
                .id(RankId.builder()
                        .competitionId(competition.getId())
                        .memberId(member.getId())
                        .build())
                .rank(rankingRepository.countByParticipantsId(competition.getId()) + 1)
                .competition(competition)
                .member(member)
                .score(0)
                .build();
        return rankingRepository.save(ranking);
    }
}
