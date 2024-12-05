package org.flipkart.util;

import org.flipkart.dto.InventoryDTO;
import org.flipkart.model.Item;

import java.util.Comparator;

public class SearchComparator {

    public static Comparator<InventoryDTO> byPrice() {
        return Comparator.comparing(InventoryDTO::getPrice);
    }

    public static Comparator<InventoryDTO> byCategory() {
        return Comparator.comparing(InventoryDTO::getCategory);
    }

    public static Comparator<InventoryDTO> byBrand() {
        return Comparator.comparing(InventoryDTO::getBrand);
    }

    public static Comparator<InventoryDTO> byItemQuantity() {
        return Comparator.comparing(InventoryDTO::getQuantity);
    }
}
