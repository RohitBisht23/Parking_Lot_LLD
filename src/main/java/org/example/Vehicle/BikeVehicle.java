package org.example.Vehicle;

import org.example.Enums.VehicleType;

public class BikeVehicle extends Vehicle{
    private static final double RATE = 5.0; //5.0 rupees per hour charges

    public BikeVehicle(String licensePlate, String type) {
        super(licensePlate, type);
    }

    @Override
    public double calculateFee(int hourStayed) {
        return RATE*hourStayed;
    }
}
