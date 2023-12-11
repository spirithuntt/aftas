package com.example.aftas.web.controller;

import com.example.aftas.domain.Ranking;
import com.example.aftas.handler.response.ResponseMessage;
import com.example.aftas.service.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/rankings")
public class RankingController {

    private final RankingService rankingService;

    @GetMapping
    public ResponseEntity getAll(){
        List<Ranking> rankings = rankingService.getAll();
        if (rankings.isEmpty()) return ResponseMessage.notFound("No ranking was found");
        else return ResponseMessage.ok("Rankings fetched successfully", rankings);
    }

    @GetMapping("/{id}")
    public ResponseEntity getRankingById(@PathVariable Long id){
        Ranking ranking = rankingService.getById(id);
        if(ranking == null) return ResponseMessage.notFound("Ranking not found");
        else return ResponseMessage.ok("Success", ranking);
    }

    @GetMapping("member/{member}")
    public ResponseEntity getRankingByMember(@PathVariable String member){
        List<Ranking> rankings = rankingService.getByMember(member);
        if(rankings.isEmpty()) return ResponseMessage.notFound("No ranking was found");
        else return ResponseMessage.ok("Success", rankings);
    }

    @GetMapping("competition/{competition}")
    public ResponseEntity getRankingByCompetition(@PathVariable String competition){
        List<Ranking> rankings = rankingService.getByCompetition(competition);
        if(rankings.isEmpty()) return ResponseMessage.notFound("Ranking not found");
        else return ResponseMessage.ok("Success", rankings);
    }

    @GetMapping("member_and_competition/{member}/{competition}")
    public ResponseEntity getRankingByMemberAndCompetition(@PathVariable String member, @PathVariable String competition){
        Ranking ranking = rankingService.getByMemberAndCompetition(member, competition);
        if(ranking == null) return ResponseMessage.notFound("Ranking not found");
        else return ResponseMessage.ok("Success", ranking);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Ranking ranking){
        Ranking ranking1 = rankingService.save(ranking);
        if (ranking1 == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Ranking created successfully", ranking1);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Ranking ranking, @PathVariable Long id){
        Ranking ranking1 = rankingService.update(ranking, id);
        if (ranking1 == null) return ResponseMessage.badRequest("bad request");
        else return ResponseMessage.created("Ranking updated successfully", ranking1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        Ranking ranking = rankingService.getById(id);
        if (ranking == null) return ResponseMessage.notFound("Ranking not found");
        else {
            rankingService.delete(id);
            return ResponseMessage.ok("Ranking deleted successfully", ranking);
        }
    }
}
