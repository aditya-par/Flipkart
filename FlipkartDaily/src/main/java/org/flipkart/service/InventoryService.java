package org.flipkart.service;

import org.flipkart.dto.InventoryDTO;
import org.flipkart.model.Inventory;
import org.flipkart.model.Item;
import org.flipkart.repository.InventoryRepository;
import org.flipkart.util.SearchComparator;

import java.util.Comparator;
import java.util.List;

public class InventoryService {

    ItemService itemService = new ItemService();

    InventoryRepository inventoryRepository = new InventoryRepository();

    public void addInventory(String brand, String category, int quantity) {
        Item fetchedItem = itemService.getItem(brand, category);
        if (fetchedItem != null) {
            Inventory inventory = new Inventory(fetchedItem.getItemId(), quantity);
            inventoryRepository.addInventory(inventory);
            System.out.println("Inventory added successfully :" + inventory);
        } else
            System.out.println("Item doesn't exist");
    }

    public void getInventoryStatus() {
        List<Inventory> inventoryList = inventoryRepository.getAll();
        for (Inventory inventory : inventoryList) {
            Item item = itemService.getItemById(inventory.getItemId());
            System.out.println(item.getBrand() + "->" + item.getCategory() + "->" + inventory.getQuantity());
        }
    }

    public void searchItems(List<String> brand, List<String> category, List<Double> price, String orderBy, String direction) {
        // IMPROVEMENT : search by brand and criteria directly instead of all
        List<Inventory> inventoryList = inventoryRepository.getAll();
        List<InventoryDTO> inventoryDTOList = inventoryList.stream().map(e -> {
            Item item = itemService.getItemById(e.getItemId());
            return new InventoryDTO(item.getBrand(), item.getCategory(), item.getPrice(), e.getQuantity());
        }).toList();

        List<InventoryDTO> filteredItems = new java.util.ArrayList<>(inventoryDTOList.stream()
                .filter(e -> brand == null || brand.contains(e.getBrand()))
                .filter(e -> category == null || category.contains(e.getCategory()))
                .filter(e -> price == null || e.getPrice() >= price.getFirst() && e.getPrice() <= price.getLast())
                .toList());
        getSortedList(filteredItems, orderBy, direction);
    }

    // sorting logic
    private void getSortedList(List<InventoryDTO> filteredItems, String orderBy, String direction) {
        Comparator<InventoryDTO> comparator;
        if (orderBy == null || orderBy.equalsIgnoreCase("price")) {
            comparator = SearchComparator.byPrice();
        } else {
            comparator = switch (orderBy.toLowerCase()) {
                case "category" -> SearchComparator.byCategory();
                case "brand" -> SearchComparator.byBrand();
                case "itemqty" -> SearchComparator.byItemQuantity();
                default -> {
                    System.out.println("Invalid orderBy parameter: " + orderBy);
                    yield null;
                }
            };
        }

        if (comparator != null) {
            if ("desc".equalsIgnoreCase(direction)) {
                comparator = comparator.reversed();
            }
            filteredItems.sort(comparator);
            System.out.println(filteredItems);
        }
    }
}
