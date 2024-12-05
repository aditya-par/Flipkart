package strategy;

import model.Slot;

import java.time.LocalDateTime;

public class SlotAvailabilityStrategy {

    public SlotAvailabilityStrategy() {
    }

    public boolean isSlotAvailable(Slot slot, LocalDateTime rangeStart, LocalDateTime rangeEnd) {
        return slot.getStartTime().isAfter(rangeStart) && slot.getEndTime().isBefore(rangeEnd);
    }
}
