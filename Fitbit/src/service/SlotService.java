package service;

import model.Slot;
import repository.BaseSlotRepository;
import repository.SlotRepository;

import java.time.LocalDateTime;
import java.util.List;

public class SlotService {

    SlotRepository slotRepository = new BaseSlotRepository();

    public Long addSlot(LocalDateTime startTime, LocalDateTime endTime, int totalSeats, String workout) {
        Slot slot = new Slot(startTime, endTime, totalSeats, workout);
        slotRepository.addSlot(slot);
        return slot.getId();
    }

    public List<Slot> getSlots(List<Long> slotIdList) {
        return slotRepository.getSlots(slotIdList);
    }

    public Slot getSlot(Long slotId) {
        return slotRepository.getSlot(slotId);
    }
}
