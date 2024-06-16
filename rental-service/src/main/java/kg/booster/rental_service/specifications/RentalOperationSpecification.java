package kg.booster.rental_service.specifications;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import kg.booster.rental_service.models.entities.Client;
import kg.booster.rental_service.models.entities.Item;
import kg.booster.rental_service.models.entities.RentalOperation;
import org.hibernate.boot.beanvalidation.GroupsPerOperation;
import org.springframework.data.jpa.domain.Specification;

public class RentalOperationSpecification {

    public static Specification<RentalOperation> byLastName(String lastName){
        return (root, query, criteriaBuilder) -> {
            if (lastName == null || lastName.isBlank())
                return criteriaBuilder.conjunction();
            Join<RentalOperation, Client> clientJoin = root.join("document", JoinType.INNER);

            return criteriaBuilder.like(clientJoin.get("last_name"), "%" + lastName + "%");
        };
    }

    public static Specification<RentalOperation> byItemInventory(String inventoryNumber){
        return (root, query, criteriaBuilder) -> {
            if (inventoryNumber == null || inventoryNumber.isBlank())
                return criteriaBuilder.conjunction();
            Join<RentalOperation, Item> itemJoin = root.join("items", JoinType.INNER);
            return criteriaBuilder.equal(itemJoin.get("inventory_number"), inventoryNumber);
        };
    }
}
