package org.example.ParkingLot;

import org.example.Enums.SpotType;
import org.example.Enums.VehicleType;
import org.example.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private List<ParkingSpot> spots;
    private int floorNumber;   //To track which floor this is

    public ParkingFloor(int floorNumber, int numberOFCars, int numberOFBikes) {
        this.floorNumber = floorNumber;
        spots = new ArrayList<>(); //initialize the floor parking spot list

        //Add spots for car
        for(int i=0; i<numberOFCars; i++) {
            this.spots.add(new CarParkingSpot(i+1)); // Add car spots (using carParkingSpot)
        }

        //Add spots for bike
        for(int i=0; i<numberOFBikes; i++) {
            this.spots.add(new BikeParkingSpot(i+1)); // Add bike spots (Using BikeParkingSpot)
        }
    }


    //Method to find the available spots based on the vehicle type
    public ParkingSpot findAvailableSpot(String vehicleType) {
        for(ParkingSpot spot : spots) {
            if(!spot.isOccupied() && spot.getSpotType().equalsIgnoreCase(vehicleType)) {
                return spot;
            }
        }
        return null;
    }

    //Method to return all the parking spot int this floor
    public List<ParkingSpot> getParkingSpots() {
        return spots;
    }

}
