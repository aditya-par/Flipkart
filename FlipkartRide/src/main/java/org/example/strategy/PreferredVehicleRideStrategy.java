package org.example.strategy;

import org.example.model.Ride;
import org.example.repository.UserRepository;

import java.util.List;

public class PreferredVehicleRideStrategy implements RideSelectionStrategy {

    UserRepository userRepository = new UserRepository();

    @Override
    public Ride selectRide(List<Ride> availableRides, String preferredVehicle) {

        return availableRides.stream()
                .filter(e -> e.getVehicle().getVehicleName().equals(preferredVehicle))
                .findFirst()
                .orElse(null);
    }
}
