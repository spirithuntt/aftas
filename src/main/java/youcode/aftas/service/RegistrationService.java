package youcode.aftas.service;

import org.springframework.stereotype.Service;
import youcode.aftas.domain.Competition;
import youcode.aftas.domain.Member;

@Service
public interface RegistrationService {
    boolean isRegistrationAllowed(Member member, Competition competition);

    void registerUser(Member member, Competition competition);

    boolean isUserAlreadyRegistered(Member member, Competition competition);

    int countByParticipantsId(Long competitionId);
}
