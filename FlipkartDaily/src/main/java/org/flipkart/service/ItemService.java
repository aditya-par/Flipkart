package org.flipkart.service;

import org.flipkart.model.Item;
import org.flipkart.repository.ItemRepository;

public class ItemService {
    ItemRepository itemRepository = new ItemRepository();

    public void addItem(String brand, String category, double price) {
        Item item = new Item(brand, category, price);
        // checking if item already exits
        Item fetchedItem = itemRepository.getItemByBrandAndCategory(item.getBrand(), item.getCategory());
        if (fetchedItem == null) {
            itemRepository.addItem(item);
            System.out.println("Item added : "+ item);
        } else
            System.out.println("Item already exists with brand and category");
    }

    public Item getItem(String brand, String category) {
        return itemRepository.getItemByBrandAndCategory(brand, category);
    }

    public Item getItemById(Long itemId) {
        return itemRepository.getItemById(itemId);
    }
}
