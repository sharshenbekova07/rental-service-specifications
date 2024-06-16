package kg.booster.rental_service.mappers.impl;

import kg.booster.rental_service.mappers.DocumentMapper;
import kg.booster.rental_service.models.dtos.CreateOperationDto;
import kg.booster.rental_service.models.entities.Document;
import org.springframework.stereotype.Component;

@Component
public class DocumentMapperImpl implements DocumentMapper {


    @Override
    public Document createOperationDtoToDocument(CreateOperationDto createOperationDto) {

        Document document = new Document();
        document.setNumber(createOperationDto.passportNumber());
        document.setSeries(createOperationDto.passportSeries());
        return document;
    }
}
