package org.example.strategy;

import org.example.model.Ride;

import java.util.Comparator;
import java.util.List;

public class MostVacantRideSelectionStrategy implements RideSelectionStrategy {
    @Override
    public Ride selectRide(List<Ride> availableRides, String preferredVehicle) {
        return availableRides.stream()
                .max(Comparator.comparingInt(Ride::getAvailableSeats))
                .orElse(null);
    }
}
