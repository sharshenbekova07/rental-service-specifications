package kg.booster.rental_service.models.dtos;

public record CreateOperationSuccessResponse(
        Long rentalId,
        String message
) {
}
