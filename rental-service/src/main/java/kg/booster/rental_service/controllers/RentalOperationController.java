package kg.booster.rental_service.controllers;

import kg.booster.rental_service.models.dtos.CreateOperationDto;
import kg.booster.rental_service.models.dtos.CreateOperationSuccessResponse;
import kg.booster.rental_service.models.dtos.SearchOperationDto;
import kg.booster.rental_service.models.dtos.SearchOperationResult;
import kg.booster.rental_service.services.RentalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rent")
public class RentalOperationController {

    private final RentalService rentalService;

    public RentalOperationController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOperation(@RequestBody CreateOperationDto createOperationDto){
        Long rentalOperationId = rentalService.createOperation(createOperationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CreateOperationSuccessResponse(rentalOperationId, "Rental operation created successfully"));
    }

            @GetMapping("/filter")
            public ResponseEntity<?> searchOperation(@RequestBody SearchOperationDto searchOperationDto){
        List<SearchOperationResult> searchOperationResults = rentalService.searchOperations(searchOperationDto);

    }
}
