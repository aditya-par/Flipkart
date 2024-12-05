package org.example.strategy;

import org.example.model.Ride;

import java.util.List;

public interface RideSelectionStrategy {
    Ride selectRide(List<Ride> availableRides, String preferredVehicle);
}
