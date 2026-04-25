package org.example.ParkingLot;

import org.example.Vehicle.Vehicle;

import java.time.LocalDateTime;

public class Ticket {
    private ParkingSpot parkingSpot;
    private Vehicle vehicle;
    private LocalDateTime startTime;

    Ticket(ParkingSpot parkingSpot, Vehicle vehicle) {
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        startTime = LocalDateTime.now();
    }

}
