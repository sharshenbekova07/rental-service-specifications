package kg.booster.rental_service.mappers;

import kg.booster.rental_service.models.dtos.CreateOperationDto;
import kg.booster.rental_service.models.entities.Document;

public interface DocumentMapper {
    Document createOperationDtoToDocument(CreateOperationDto createOperationDto);
}
