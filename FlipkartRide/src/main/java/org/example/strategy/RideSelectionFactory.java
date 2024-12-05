package org.example.strategy;

public class RideSelectionFactory {

    static MostVacantRideSelectionStrategy mostVacantRideSelectionStrategy = new MostVacantRideSelectionStrategy();

    static PreferredVehicleRideStrategy preferredVehicleRideStrategy = new PreferredVehicleRideStrategy();

    public static RideSelectionStrategy getStrategy(String strategy) {
        return switch (strategy) {
            case("Most Vacant") -> mostVacantRideSelectionStrategy;
            case ("Preferred Vehicle") -> preferredVehicleRideStrategy;
            default -> null;
        };
    }
}
