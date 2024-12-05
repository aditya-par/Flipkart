package org.example;

import org.example.model.Ride;
import org.example.service.RideProcessor;
import org.example.service.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        RideProcessor rideProcessor = new RideProcessor();

        userService.addUser("Rohan", "M", 26);
        userService.addVehicle("Rohan", "Swift", "KA-01-12345");
        userService.addUser("Shashank", "M", 29);
        userService.addVehicle("Shashank", "Baleno", "TS-05-62395");
        userService.addUser("Nandini", "F", 29);
        userService.addUser("Shipra", "F", 27);
        userService.addVehicle("Shipra", "Polo", "KA-05-41491");
        userService.addVehicle("Shipra", "Activa", "KA-12-12332");
        userService.addUser("Gaurav", "M", 29);
        userService.addUser("Rahul", "M", 35);
        userService.addVehicle("Rahul", "XUV", " KA-05-1234");

        rideProcessor.offerRide("Rohan", "Hyderabad", 1, "Swift", "KA-01-12345", "Bangalore");
        rideProcessor.offerRide("Shipra", "Bangalore", 1, "Activa", "KA-12-12332", "Mysore");
        rideProcessor.offerRide("Shipra", "Bangalore", 2, "Polo", "KA-05-41491", "Mysore");
        rideProcessor.offerRide("Shashank", "Hyderabad", 2, "Baleno", "TS-05-62395", "Bangalore");

        rideProcessor.offerRide("Shipra", "Hyderabad", 1, "Swift", "KA-01-12345", "Bangalore");

        rideProcessor.selectRide("Nandini", "Bangalore", "Mysore", 1, "Most Vacant", null);

        rideProcessor.endRide(2L);

        userService.printRideStats();
    }

}