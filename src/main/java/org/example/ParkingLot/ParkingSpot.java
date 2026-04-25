package org.example.ParkingLot;

import org.example.Enums.SpotType;
import org.example.Vehicle.Vehicle;

public abstract class ParkingSpot {
    private int spotNumber;
    private boolean isOccupied;
    private Vehicle vehicle;
    private String spotType;

    public ParkingSpot(int spotNumber, String spotType) {
        this.spotNumber = spotNumber;
        isOccupied = false;
        this.spotType = spotType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public abstract  boolean canParkVehicle(Vehicle vehicle);

    public void parkVehicle(Vehicle vehicle) {
        if(isOccupied) {
            throw new IllegalStateException("Spot is already occupied.");
        }

        if(!canParkVehicle(vehicle)) {
            throw new IllegalStateException("Spot is not suitable for vehicle :"+vehicle.getVehicleType());
        }
        this.vehicle = vehicle;
        this.isOccupied = true;
        System.out.println("Your vehicle is successfully parked");
    }

    public void vacate() {
        if(!isOccupied) {
            throw new IllegalStateException("Spot is already vacant");
        }
        this.vehicle = null;
        this.isOccupied = false;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public String getSpotType() {
        return spotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    //To easily read parking spot details
    @Override
    public String toString() {
        return "ParkingSpot {" +
                "Spot Number : "+spotNumber+
                ", isOccupied :"+isOccupied+
                ", Vehicle :"+(vehicle != null ? vehicle.getLicensePlate() : "Non")+
                "}";
    }


}
