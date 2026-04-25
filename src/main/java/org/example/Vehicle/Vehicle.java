package org.example.Vehicle;

import org.example.Enums.VehicleType;

public abstract class Vehicle {
    private String licensePlate;
    private String vehicleType;

    public Vehicle(String licensePlate, String type) {
        this.vehicleType = type;
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public abstract double calculateFee(int hourStayed);
}
