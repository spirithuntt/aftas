package youcode.aftas.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import youcode.aftas.domain.Competition;
import youcode.aftas.domain.Fish;
import youcode.aftas.domain.Hunting;
import youcode.aftas.domain.Member;
import youcode.aftas.repository.FishRepository;
import youcode.aftas.repository.HuntingRepository;
import youcode.aftas.repository.MemberRepository;
import youcode.aftas.service.*;

@Component
@RequiredArgsConstructor
public class HuntingServiceImpl implements HuntingService {
    private final HuntingRepository huntingRepository;
    private final FishService fishService;
    private final MemberService memberService;
    private final CompetitionService competitionService;
    private final RankingService rankingService;

    @Override
    public Hunting insertHunting(Hunting hunting, Double weight) {

        Fish fish = hunting.getFish();
        Member member = hunting.getMember();
        Competition competition = hunting.getCompetition();

        Fish fish1 = fishService.getFishById(fish.getId());
        Member member1 = memberService.getMemberById(member.getId());
        Competition competition1 = competitionService.getCompetitionById(competition.getId());
        if (fish1 == null) {
            throw new RuntimeException("Fish not found");
        }
        else if (member1 == null) {
            throw new RuntimeException("Member not found");
        }
        else if (competition1 == null) {
            throw new RuntimeException("Competition not found");
        }
        else if (rankingService.getRankingByCompetitionIdAndMemberId(competition.getId(), member.getId()) == null) {
            throw new RuntimeException("Member not found in this competition");
        }
        else if (fish1.getAverageWeight() > weight) {
            throw new RuntimeException("Weight is too low it will not be saved");
        }
        Hunting hunting1 = huntingRepository.findByFishIdAndMemberId(fish.getId(), member.getId());

        if (hunting1 == null) {
            hunting1 = new Hunting();
            hunting1.setFish(fish);
            hunting1.setMember(member);
            hunting1.setNumberOfFish(1);
        }
        else {
            hunting1.setNumberOfFish(hunting1.getNumberOfFish() + 1);
        }

        return huntingRepository.save(hunting1);
    }
    @Override
    public Hunting getHuntingById(Long id) {
        return huntingRepository.findById(id).orElseThrow(() -> new RuntimeException("Hunting not found"));
    }



    @Override
    public Hunting updateHunting(Hunting hunting) {
        Hunting huntingToUpdate = huntingRepository.findById(hunting.getId());

        if (huntingToUpdate == null) {
            throw new RuntimeException("Hunting not found");
        } else {
            huntingToUpdate.setFish(hunting.getFish());
            huntingToUpdate.setMember(hunting.getMember());
            huntingToUpdate.setNumberOfFish(hunting.getNumberOfFish());
            return huntingRepository.save(huntingToUpdate);
        }
    }

    @Override
    public void deleteHunting(Long id) {
        huntingRepository.deleteById(id);
    }
}
