package kg.booster.rental_service.mappers;

import kg.booster.rental_service.models.dtos.CreateOperationDto;
import kg.booster.rental_service.models.entities.Client;
import kg.booster.rental_service.models.entities.Item;
import kg.booster.rental_service.models.entities.RentalOperation;
import kg.booster.rental_service.models.enums.Status;

import java.util.List;

public interface RentalOperationMapper {
    RentalOperation createOperationDtoAndClientToRentalOperation(CreateOperationDto createOperationDto, Client client, List<Item> items, double price, Status status);
}
