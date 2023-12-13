package youcode.aftas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import youcode.aftas.domain.Fish;
import youcode.aftas.dto.requests.FishRequestDTO;

import static org.springframework.data.projection.EntityProjection.ProjectionType.DTO;

@Controller
public interface FishController {
    ResponseEntity<?> getFishById(Long id);
    ResponseEntity<?> findAllByOrderByLevelAsc();
    ResponseEntity<?> addFish(FishRequestDTO fishRequestDTO);
    ResponseEntity<?> updateFish(FishRequestDTO fishRequestDTO, Long id);
    ResponseEntity<?> deleteFish(Long id);

}
