package youcode.aftas.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import youcode.aftas.domain.Fish;
import youcode.aftas.domain.Hunting;
import youcode.aftas.domain.Member;
import youcode.aftas.repository.HuntingRepository;
import youcode.aftas.service.HuntingService;

@Component
@RequiredArgsConstructor
public class HuntingServiceImpl implements HuntingService {
    private final HuntingRepository huntingRepository;

    public Hunting insertHunting(Fish fish, Member member) {
        Hunting hunting = huntingRepository.findByFishIdAndMemberId(fish.getId(), member.getId());

        if (hunting == null) {
            hunting = new Hunting();
            hunting.setFish(fish);
            hunting.setMember(member);
            hunting.setNumberOfFish(1);
        }

        hunting.setNumberOfFish(hunting.getNumberOfFish() + 1);

        return huntingRepository.save(hunting);
    }

}
