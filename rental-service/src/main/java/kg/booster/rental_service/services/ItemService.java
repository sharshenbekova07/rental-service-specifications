package kg.booster.rental_service.services;

import kg.booster.rental_service.models.entities.Item;

import java.util.List;

public interface ItemService {
    List<Item> findItemsByInventoryNumbers(List<String> inventoryNumbers);
}
