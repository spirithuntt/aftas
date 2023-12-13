package youcode.aftas.controller.Impl;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import youcode.aftas.controller.LevelController;
import youcode.aftas.domain.Level;
import youcode.aftas.dto.requests.LevelRequestDTO;
import youcode.aftas.service.LevelService;
import youcode.aftas.handler.response.ResponseMessage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/levels")
public class LevelControllerImpl implements LevelController {

    private final LevelService levelService;

    public LevelControllerImpl(LevelService levelService) {
        this.levelService = levelService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getLevelById(@PathVariable Long id) {
        Level level = levelService.getLevelById(id);
        if(level == null) {
            return ResponseMessage.notFound("Level not found");
        }else {
            return ResponseMessage.ok("Success", level);
        }
    }

    @GetMapping
    public ResponseEntity getAllLevels() {
        List<Level> levels = levelService.getAllLevels();
        if(levels.isEmpty()) {
            return ResponseMessage.notFound("Levels not found");
        }else {
            return ResponseMessage.ok("Success", levels);
        }
    }



   @PostMapping
    public ResponseEntity addLevel(@Valid @RequestBody LevelRequestDTO levelRequestDTO) {
        Level level = levelService.addLevel(levelRequestDTO.toLevel());
        if(level == null) {
            return ResponseMessage.badRequest("Level not created");
        }else {
            return ResponseMessage.created("Level created successfully", level);
        }
    }



//TODO: // update level

    @DeleteMapping("/{id}")
    public ResponseEntity deleteLevel(@PathVariable Long id) {
        Level level = levelService.getLevelById(id);
        if(level == null) {
            return ResponseMessage.notFound("Level not found");
        }else {
            levelService.deleteLevel(id);
            return ResponseMessage.ok("Level deleted successfully", null);
        }
    }

}
