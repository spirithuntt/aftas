package youcode.aftas.dto.responses;

import youcode.aftas.domain.Competition;

import java.sql.Time;
import java.util.Date;

public record CompetitionResponseDTO(
        String code,
        Date date,
        Time startTime,
        Time endTime,
        Integer numberOfParticipants,
        String location,
        Double amount
) {
    public static CompetitionResponseDTO fromCompetition(Competition competition) {
        return new CompetitionResponseDTO(
                competition.getCode(),
                competition.getDate(),
                competition.getStartTime(),
                competition.getEndTime(),
                competition.getNumberOfParticipants(),
                competition.getLocation(),
                competition.getAmount()
        );
    }
}
