package com.example.aftas.web.controller;

import com.example.aftas.domain.Fish;
import com.example.aftas.dto.requests.FishRequestDTO;
import com.example.aftas.dto.responses.CompetitionResponseDTO;
import com.example.aftas.dto.responses.FishResponseDTO;
import com.example.aftas.handler.response.ResponseMessage;
import com.example.aftas.service.FishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fishes")
public class FishController {

    private final FishService fishService;

    @PreAuthorize("(hasAnyAuthority('ORGANIZE_COMPETITION_TASKS'))")
    @GetMapping
    public ResponseEntity getAll(){
        List<Fish> fishes = fishService.getAll();
        if (fishes.isEmpty()) return ResponseMessage.notFound("No fish was found");
        else return ResponseMessage.ok("Fishes fetched successfully", fishes.stream().map(FishResponseDTO::fromFish).toList());
    }
    @PreAuthorize("(hasAnyAuthority('ORGANIZE_COMPETITION_TASKS'))")
    @GetMapping("/{id}")
    public ResponseEntity getFishById(@PathVariable Long id){
        Fish fish = fishService.getById(id);
        if(fish == null) return ResponseMessage.notFound("Fish not found");
        else return ResponseMessage.ok("Success", FishResponseDTO.fromFish(fish));
    }

    @PreAuthorize("(hasAnyAuthority('ORGANIZE_COMPETITION_TASKS'))")
    @GetMapping("/{name}")
    public ResponseEntity getFishByName(@PathVariable String name){
        Fish fish = fishService.getByName(name);
        if(fish == null) return ResponseMessage.notFound("Fish not found");
        else return ResponseMessage.ok("Success", FishResponseDTO.fromFish(fish));
    }
    @PreAuthorize("(hasAnyAuthority('ORGANIZE_COMPETITION_TASKS'))")
    @GetMapping("/level/{level}")
    public ResponseEntity getFishByLevel(@PathVariable Integer level){
        List<Fish> fishes = fishService.getByLevel(level);
        if(fishes.isEmpty()) return ResponseMessage.notFound("No Fish was found");
        else{
            List<FishResponseDTO> fishResponseDTOS = fishes.stream().map(FishResponseDTO::fromFish).toList();
            return ResponseMessage.ok("Success", fishResponseDTOS);
        }
    }

    @PreAuthorize("(hasAnyAuthority('ORGANIZE_COMPETITION_TASKS'))")
    @PostMapping
    public ResponseEntity save(@RequestBody FishRequestDTO fish){
        Fish fish1 = fishService.save(fish.toFish());
        if (fish1 == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Fish created successfully", FishResponseDTO.fromFish(fish1));
    }

    @PreAuthorize("(hasAnyAuthority('ORGANIZE_COMPETITION_TASKS'))")
    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody FishRequestDTO fish, @PathVariable Long id){
        Fish fish1 = fishService.update(fish.toFish(), id);
        if (fish1 == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Fish updated successfully", FishResponseDTO.fromFish(fish1));
    }

    @PreAuthorize("(hasAnyAuthority('ORGANIZE_COMPETITION_TASKS'))")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Fish fish = fishService.getById(id);
        if (fish == null) return ResponseMessage.notFound("Fish not found");
        else {
            fishService.delete(id);
            return ResponseMessage.ok("Fish deleted successfully", FishResponseDTO.fromFish(fish));
        }
    }

}
