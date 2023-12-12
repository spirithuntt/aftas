package com.example.aftas.web.controller;

import com.example.aftas.domain.Hunting;
import com.example.aftas.dto.requests.HuntingRequestDTO;
import com.example.aftas.handler.response.ResponseMessage;
import com.example.aftas.service.HuntingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/huntings")
public class HuntingController {

    private final HuntingService huntingService;

    @GetMapping
    public ResponseEntity getAll(){
        List<Hunting> huntings = huntingService.getAll();
        if (huntings.isEmpty()) return ResponseMessage.notFound("No hunting was found");
        else return ResponseMessage.ok("Huntings fetched successfully", huntings);
    }

    @GetMapping("/{id}")
    public ResponseEntity getHuntingById(@PathVariable Long id){
        Hunting hunting = huntingService.getById(id);
        if(hunting == null) return ResponseMessage.notFound("Hunting not found");
        else return ResponseMessage.ok("Success", hunting);
    }

    @GetMapping("/member/{member}")
    public ResponseEntity getHuntingByMember(@PathVariable String member){
        List<Hunting> hunting = huntingService.getByMember(member);
        if(hunting == null) return ResponseMessage.notFound("Hunting not found");
        else return ResponseMessage.ok("Success", hunting);
    }

    @GetMapping("/competition/{competition}")
    public ResponseEntity getHuntingByCompetition(@PathVariable String competition){
        List<Hunting> hunting = huntingService.getByCompetition(competition);
        if(hunting == null) return ResponseMessage.notFound("Hunting not found");
        else return ResponseMessage.ok("Success", hunting);
    }

    @GetMapping("/competition_and_member/{competition}/{member}")
    public ResponseEntity getHuntingByCompetitionAndMember(@PathVariable String competition, @PathVariable String member){
        List<Hunting> hunting = huntingService.getByCompetitionAndMember(competition, member);
        if(hunting == null) return ResponseMessage.notFound("Hunting not found");
        else return ResponseMessage.ok("Success", hunting);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody HuntingRequestDTO hunting){
        Hunting hunting1 = huntingService.save(hunting.toHunting());
        if (hunting1 == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Hunting created successfully", hunting1);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody HuntingRequestDTO hunting, @PathVariable Long id){
        Hunting hunting1 = huntingService.update(hunting.toHunting(), id);
        if (hunting1 == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Hunting updated successfully", hunting1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Hunting hunting = huntingService.getById(id);
        if (hunting == null) return ResponseMessage.notFound("Hunting not found");
        else {
            huntingService.delete(id);
            return ResponseMessage.ok("Hunting deleted successfully", hunting);
        }
    }
}
