package org.example.Vehicle;

import org.example.Enums.VehicleType;

public class CarVehicle extends Vehicle{

    private static final double RATE = 10.0; //10.0 rupees per hour charges

    public CarVehicle(String licensePlate, String type) {
        super(licensePlate, type);
    }

    @Override
    public double calculateFee(int hourStayed) {
        return RATE*hourStayed;
    }
}
