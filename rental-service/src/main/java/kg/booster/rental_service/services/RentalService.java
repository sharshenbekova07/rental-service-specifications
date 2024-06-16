package kg.booster.rental_service.services;

import kg.booster.rental_service.models.dtos.CreateOperationDto;
import kg.booster.rental_service.models.dtos.SearchOperationDto;
import kg.booster.rental_service.models.dtos.SearchOperationResult;

import java.util.List;

public interface RentalService {
    Long createOperation(CreateOperationDto createOperationDto);

    List<SearchOperationResult> searchOperations(SearchOperationDto searchOperationDto);
}
