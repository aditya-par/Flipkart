package repository;

import model.Booking;

import java.util.ArrayList;
import java.util.List;

public class BaseBookingRepository implements BookingRepository{

    private static List<Booking> bookingList = new ArrayList<>();

    public void addBooking(Booking booking) {
        bookingList.add(booking);
    }

    public List<Booking> getBookingList(){
        return bookingList;
    }

    public Booking getBooking(Long id){
        for(Booking booking: bookingList) {
            if (booking.getId().equals(id)) {
                return booking;
            }
        }
        return null;
    }




}
