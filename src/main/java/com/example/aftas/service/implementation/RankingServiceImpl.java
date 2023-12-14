package com.example.aftas.service.implementation;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Member;
import com.example.aftas.domain.RankId;
import com.example.aftas.domain.Ranking;
import com.example.aftas.repository.RankingRepository;
import com.example.aftas.service.CompetitionService;
import com.example.aftas.service.MemberService;
import com.example.aftas.service.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RankingServiceImpl implements RankingService {

    private final RankingRepository rankingRepository;
    private final CompetitionService competitionService;
    private final MemberService memberService;

    @Override
    public Ranking save(Ranking ranking) {
        Member member = memberService.getByNumber(ranking.getMember().getNumber());
        Competition competition = competitionService.getByCode(ranking.getCompetition().getCode());
        Integer participants = getByCompetition(competition.getCode()).size();
        if(getAll().stream().filter(ranking1 -> ranking1.getCompetition().equals(competition) && ranking1.getMember().equals(member)).toList().isEmpty() && participants < competition.getNumberOfParticipants() && LocalDate.now().isBefore(competition.getDate())){
            ranking.setCompetition(competition);
            ranking.setMember(member);
            ranking.setScore(0);
            ranking.setRank(participants+1);
            ranking.setId(new RankId(competition.getId(), member.getId()));
            return rankingRepository.save(ranking);
        }
        return null;
    }

    @Override
    public List<Ranking> getAll() {
        return rankingRepository.findAll();
    }

    @Override
    public Ranking getById(RankId id) {
        return null;
    }

    @Override
    public List<Ranking> getByMember(Integer member) {
        return null;
    }

    @Override
    public List<Ranking> getByCompetition(String competition) {
        Competition competition1 = competitionService.getByCode(competition);
        return rankingRepository.getRankingByCompetition(competition1);
    }

    @Override
    public Ranking getByMemberAndCompetition(Integer member, String competition) {
        Member member1 = memberService.getByNumber(member);
        Competition competition1 = competitionService.getByCode(competition);
        return rankingRepository.getRankingByMemberAndCompetition(member1, competition1);
    }

    @Override
    public Ranking update(Ranking ranking) {
        Ranking existingRanking = getByMemberAndCompetition(ranking.getMember().getNumber(), ranking.getCompetition().getCode());
        if (existingRanking != null){
            existingRanking.setRank(ranking.getRank());
            existingRanking.setScore(ranking.getScore());
            return rankingRepository.save(existingRanking);
        }
        return null;
    }

    @Override
    public List<Ranking> sortParticipantsByScore(String competition){
        List<Ranking> rankings = getByCompetition(competition).stream().sorted(Comparator.comparing(Ranking::getScore).reversed()).toList();
        if (!rankings.isEmpty()){
            for (int i = 0; i < rankings.size(); i++) {
                rankings.get(i).setRank(i+1);
                update(rankings.get(i));
            }
            return rankings;
        }
        return null;
    }

    @Override
    public void delete(Ranking ranking) {
        rankingRepository.delete(ranking);
    }
}
