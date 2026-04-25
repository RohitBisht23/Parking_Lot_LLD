package org.example.Payment;

import java.util.Scanner;

public class PaymentService {

    private Scanner scanner;

    public PaymentService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void processPayment(double fee) {
        choosePaymentStrategy(fee);
    }

    public void choosePaymentStrategy(double fee) {
        System.out.print("Your total fee is :"+fee);
        System.out.print("Select payment strategy.");
        System.out.println("1. CASE");
        System.out.println("2. UPI");
        System.out.println("3. CREDIT CARD");

        int choice = scanner.nextInt();

        Payment payment;
        switch (choice) {
            case 1 :
                payment = new Payment(fee, new CashPaymentStrategy());
                break;

            case 2 :
                payment = new Payment(fee, new UPIPaymentStrategy());
                break;

            case 3 :
                payment = new Payment(fee, new CreditCardPaymentStrategy());
                break;

            default:
                System.out.print("Invalid choice : Default to Cash payment method");
                payment = new Payment(fee, new CashPaymentStrategy());
                break;
        }

        payment.processPayment();
    }
}
