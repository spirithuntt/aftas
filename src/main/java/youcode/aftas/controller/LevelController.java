package youcode.aftas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import youcode.aftas.domain.Level;
import youcode.aftas.dto.requests.LevelRequestDTO;

@Controller
public interface LevelController {
    ResponseEntity<?> getLevelById(Long id);
    ResponseEntity<?> getAllLevels();
    ResponseEntity<?> deleteLevel(Long id);
    ResponseEntity<?> addLevel(LevelRequestDTO levelRequestDTO);
}
