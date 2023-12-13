package youcode.aftas.controller.Impl;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import youcode.aftas.domain.Fish;
import youcode.aftas.dto.requests.FishRequestDTO;
import youcode.aftas.handler.response.ResponseMessage;
import youcode.aftas.service.FishService;
import youcode.aftas.controller.FishController;
import youcode.aftas.service.LevelService;

import java.util.List;

@RestController
@RequestMapping("/api/fishes")
public class FishControllerImpl implements FishController{

    private FishService fishService;

    public FishControllerImpl(FishService fishService) {
        this.fishService = fishService;
    }

    @GetMapping("{id}")
    public ResponseEntity getFishById(@PathVariable Long id) {
        Fish fish = fishService.getFishById(id);
        if(fish == null) {
            return ResponseMessage.notFound("Fish not found");
        }else {
            return ResponseMessage.ok("Success", fish);
        }
    }

    @GetMapping
    public ResponseEntity findAllByOrderByLevelAsc() {
        List<Fish> fishes = fishService.findAllByOrderByLevelAsc();
        if(fishes.isEmpty()) {
            return ResponseMessage.notFound("Fish not found");
        }else {
            return ResponseMessage.ok("Success", fishes);
        }
    }

    @PostMapping
    public ResponseEntity addFish(@Valid @RequestBody FishRequestDTO fishRequestDTO) {
        Fish fish = fishService.addFish(fishRequestDTO.toFish());
        if(fish == null) {
            return ResponseMessage.badRequest("Fish not created");
        }else {
            return ResponseMessage.created("Fish created successfully", fish);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateFish(@Valid @RequestBody FishRequestDTO fishRequestDTO, @PathVariable Long id) {
        Fish fish = fishService.updateFish(fishRequestDTO.toFish(), id);
        if(fish == null) {
            return ResponseMessage.badRequest("Fish not updated");
        }else {
            return ResponseMessage.created("Fish updated successfully", fish);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFish(@PathVariable Long id) {
        Fish fish = fishService.getFishById(id);
        if(fish == null) {
            return ResponseMessage.notFound("Fish not found");
        }else {
            fishService.deleteFish(id);
            return ResponseMessage.ok(null,"Fish deleted successfully");
        }
    }
}