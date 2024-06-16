package kg.booster.rental_service.mappers.impl;

import kg.booster.rental_service.mappers.ClientMapper;
import kg.booster.rental_service.mappers.DocumentMapper;
import kg.booster.rental_service.models.dtos.CreateOperationDto;
import kg.booster.rental_service.models.entities.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapperImpl implements ClientMapper {

    private final DocumentMapper documentMapper;

    public ClientMapperImpl(DocumentMapper documentMapper) {
        this.documentMapper = documentMapper;
    }

    @Override
    public Client createOperationDtoToClient(Client client, CreateOperationDto createOperationDto) {
        client.setAddress(createOperationDto.homeAddress());
        client.setFirstname(createOperationDto.firstName());
        client.setLastname(createOperationDto.lastName());
        client.setPatronymic(createOperationDto.patronymic());
        client.setDocument(documentMapper.createOperationDtoToDocument(createOperationDto));
        client.setInn(createOperationDto.inn());
        return client;
    }
}
