package kg.booster.rental_service.services.impl;

import kg.booster.rental_service.exeptions.IncorrectItemSize;
import kg.booster.rental_service.models.entities.Item;
import kg.booster.rental_service.repositories.ItemRepo;
import kg.booster.rental_service.services.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepo itemRepo;

    public ItemServiceImpl(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @Override
    public List<Item> findItemsByInventoryNumbers(List<String> inventoryNumbers) {
        List<Item> items = itemRepo.findAllByInventoryNumberIn(inventoryNumbers);
        if (items.size() != inventoryNumbers.size())
            throw new IncorrectItemSize();
        return items;
    }
}
