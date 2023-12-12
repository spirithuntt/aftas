package com.example.aftas.web.controller;

import com.example.aftas.domain.Level;
import com.example.aftas.dto.requests.LevelRequestDTO;
import com.example.aftas.dto.responses.HuntingResponseDTO;
import com.example.aftas.dto.responses.LevelResponseDTO;
import com.example.aftas.handler.response.ResponseMessage;
import com.example.aftas.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/levels")
public class LevelController {

    private final LevelService levelService;

    @GetMapping
    public ResponseEntity getAll(){
        List<Level> levels = levelService.getAll();
        if (levels.isEmpty()) return ResponseMessage.notFound("No level was found");
        else return ResponseMessage.ok("Levels fetched successfully", levels.stream().map(LevelResponseDTO::fromLevel).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity getLevelById(@PathVariable Long id){
        Level level = levelService.getById(id);
        if(level == null) return ResponseMessage.notFound("Level not found");
        else return ResponseMessage.ok("Success", LevelResponseDTO.fromLevel(level));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity getLevelByCode(@PathVariable Integer code){
        Level level = levelService.getByCode(code);
        if(level == null) return ResponseMessage.notFound("Level not found");
        else return ResponseMessage.ok("Success", LevelResponseDTO.fromLevel(level));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody LevelRequestDTO level){
        Level level1 = levelService.save(level.toLevel());
        if (level1 == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Level created successfully", LevelResponseDTO.fromLevel(level1));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody LevelRequestDTO level, @PathVariable Long id){
        Level level1 = levelService.update(level.toLevel(), id);
        if (level1 == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Level updated successfully", LevelResponseDTO.fromLevel(level1));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Level level = levelService.getById(id);
        if (level == null) return ResponseMessage.notFound("Level not found");
        else {
            levelService.delete(id);
            return ResponseMessage.ok("Level deleted successfully", LevelResponseDTO.fromLevel(level));
        }
    }
}
