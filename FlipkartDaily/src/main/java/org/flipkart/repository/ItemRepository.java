package org.flipkart.repository;

import org.flipkart.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemRepository {

    static List<Item> itemList = new ArrayList<>();

    public void addItem(Item item) {
        itemList.add(item);
    }

    public Item getItemByBrandAndCategory(String brand, String category) {
        return itemList.stream()
                .filter(e -> brand.equals(e.getBrand()) && category.equals(e.getCategory())).findFirst().orElse(null);
    }

    public Item getItemById(Long itemId) {
        return itemList.stream().filter(e -> itemId.equals(e.getItemId())).findFirst().get();
    }
}
