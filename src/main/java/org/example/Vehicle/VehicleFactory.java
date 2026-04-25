package org.example.Vehicle;

import org.example.Enums.VehicleType;

public class VehicleFactory {
    public static Vehicle  createVehicle(String licensePlate, String type) {
        if(type.equalsIgnoreCase("BIKE")) {
            System.out.println("Bike creating");
            return new BikeVehicle(licensePlate, type);
        } else if(type.equalsIgnoreCase("CAR")) {
            System.out.println("Car creating");
            return new CarVehicle(licensePlate, type);
        }
        return null; //For unsupported vehicle
    }
}