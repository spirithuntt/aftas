package com.example.aftas.web.controller;

import com.example.aftas.domain.Competition;
import com.example.aftas.dto.requests.CompetitionRequestDTO;
import com.example.aftas.dto.responses.CompetitionResponseDTO;
import com.example.aftas.dto.responses.PaginationResponseDTO;
import com.example.aftas.handler.response.ResponseMessage;
import com.example.aftas.service.CompetitionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        else return ResponseMessage.ok("Competitions fetched successfully", competitions.stream().map(CompetitionResponseDTO::fromCompetition).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity getCompetitionById(@PathVariable Long id){
        Competition competition = competitionService.getById(id);
        if(competition == null) return ResponseMessage.notFound("Competition not found");
        else return ResponseMessage.ok("Success", CompetitionResponseDTO.fromCompetition(competition));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity getCompetitionByCode(@PathVariable String code){
        Competition competition = competitionService.getByCode(code);
        if(competition == null) return ResponseMessage.notFound("Competition not found");
        else return ResponseMessage.ok("Success", CompetitionResponseDTO.fromCompetition(competition));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid CompetitionRequestDTO competition){
        Competition competition1 = competitionService.save(competition.toCompetition());
        if (competition1 == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Competition created successfully", CompetitionResponseDTO.fromCompetition(competition1));
    }

    @PostMapping("/page")
    public ResponseEntity getAllCompetitions(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "8") int size){
        Pageable paginating = PageRequest.of(page,size);
        Page<Competition> competitionPage=competitionService.getAll(paginating);

        if (competitionPage == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Competition created successfully", new PaginationResponseDTO(competitionPage.getNumber(),competitionPage.getTotalPages(),competitionPage.getTotalElements(),competitionPage.stream().map(CompetitionResponseDTO::fromCompetition).toList(),competitionPage.getSize()));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody @Valid CompetitionRequestDTO competition, @PathVariable Long id){
        Competition competition1 = competitionService.update(competition.toCompetition(), id);
        if (competition1 == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Competition updated successfully", CompetitionResponseDTO.fromCompetition(competition1));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Competition competition = competitionService.getById(id);
        if (competition == null) return ResponseMessage.notFound("Competition not found");
        else {
            competitionService.delete(id);
            return ResponseMessage.ok("Competition deleted successfully", CompetitionResponseDTO.fromCompetition(competition));
        }
    }

}
