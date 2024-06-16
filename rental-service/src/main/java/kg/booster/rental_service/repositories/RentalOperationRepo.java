package kg.booster.rental_service.repositories;

import kg.booster.rental_service.models.entities.RentalOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalOperationRepo extends JpaRepository<RentalOperation, Long>, JpaSpecificationExecutor<RentalOperation> {
}
