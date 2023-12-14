package youcode.aftas.service;

import org.springframework.stereotype.Service;
import youcode.aftas.domain.Ranking;
import youcode.aftas.dto.requests.RegistrationRequestDTO;

@Service
public interface RegistrationService {

    Ranking registerUserInCompetition(RegistrationRequestDTO registrationRequestDTO);
}
