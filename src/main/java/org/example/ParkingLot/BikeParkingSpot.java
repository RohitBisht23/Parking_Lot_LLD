package org.example.ParkingLot;

import org.example.Enums.SpotType;
import org.example.Vehicle.Vehicle;

public class BikeParkingSpot extends ParkingSpot{

    public BikeParkingSpot(int spotNumber) {
        super(spotNumber, "BIKE");
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType().equalsIgnoreCase("BIKE");
    }


}
