package kg.booster.rental_service.mappers;

import kg.booster.rental_service.models.dtos.CreateOperationDto;
import kg.booster.rental_service.models.entities.Client;

public interface ClientMapper {
    Client createOperationDtoToClient(Client client, CreateOperationDto createOperationDto);
}
