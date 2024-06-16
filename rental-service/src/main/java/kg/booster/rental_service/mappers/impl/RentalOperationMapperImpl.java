package kg.booster.rental_service.mappers.impl;

import kg.booster.rental_service.mappers.RentalOperationMapper;
import kg.booster.rental_service.models.dtos.CreateOperationDto;
import kg.booster.rental_service.models.entities.Client;
import kg.booster.rental_service.models.entities.Item;
import kg.booster.rental_service.models.entities.RentalOperation;
import kg.booster.rental_service.models.enums.Status;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RentalOperationMapperImpl implements RentalOperationMapper {

    @Override
    public RentalOperation createOperationDtoAndClientToRentalOperation(CreateOperationDto createOperationDto, Client client, List<Item> items, double price, Status status) {
        RentalOperation rentalOperation = new RentalOperation();
        rentalOperation.setClient(client);
        rentalOperation.setStartDate(createOperationDto.rentalStartDate());
        rentalOperation.setEndDate(createOperationDto.rentalEndDate());
        rentalOperation.setItems(items);
        rentalOperation.setPrice(price);
        rentalOperation.setStatus(status);
        return rentalOperation;
    }
}
