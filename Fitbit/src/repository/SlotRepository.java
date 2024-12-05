package repository;

import model.Slot;

import java.util.ArrayList;
import java.util.List;

public interface SlotRepository {

    void addSlot(Slot slot);

    Slot getSlot(Long id);

    List<Slot> getSlots(List<Long> slotIdList);

}
