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

    @Override
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
