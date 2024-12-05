package org.example.model;

public class Vehicle {
    private static Long autoId=0L;
    Long vehicleId;
    String vehicleName;
    String vehicleNumber;
    Boolean rideOffered = false;

    public Vehicle(String vehicleName, String vehicleNumber) {
        autoId++;
        this.vehicleId=autoId;
        this.vehicleNumber = vehicleNumber;
        this.vehicleName = vehicleName;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Boolean getRideOffered() {
        return rideOffered;
    }

    public void setRideOffered(Boolean rideOffered) {
        this.rideOffered = rideOffered;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vehicleName='" + vehicleName + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", rideOffered=" + rideOffered +
                '}';
    }
}
