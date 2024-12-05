package repository;

import model.Slot;

import java.util.ArrayList;
import java.util.List;

public class BaseSlotRepository implements SlotRepository {

    private static List<Slot> slotList = new ArrayList<>();

    public void addSlot(Slot slot) {
        slotList.add(slot);
    }

    public Slot getSlot(Long id) {
        for(Slot slot: slotList) {
            if (slot.getId().equals(id)) {
                return slot;
            }
        }
        return null;
    }

    public List<Slot> getSlots(List<Long> slotIdList) {
        List<Slot> slots = new ArrayList<>();

        for(Long id: slotIdList) {
            for(Slot slot: slotList) {
                if (slot.getId().equals(id)) {
                    slots.add(slot);
                }
            }
        }
        return slots;
    }
}
