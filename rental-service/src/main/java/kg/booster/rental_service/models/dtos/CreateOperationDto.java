package kg.booster.rental_service.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public record CreateOperationDto(

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
        @JsonProperty("item_inventory_numbers")
        List<String> itemInventoryNumbers,
        @JsonProperty("rental_start_date")
        LocalDate rentalStartDate,
        @JsonProperty("rental_end_date")
        LocalDate rentalEndDate
) {
}
