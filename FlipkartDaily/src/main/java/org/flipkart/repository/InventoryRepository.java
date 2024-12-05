package org.flipkart.repository;

import org.flipkart.model.Inventory;

import java.util.ArrayList;
import java.util.List;

public class InventoryRepository {

    static List<Inventory> inventoryList = new ArrayList<>();

    public void addInventory(Inventory inventory) {
        inventoryList.stream()
                .filter(e -> inventory.getItemId().equals(e.getItemId()))
                .findFirst()
                .ifPresentOrElse(
                        e -> e.setQuantity(e.getQuantity() + inventory.getQuantity()),
                        () -> inventoryList.add(inventory)
                );
    }

    public List<Inventory> getAll() {
        return inventoryList;
    }
}
