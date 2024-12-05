package org.flipkart;


import org.flipkart.service.InventoryService;
import org.flipkart.service.ItemService;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ItemService itemService = new ItemService();
        InventoryService inventoryService = new InventoryService();

        itemService.addItem("Amul", "Milk", 100);
        itemService.addItem("Amul", "Curd", 50);
        itemService.addItem("Nestle", "Milk", 60);
        itemService.addItem("Nestle", "Curd", 90);

        inventoryService.addInventory("Amul", "Milk", 10);
        inventoryService.addInventory("Nestle", "Milk", 5);
        inventoryService.addInventory("Nestle", "Curd", 10);
        inventoryService.addInventory("Amul", "Milk", 10);
        inventoryService.addInventory("Amul", "Curd", 10);
        inventoryService.addInventory("Amul", "Icecream", 10);

        inventoryService.getInventoryStatus();

        inventoryService.searchItems(Arrays.asList("123"), null, null, null, null);
        inventoryService.searchItems(null, List.of("Milk"), null, null, null);
        inventoryService.searchItems(null, List.of("Milk"), null,  "price", "desc");
        inventoryService.searchItems(null, null, List.of(20.0, 100.0),  "price", "desc");
        inventoryService.searchItems(Arrays.asList("Amul"), null, null,  "itemQty", null);

        inventoryService.searchItems(Arrays.asList("Amul", "Nestle"), null, null,  "price", null);
    }
}