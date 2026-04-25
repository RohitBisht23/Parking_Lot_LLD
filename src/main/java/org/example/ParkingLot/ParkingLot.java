package org.example.ParkingLot;

import org.example.Enums.VehicleType;
import org.example.Vehicle.Vehicle;

import java.util.List;

public class ParkingLot {
    private List<ParkingFloor> floors;

    public ParkingLot(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public ParkingSpot findAvailableSpot(String vehicleType) {
        for(ParkingFloor floor : floors) {
            ParkingSpot spot =  floor.findAvailableSpot(vehicleType);
            if (spot != null) {
                return spot;
            }
        }
        System.out.println("No spot is available.");
        return null;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        ParkingSpot spot1 = findAvailableSpot(vehicle.getVehicleType());
        if(spot1 != null) {
            spot1.parkVehicle(vehicle);
            System.out.println("Vehicle parked in spot :"+spot1.getSpotNumber());
            return spot1;
        }
        System.out.println("No parking spot is available for  :"+vehicle.getVehicleType());
        return null;
    }

    public void vacateSpot(ParkingSpot spot, Vehicle vehicle) {
        if(spot != null && spot.isOccupied() && spot.getVehicle().equals(vehicle)) {
            spot.vacate();
            System.out.println(vehicle.getVehicleType()+" vacated for spot :"+spot.getSpotNumber());
        } else {
            System.out.println("Invalid operation! Either the spot is already vacant or vehicle does not match");
        }
    }

    public ParkingSpot getSpotByNumber(int spotNumber) {
        for(ParkingFloor floor : floors) {
            for(ParkingSpot spot : floor.getParkingSpots()) {
                if(spot.getSpotNumber() == spotNumber) {
                    return spot;
                }
            }
        }
        return null;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }
}
