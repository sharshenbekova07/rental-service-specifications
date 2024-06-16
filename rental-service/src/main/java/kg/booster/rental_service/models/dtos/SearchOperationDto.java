package kg.booster.rental_service.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import kg.booster.rental_service.models.enums.Status;

import java.time.LocalDate;

public record SearchOperationDto(
        @JsonProperty("last_name")
        String lastName,
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("middle_name")
        String patronymic,
        @JsonProperty("item_inventory_number")
        String itemInventoryNumber,
        @JsonProperty("rental_start_date")
        LocalDate rentalStartDate,
        Status status

) {
}
