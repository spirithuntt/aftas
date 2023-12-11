package youcode.aftas.service;

import org.springframework.stereotype.Service;
import youcode.aftas.domain.Fish;
import youcode.aftas.domain.Hunting;
import youcode.aftas.domain.Member;

@Service
public interface HuntingService {
    Hunting insertHunting(Fish fish, Member member);

}
