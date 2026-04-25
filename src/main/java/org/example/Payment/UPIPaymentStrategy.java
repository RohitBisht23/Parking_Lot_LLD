package org.example.Payment;

public class UPIPaymentStrategy implements PaymentStrategy{
    @Override
    public void processPayment(double amount) {
        //UPI payment logic
        System.out.println(("Payment received via UPI:"+amount));
    }
}
