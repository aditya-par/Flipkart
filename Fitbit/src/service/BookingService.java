package service;

import model.Booking;
import model.Slot;
import model.User;
import repository.BaseBookingRepository;
import repository.BookingRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BookingService {

    public static final int WAITING_LINK_CAPACITY = 2;
    BookingRepository bookingRepository = new BaseBookingRepository();
    NotificationService notificationService = new NotificationService();
    UserService userService = new UserService();

    SlotService slotService = new SlotService();

    //<-----Take lock on slotId ----->
    public Long bookSlot(String centerName, Long slotId, User user) {
        try {
            Booking booking = null;
            Slot slot = slotService.getSlot(slotId);
            if (slot.getId().equals(slotId)) {
                if (slot.getAvailableSeats()>0) {
                    booking = new Booking(user.getUserId(), centerName, slot.getWorkoutType(), slotId);
                    int availableSlots = slot.getAvailableSeats();
                    slot.setAvailableSeats(--availableSlots);
                    booking.setStatus("success");
                    bookingRepository.addBooking(booking);
                    return booking.getId();
                } else if (slot.getWailingList().size()<WAITING_LINK_CAPACITY){
                    slot.getWailingList().add(user.getUserId());
                }
                return null;
            }
        } finally {
            //<----Release lock---->
        }
        return null;
    }

    public List<Booking> showBookings(Long userId){
        List<Booking> bookingList = bookingRepository.getBookingList();
        return bookingList.stream()
                .filter(booking -> userId.equals(booking.getUserId()))
                .collect(Collectors.toList());
    }

    public void cancelBooking(Long userId, Long bookingId) {
        Booking booking = bookingRepository.getBooking(bookingId);
        booking.setStatus("canceled");
        notificationService.notifyUser(userId,  bookingId, "cancelled");
        //User user = userService.getUser(userId);
        Slot slot = slotService.getSlot(booking.getSlotId());
        int availableSeats = slot.getAvailableSeats();
        slot.setAvailableSeats(++availableSeats);
        Long waitUserId = slot.getWailingList().poll();
        User waitlistUser = userService.getUser(waitUserId);
        Long id = bookSlot(booking.getCenterName(), slot.getId(), waitlistUser);
        if (id!=null) {
             notificationService.notifyUser(waitUserId,  id, "success");
        }
    }

}
