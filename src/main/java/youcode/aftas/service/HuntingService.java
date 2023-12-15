package youcode.aftas.service;

import org.springframework.stereotype.Service;
import youcode.aftas.domain.Fish;
import youcode.aftas.domain.Hunting;
import youcode.aftas.domain.Member;

@Service
public interface HuntingService {
    Hunting insertHunting(Hunting hunting, Double weight);

    Hunting getHuntingById(Long id);

    Hunting updateHunting(Hunting hunting, Long id);

    void deleteHunting(Long id);


}
