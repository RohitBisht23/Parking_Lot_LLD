package org.example;

import org.example.Gates.EntranceGate;
import org.example.Gates.ExitGate;
import org.example.ParkingLot.ParkingFloor;
import org.example.ParkingLot.ParkingLot;
import org.example.Payment.PaymentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Initialize the parking lot with floor numbers
        ParkingFloor floor = new ParkingFloor(1, 2, 2);
        ArrayList<ParkingFloor> floors = new ArrayList<>();
        floors.add(floor);

        ParkingLot parkingLot = new ParkingLot(floors);

        //Initialize a payment service
        PaymentService paymentService = new PaymentService(sc);

        EntranceGate entranceGate = new EntranceGate(parkingLot);
        ExitGate exitGate = new ExitGate(parkingLot, paymentService);

        System.out.println("=============================================");
        System.out.println("   Welcome to the Parking lot System !");
        System.out.println("=============================================");

        boolean exist = false;

        while (!exist) {
            showMenu();


            int choice = getUserChoice(sc);
            switch (choice) {
                case 1:
                    parkVehicle(entranceGate);
                    break;

                case 2:
                    vacateSpot(sc, exitGate);
                    break;

                case 3:
                    exist = true;
                    System.out.println("Existing from system");
                    break;

                default:
                    System.out.println("Invalid option please choice option once again.");
                    break;
            }
        }
    }

    private static void showMenu() {
        System.out.println("**********************************************************");
        System.out.println("Please choose an option from below");
        System.out.println("1. Park vehicle");
        System.out.println("2. Vacate a vehicle spot");
        System.out.println("3. Exist the system");
        System.out.println("**********************************************************");
    }

    private static int getUserChoice(Scanner sc) {
        return sc.nextInt();
    }

    private static void parkVehicle(EntranceGate entranceGate) {
        entranceGate.processEntrance();
    }

    private static void vacateSpot(Scanner sc, ExitGate exitGate) {
        System.out.print("Enter the spot number to vacant: ");
        int spotNumber = sc.nextInt();

        System.out.print("Enter the number of hour stayed :");
        int hourStayed = sc.nextInt();

        exitGate.processExit(spotNumber, hourStayed);
    }

}