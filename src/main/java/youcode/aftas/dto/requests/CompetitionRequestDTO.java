package youcode.aftas.dto.requests;

import io.micrometer.common.lang.Nullable;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import youcode.aftas.domain.Competition;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;


public record CompetitionRequestDTO(


        @Nullable
        String code,

        @NotNull(message = "Date shouldn't be null")
        @Future
        @DateTimeFormat(pattern = "yyyy-mm-dd")
        Date date,

        @NotNull(message = "Time shouldn't be null")
        @DateTimeFormat(pattern = "hh:mm")
        Time startTime,

        @NotNull(message = "Time shouldn't be null")
        @DateTimeFormat(pattern = "hh:mm")
        Time endTime,

        @NotNull(message = "Number of participants shouldn't be null")
        @Range(min = 1, message = "Number of participants must be greater than 1")
        Integer numberOfParticipants,

        @NotNull(message = "Location shouldn't be null")
        @NotBlank(message = "Location shouldn't be blank")
        @Size(min = 2, max = 100, message = "Location must be between 2 and 100 characters")
        String location,

        @NotNull(message = "Amount shouldn't be null")
        @Range(min = 0, message = "Amount must be greater than 0")
        Double amount
) {
    public Competition toCompetition() {
        Competition.CompetitionBuilder competitionBuilder = new Competition().builder()
                .code(code)
                .date(date)
                .startTime(startTime)
                .endTime(endTime)
                .numberOfParticipants(numberOfParticipants)
                .location(location)
                .amount(amount);
        return competitionBuilder.build();
    }
}