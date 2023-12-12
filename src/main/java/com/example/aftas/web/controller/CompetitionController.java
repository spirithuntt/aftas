package com.example.aftas.web.controller;

import com.example.aftas.domain.Competition;
import com.example.aftas.dto.requests.CompetitionRequestDTO;
import com.example.aftas.handler.response.ResponseMessage;
import com.example.aftas.service.CompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/competitions")
public class CompetitionController {

    private final CompetitionService competitionService;

    @GetMapping
    public ResponseEntity getAll(){
        List<Competition> competitions = competitionService.getAll();
        if (competitions.isEmpty()) return ResponseMessage.notFound("No competition was found");
        else return ResponseMessage.ok("Competitions fetched successfully", competitions);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCompetitionById(@PathVariable Long id){
        Competition competition = competitionService.getById(id);
        if(competition == null) return ResponseMessage.notFound("Competition not found");
        else return ResponseMessage.ok("Success", competition);
    }

    @GetMapping("/code/{code}")
    public ResponseEntity getCompetitionByCode(@PathVariable String code){
        Competition competition = competitionService.getByCode(code);
        if(competition == null) return ResponseMessage.notFound("Competition not found");
        else return ResponseMessage.ok("Success", competition);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CompetitionRequestDTO competition){
        Competition competition1 = competitionService.save(competition.toCompetition());
        if (competition1 == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Competition created successfully", competition1);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody CompetitionRequestDTO competition, @PathVariable Long id){
        Competition competition1 = competitionService.update(competition.toCompetition(), id);
        if (competition1 == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Competition updated successfully", competition1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Competition competition = competitionService.getById(id);
        if (competition == null) return ResponseMessage.notFound("Competition not found");
        else {
            competitionService.delete(id);
            return ResponseMessage.ok("Competition deleted successfully", competition);
        }
    }

}
