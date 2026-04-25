package org.example.Payment;

public class Payment {
    private double amount;
    private PaymentStrategy paymentStrategy; //Payment strategy interface

    public Payment(double amount, PaymentStrategy paymentStrategy) {
        this.amount = amount;
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment() {
        if(amount > 0) {
            paymentStrategy.processPayment(amount); //Delegating to strategy
        } else {
            System.out.println("Invalid payment amount.");
        }
    }
}
