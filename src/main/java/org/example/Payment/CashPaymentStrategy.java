package org.example.Payment;

public class CashPaymentStrategy implements PaymentStrategy{
    @Override
    public void processPayment(double amount) {
        //Logic for cash
        System.out.println("Payment received via cash method :"+amount);
    }
}
