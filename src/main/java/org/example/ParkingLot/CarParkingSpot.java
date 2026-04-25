package org.example.ParkingLot;

import org.example.Enums.SpotType;
import org.example.Vehicle.Vehicle;

public class CarParkingSpot  extends  ParkingSpot{

    public CarParkingSpot(int spotNumber) {
        super(spotNumber, "CAR");
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType().equalsIgnoreCase("CAR");

    }
}
