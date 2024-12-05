import model.Location;
import service.BookingService;
import service.CenterService;
import service.UserService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        UserService userService = new UserService();
        CenterService centerService = new CenterService();
        BookingService bookingService = new BookingService();

        userService.registerUser("Vivek", 13, "bangalore");
        userService.registerUser("Pavan", 20, "bangalore");

        centerService.addCenter("bellandur", "bangalore", Arrays.asList("sunday", "monday"), 6);
        centerService.addCenter("lalbagh", "bangalore", Arrays.asList("sunday", "monday"), 6);

        centerService.addWorkout("bellandur", "weights");
        centerService.addWorkout("bellandur", "cardio");
        centerService.addWorkout("bellandur", "yoga");

        centerService.addSlot("bellandur", "yoga", LocalDateTime.of(2024, 10, 17, 18, 00), LocalDateTime.of(2024, 10, 17, 19, 00), 1);
        centerService.addSlot("bellandur", "Gym", LocalDateTime.of(2024, 10, 17, 7, 00), LocalDateTime.of(2024, 10, 17, 8, 00), 1);

        System.out.println(centerService.getAvailableSlots("bellandur", LocalDate.of(2024, 10, 17)));

        centerService.bookSlot(1L, "bellandur", 1L);

        System.out.println(centerService.getAvailableSlots("bellandur", LocalDate.of(2024, 10, 17)));

        System.out.println(bookingService.showBookings(1L));

        centerService.bookSlot(2L, "bellandur", 1L);

        System.out.println(centerService.getAvailableSlots("bellandur", LocalDate.of(2024, 10, 17)));

        bookingService.cancelBooking(1L, 1L);

        System.out.println(bookingService.showBookings(1L));
        System.out.println(bookingService.showBookings(2L));

        System.out.println(centerService.getAvailableSlots("bellandur", LocalDate.of(2024, 10, 17)));
    }
}