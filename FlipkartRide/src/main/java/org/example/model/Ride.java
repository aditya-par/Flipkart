package org.example.model;

public class Ride {
    private static Long autoId=0L;
    Long rideId;
    Long driverId;
    String origin;
    String destination;
    Vehicle vehicle;
    int availableSeats;
    boolean isActive = false;
    String status;

    public Ride(Long userId, String origin, Vehicle vehicle, String destination, Integer availableSeats) {
        autoId++;
        this.rideId = autoId;
        this.driverId = userId;
        this.origin = origin;
        this.vehicle = vehicle;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.status = "VACANT";
    }

    public Long getRideId() {
        return rideId;
    }

    public void setRideId(Long rideId) {
        this.rideId = rideId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "rideId=" + rideId +
                ", driverId=" + driverId +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", vehicle=" + vehicle +
                ", availableSeats=" + availableSeats +
                ", isActive=" + isActive +
                ", status='" + status + '\'' +
                '}';
    }
}
