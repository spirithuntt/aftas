package youcode.aftas.controller.Impl;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import youcode.aftas.controller.HuntingController;
import youcode.aftas.domain.Hunting;
import youcode.aftas.dto.requests.HuntingRequestDTO;
import youcode.aftas.handler.response.ResponseMessage;
import youcode.aftas.service.HuntingService;

import java.util.List;

@RestController
    @RequestMapping("/api/huntings")
    public class HuntingControllerImpl implements HuntingController {

        private final HuntingService huntingService;

        public HuntingControllerImpl(HuntingService huntingService) {
            this.huntingService = huntingService;
        }

        @PostMapping("/add-hunting-result")
        public ResponseEntity insertHunting(@Valid @RequestBody HuntingRequestDTO huntingRequestDTO) {
            Hunting hunting = huntingService.insertHunting(huntingRequestDTO.toHunting().getFish(), huntingRequestDTO.toHunting().getMember());
            if(hunting == null) {
                return ResponseMessage.badRequest("Hunting result not added");
            }else {
                return ResponseMessage.created("Hunting result added successfully", hunting);
            }
        }

        // get hunting by id
        @GetMapping("/{id}")
        public ResponseEntity getHuntingById(@PathVariable Long id) {
            return ResponseMessage.ok("Success", huntingService.getHuntingById(id));
        }

    //TODO: // update hunting
        @DeleteMapping("/{id}")
        public ResponseEntity deleteHunting(@PathVariable Long id) {
            huntingService.deleteHunting(id);
            if (huntingService.getHuntingById(id) == null) {
                return ResponseMessage.ok("Hunting deleted successfully", null);
            } else {
                return ResponseMessage.badRequest("Hunting not deleted");
            }
        }
}
