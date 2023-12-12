package com.example.aftas.web.controller;

import com.example.aftas.dto.requests.FishRequestDTO;
import com.example.aftas.dto.responses.FishResponseDTO;
import com.example.aftas.handler.response.ResponseMessage;
import com.example.aftas.service.FishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fishes")
public class FishController {

    private final FishService fishService;

    @GetMapping
    public ResponseEntity getAll(){
        List<FishResponseDTO> fishes = fishService.getAll();
        if (fishes.isEmpty()) return ResponseMessage.notFound("No fish was found");
        else return ResponseMessage.ok("Fishes fetched successfully", fishes);
    }

    @GetMapping("/{id}")
    public ResponseEntity getFishById(@PathVariable Long id){
        FishResponseDTO fish = fishService.getById(id);
        if(fish == null) return ResponseMessage.notFound("Fish not found");
        else return ResponseMessage.ok("Success", fish);
    }


    @GetMapping("/{name}")
    public ResponseEntity getFishByName(@PathVariable String name){
        FishResponseDTO fish = fishService.getByName(name);
        if(fish == null) return ResponseMessage.notFound("Fish not found");
        else return ResponseMessage.ok("Success", fish);
    }

    @GetMapping("/level/{level}")
    public ResponseEntity getFishByLevel(@PathVariable Integer level){
        List<FishResponseDTO> fishes = fishService.getByLevel(level);
        if(fishes.isEmpty()) return ResponseMessage.notFound("No Fish was found");
        else return ResponseMessage.ok("Success", fishes);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody FishRequestDTO fish){
        FishResponseDTO fish1 = fishService.save(fish);
        if (fish1 == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Fish created successfully", fish1);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody FishRequestDTO fish, @PathVariable Long id){
        FishResponseDTO fish1 = fishService.update(fish, id);
        if (fish1 == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Fish updated successfully", fish1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        FishResponseDTO fish = fishService.getById(id);
        if (fish == null) return ResponseMessage.notFound("Fish not found");
        else {
            fishService.delete(id);
            return ResponseMessage.ok("Fish deleted successfully", fish);
        }
    }

}
