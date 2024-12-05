package org.example.repository;

import org.example.model.Ride;

import java.util.ArrayList;
import java.util.List;

public class RideRepository {

    List<Ride> activeRides = new ArrayList<>();

    public void saveRide(Ride ride) {
        if (isRideAlreadyOffered(ride.getRideId()))
            System.out.println("Ride has already been offered for this vehicle.");
        else
            activeRides.add(ride);
    }

    public boolean isRideAlreadyOffered(Long rideId) {
        return activeRides.stream()
                .anyMatch(e -> e.getRideId().equals(rideId));
    }

    public List<Ride> getActiveRides() {
        return activeRides;
    }

    public void updateStatus(Long rideId) {
        for(Ride ride: activeRides) {
            if (ride.getRideId().equals(rideId)) {
                ride.setStatus("IN PROGRESS");
                ride.setActive(true);
            }
        }
    }
}
