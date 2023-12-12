package com.example.aftas.web.controller;

import com.example.aftas.domain.Fish;
import com.example.aftas.dto.requests.FishRequestDTO;
import com.example.aftas.dto.responses.CompetitionResponseDTO;
import com.example.aftas.dto.responses.FishResponseDTO;
import com.example.aftas.handler.response.ResponseMessage;
import com.example.aftas.service.FishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fishes")
public class FishController {

    private final FishService fishService;

    @GetMapping
    public ResponseEntity getAll(){
        List<Fish> fishes = fishService.getAll();
        if (fishes.isEmpty()) return ResponseMessage.notFound("No fish was found");
        else return ResponseMessage.ok("Fishes fetched successfully", fishes.stream().map(FishResponseDTO::fromFish).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity getFishById(@PathVariable Long id){
        Fish fish = fishService.getById(id);
        if(fish == null) return ResponseMessage.notFound("Fish not found");
        else return ResponseMessage.ok("Success", FishResponseDTO.fromFish(fish));
    }


    @GetMapping("/{name}")
    public ResponseEntity getFishByName(@PathVariable String name){
        Fish fish = fishService.getByName(name);
        if(fish == null) return ResponseMessage.notFound("Fish not found");
        else return ResponseMessage.ok("Success", FishResponseDTO.fromFish(fish));
    }

    @GetMapping("/level/{level}")
    public ResponseEntity getFishByLevel(@PathVariable Integer level){
        List<Fish> fishes = fishService.getByLevel(level);
        if(fishes.isEmpty()) return ResponseMessage.notFound("No Fish was found");
        else{
            List<FishResponseDTO> fishResponseDTOS = fishes.stream().map(FishResponseDTO::fromFish).toList();
            return ResponseMessage.ok("Success", fishResponseDTOS);
        }
    }

    @PostMapping
    public ResponseEntity save(@RequestBody FishRequestDTO fish){
        Fish fish1 = fishService.save(fish.toFish());
        if (fish1 == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Fish created successfully", FishResponseDTO.fromFish(fish1));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody FishRequestDTO fish, @PathVariable Long id){
        Fish fish1 = fishService.update(fish.toFish(), id);
        if (fish1 == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Fish updated successfully", FishResponseDTO.fromFish(fish1));
    }

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
