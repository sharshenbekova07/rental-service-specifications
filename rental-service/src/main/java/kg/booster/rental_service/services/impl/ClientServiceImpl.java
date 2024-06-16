package kg.booster.rental_service.services.impl;

import kg.booster.rental_service.mappers.ClientMapper;
import kg.booster.rental_service.models.dtos.CreateOperationDto;
import kg.booster.rental_service.models.entities.Client;
import kg.booster.rental_service.repositories.ClientRepo;
import kg.booster.rental_service.services.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepo clientRepo;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepo clientRepo, ClientMapper clientMapper) {
        this.clientRepo = clientRepo;
        this.clientMapper = clientMapper;
    }

    @Override
    public Client createOrUpdateClient(CreateOperationDto createOperationDto) {
        Client client = clientRepo.findByInn(createOperationDto.inn()).orElse(new Client());
        client = clientMapper.createOperationDtoToClient(client, createOperationDto);
        return clientRepo.save(client);
    }
}
