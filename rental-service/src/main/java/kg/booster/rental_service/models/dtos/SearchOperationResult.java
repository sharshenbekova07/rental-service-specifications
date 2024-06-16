package kg.booster.rental_service.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import kg.booster.rental_service.models.enums.Status;

import java.time.LocalDate;
import java.util.List;

public record SearchOperationResult(

        @JsonProperty("rental_id")
        Long id,
        @JsonProperty("last_name")
        String lastName,
        @JsonProperty("first_name")
        String firstName,
        String patronymic,
        String inn,
        @JsonProperty("passport_series")
        String passportSeries,
        @JsonProperty("passport_number")
        String passportNumber,
        @JsonProperty("home_address")
        String homeAddress,
        @JsonProperty("item_inventory_number")
        String itemInventoryNumber,
        @JsonProperty("rental_start_date")
        LocalDate rentalStartDate,
        @JsonProperty("rental_end_date")
        LocalDate rentalEndDate,
        Status status
) {
}
