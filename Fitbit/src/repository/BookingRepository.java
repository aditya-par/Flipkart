package repository;

import model.Booking;

import java.util.List;

public interface BookingRepository {

    void addBooking(Booking booking);

    public Booking getBooking(Long id);

    public List<Booking> getBookingList();
}
