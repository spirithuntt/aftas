package youcode.aftas.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import youcode.aftas.domain.Ranking;
import youcode.aftas.dto.requests.RegistrationRequestDTO;
import youcode.aftas.service.RegistrationService;

@RestController
@RequestMapping("/api/registrations")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/register-user")
    public Ranking registerUserInCompetition(@RequestBody @Valid RegistrationRequestDTO registrationRequestDTO) {
        return registrationService.registerUserInCompetition(registrationRequestDTO);
    }
}
