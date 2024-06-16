package kg.booster.rental_service.services.impl;

import kg.booster.rental_service.mappers.RentalOperationMapper;
import kg.booster.rental_service.models.dtos.CreateOperationDto;
import kg.booster.rental_service.models.dtos.SearchOperationDto;
import kg.booster.rental_service.models.dtos.SearchOperationResult;
import kg.booster.rental_service.models.entities.Client;
import kg.booster.rental_service.models.entities.Item;
import kg.booster.rental_service.models.entities.RentalOperation;
import kg.booster.rental_service.models.enums.Status;
import kg.booster.rental_service.repositories.RentalOperationRepo;
import kg.booster.rental_service.services.ClientService;
import kg.booster.rental_service.services.ItemService;
import kg.booster.rental_service.services.RentalService;
import kg.booster.rental_service.specifications.RentalOperationSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class RentalServiceImpl implements RentalService {
    private final ClientService clientService;
    private final RentalOperationMapper rentalOperationMapper;
    private final ItemService itemService;
    private final RentalOperationRepo rentalOperationRepo;

    public RentalServiceImpl(ClientService clientService, RentalOperationMapper rentalOperationMapper, ItemService itemService, RentalOperationRepo rentalOperationRepo) {
        this.clientService = clientService;
        this.rentalOperationMapper = rentalOperationMapper;
        this.itemService = itemService;
        this.rentalOperationRepo = rentalOperationRepo;
    }

    @Override
    public Long createOperation(CreateOperationDto createOperationDto) {
        Client client = clientService.createOrUpdateClient(createOperationDto);
        List<Item> items = itemService.findItemsByInventoryNumbers(createOperationDto.itemInventoryNumbers());

        RentalOperation rentalOperation = rentalOperationMapper.createOperationDtoAndClientToRentalOperation(
                createOperationDto,
                client,
                items,
                countPriceForRent(items, createOperationDto.rentalStartDate(), createOperationDto.rentalEndDate()),
                Status.IN_PROCESS);

        rentalOperation = rentalOperationRepo.save(rentalOperation);

        return rentalOperation.getId();
    }

    @Override
    public List<SearchOperationResult> searchOperations(SearchOperationDto searchOperationDto) {
        Specification<RentalOperation> specification = Specification.where(
                RentalOperationSpecification.byLastName(searchOperationDto.lastName()))
                .and(RentalOperationSpecification.byItemInventory(searchOperationDto.itemInventoryNumber()));

        List<RentalOperation> rentalOperations = rentalOperationRepo.findAll(specification);

        return null;
    }

    private double countPriceForRent(List<Item> items, LocalDate startDate, LocalDate endDate) {
        return items
                .stream()
                .mapToDouble(x -> x.getPricePerDay() * DAYS.between(startDate, endDate))
                .sum();
    }


}
