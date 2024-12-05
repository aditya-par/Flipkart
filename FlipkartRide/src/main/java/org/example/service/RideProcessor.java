package org.example.service;

import org.example.model.Ride;
import org.example.model.User;
import org.example.model.Vehicle;
import org.example.repository.RideRepository;
import org.example.repository.UserRepository;
import org.example.strategy.RideSelectionFactory;
import org.example.strategy.RideSelectionStrategy;

import java.util.List;
import java.util.Optional;

public class RideProcessor {

    UserRepository userRepository = new UserRepository();

    RideRepository rideRepository = new RideRepository();

    public void offerRide(String name, String origin, int seats, String vehicleName, String vehicleNumber, String destination) {
        User user = userRepository.getUserByName(name);
        List<Vehicle> vehicleList = user.getVehicles();
        Optional<Vehicle> vehicleRegistered = vehicleList.stream()
                .filter(e -> vehicleNumber.equals(e.getVehicleNumber()))
                .findFirst();
        if (vehicleRegistered.isPresent()) {
            Ride ride = new Ride(user.getUserId(), origin, vehicleRegistered.get(), destination, seats);
            rideRepository.saveRide(ride);
            System.out.println("Ride offered : "+ ride);

            user.setOfferedRides(user.getOfferedRides() + 1);
            userRepository.updateUser(user);

        } else
            System.out.println("Vehicle is not added for user");
    }

    public void selectRide(String name, String origin, String destination, int availableSeats, String strategy, String preferredModel) {
        List<Ride> activeRides = rideRepository.getActiveRides();
        List<Ride> availableRides = activeRides.stream()
                .filter(ride -> ride.getOrigin().equals(origin) && ride.getDestination().equals(destination)
                && ride.getAvailableSeats() <= availableSeats && ride.getStatus().equals("VACANT")).toList();

        RideSelectionStrategy rideSelectionStrategy = RideSelectionFactory.getStrategy(strategy);
        if (rideSelectionStrategy != null) {
            Ride selectedRide = rideSelectionStrategy.selectRide(availableRides, preferredModel);
            if (selectedRide == null)
                System.out.println("No available rides right now");
            else {
                User fetchedUser = userRepository.getUserByName(name);
                fetchedUser.setTakenRides(fetchedUser.getTakenRides() + 1);
                userRepository.updateUser(fetchedUser);

                // mark ride in progress
                rideRepository.updateStatus(selectedRide.getRideId());
                System.out.println("Ride selected : "+ selectedRide);
            }
        }
    }

    public void endRide(long rideId) {
        List<Ride> rides = rideRepository.getActiveRides();
        for (Ride ride : rides) {
            if (ride.getRideId().equals(rideId)) {
                ride.setActive(false);
                ride.setStatus("COMPLETED");
                System.out.println("Ride ended : "+ ride);
            }
        }
    }
}
