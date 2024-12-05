package org.flipkart.model;

public class Inventory{
    private static Long autoId=0L;
    private Long inventoryId;
    private Long itemId;
    private int quantity;

    public Inventory(Long itemId, int quantity) {
        autoId++;
        this.inventoryId = autoId;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", itemId=" + itemId +
                ", quantity=" + quantity +
                '}';
    }
}
