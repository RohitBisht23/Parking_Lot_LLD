package org.example.Gates;

import org.example.Enums.VehicleType;
import org.example.ParkingLot.ParkingLot;
import org.example.ParkingLot.ParkingSpot;
import org.example.Payment.PaymentService;
import org.example.Vehicle.Vehicle;

public class ExitGate {
    private ParkingLot parkingLot;
    private PaymentService paymentService;

    public ExitGate(ParkingLot parkingLot, PaymentService service) {
        this.parkingLot = parkingLot;
        this.paymentService = service;
    }

    public void processExit(int spotNumber, int hourStayed) {
        ParkingSpot spot = parkingLot.getSpotByNumber(spotNumber);
        System.out.println("Spot Id : "+spot.toString());
        System.out.println("Spi -=--"+spot.isOccupied());
        if(spot == null || spot.isOccupied()) {
            System.out.println("Invalid or vacant spot!");
            return;
        }

        //Get the vehicle in the spot
        Vehicle vehicle = spot.getVehicle();
        if(vehicle == null) {
            System.out.println("No vehicle found in the spot.");
            return;
        }

        double fee = vehicle.calculateFee(hourStayed);

        //Delegate payment process for paymentService
        paymentService.processPayment(fee);

        //Vacant spot after payment
        parkingLot.vacateSpot(spot, vehicle);
        System.out.println("Spot vacated successfully.");
    }
}
