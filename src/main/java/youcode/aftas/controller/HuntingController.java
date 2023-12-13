package youcode.aftas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import youcode.aftas.dto.requests.HuntingRequestDTO;

@Controller
public interface HuntingController {
    ResponseEntity<?> getHuntingById(Long id);

    ResponseEntity<?> deleteHunting(Long id);

    ResponseEntity<?> insertHunting(HuntingRequestDTO huntingRequestDTO);

}
