package com.example.aftas.web.controller;

import com.example.aftas.domain.Hunting;
import com.example.aftas.dto.requests.HuntingRequestDTO;
import com.example.aftas.dto.requests.UpdateHuntingRequestDTO;
import com.example.aftas.dto.responses.HuntingResponseDTO;
import com.example.aftas.handler.response.ResponseMessage;
import com.example.aftas.service.HuntingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hunting")
public class HuntingController {

    private final HuntingService huntingService;

    @PreAuthorize("(hasAnyAuthority('ACCESS_PODIUM_INFORMATION'))")
    @GetMapping
    public ResponseEntity getAll(){
        List<Hunting> hunts = huntingService.getAll();
        if (hunts.isEmpty()) return ResponseMessage.notFound("No hunting was found");
        else return ResponseMessage.ok("Hunts fetched successfully", hunts.stream().map(HuntingResponseDTO::fromHunting).toList());
    }

    @PreAuthorize("(hasAnyAuthority('ACCESS_PODIUM_INFORMATION'))")
    @GetMapping("/{id}")
    public ResponseEntity getHuntingById(@PathVariable Long id){
        Hunting hunting = huntingService.getById(id);
        if(hunting == null) return ResponseMessage.notFound("Hunting not found");
        else return ResponseMessage.ok("Success", HuntingResponseDTO.fromHunting(hunting));
    }

    @PreAuthorize("(hasAnyAuthority('ACCESS_PODIUM_INFORMATION'))")
    @GetMapping("/member/{member}")
    public ResponseEntity getHuntingByMember(@PathVariable Integer member){
        List<Hunting> hunts = huntingService.getByMember(member);
        if(hunts == null) return ResponseMessage.notFound("Hunting not found");
        else return ResponseMessage.ok("Success", hunts.stream().map(HuntingResponseDTO::fromHunting).toList());
    }

    @PreAuthorize("(hasAnyAuthority('ACCESS_PODIUM_INFORMATION'))")
    @GetMapping("/competition/{competition}")
    public ResponseEntity getHuntingByCompetition(@PathVariable String competition){
        List<Hunting> hunts = huntingService.getByCompetition(competition);
        if(hunts == null) return ResponseMessage.notFound("Hunting not found");
        else return ResponseMessage.ok("Success", hunts.stream().map(HuntingResponseDTO::fromHunting).toList());
    }

    @PreAuthorize("(hasAnyAuthority('ACCESS_PODIUM_INFORMATION'))")
    @GetMapping("/competition_and_member/{competition}/{member}")
    public ResponseEntity getHuntingByCompetitionAndMember(@PathVariable String competition, @PathVariable Integer member){
        List<Hunting> hunts = huntingService.getByCompetitionAndMember(competition, member);
        if(hunts == null) return ResponseMessage.notFound("Hunting not found");
        else return ResponseMessage.ok("Success", hunts.stream().map(HuntingResponseDTO::fromHunting).toList());
    }

    @PreAuthorize("hasAnyAuthority('EVALUATE_COMPETITION')")
    @PostMapping
    public ResponseEntity save(@RequestBody @Valid HuntingRequestDTO hunting){
        Hunting hunting1 = huntingService.save(hunting.toHunting(), hunting.weight());
        if (hunting1 == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Hunting created successfully", HuntingResponseDTO.fromHunting(hunting1));
    }
    @PreAuthorize("hasAnyAuthority('EVALUATE_COMPETITION')")
    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody UpdateHuntingRequestDTO hunting, @PathVariable Long id){
        Hunting hunting1 = huntingService.update(hunting.toHunting(), id);
        if (hunting1 == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Hunting updated successfully", HuntingResponseDTO.fromHunting(hunting1));
    }
    @PreAuthorize("hasAnyAuthority('EVALUATE_COMPETITION')")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Hunting hunting = huntingService.getById(id);
        if (hunting == null) return ResponseMessage.notFound("Hunting not found");
        else {
            huntingService.delete(id);
            return ResponseMessage.ok("Hunting deleted successfully", HuntingResponseDTO.fromHunting(hunting));
        }
    }
}
