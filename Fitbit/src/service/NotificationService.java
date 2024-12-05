package service;

public class NotificationService {

    public void notifyUser(Long userId, Long bookingId, String status) {
        System.out.println("User: "+userId+" "+ "BookingId " + bookingId
                + "status : " + status);

    }

}
