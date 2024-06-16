package kg.booster.rental_service.services;

import kg.booster.rental_service.models.dtos.CreateOperationDto;
import kg.booster.rental_service.models.entities.Client;

public interface ClientService {
    Client createOrUpdateClient(CreateOperationDto createOperationDto);
}
