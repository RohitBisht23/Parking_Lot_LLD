package org.example.Gates;

import org.example.Enums.VehicleType;
import org.example.ParkingLot.ParkingLot;
import org.example.ParkingLot.ParkingSpot;
import org.example.Vehicle.Vehicle;
import org.example.Vehicle.VehicleFactory;

import java.util.Scanner;

public class EntranceGate {
    private ParkingLot parkingLot;

    public EntranceGate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void processEntrance() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the vehicle license plate :");
        String license = sc.next();

        System.out.println("Enter the Vehicle Type : (Bike/CAR)");
        String vehicleType = sc.next();
        System.out.println("Selected Vehicle :"+vehicleType);

        Vehicle vehicle = VehicleFactory.createVehicle(license, vehicleType);

        if(vehicle == null) {
            System.out.println("Invalid vehicle type. Only CAR or BIKE is available.");
        }

        //Try to park vehicle
        ParkingSpot spot = parkingLot.parkVehicle(vehicle);
        if(spot != null) {
            System.out.println("Vehicle is parked successfully.");
        } else {
            System.out.println("No available spot for vehicle type :"+vehicle.getVehicleType());
        }
    }
}
