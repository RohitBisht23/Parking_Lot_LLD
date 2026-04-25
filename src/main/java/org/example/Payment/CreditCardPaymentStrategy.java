package org.example.Payment;

public class CreditCardPaymentStrategy implements PaymentStrategy{
    @Override
    public void processPayment(double amount) {
        //Credit cart payment logic
        System.out.println("Payment received via credit cart :"+amount);
    }
}
