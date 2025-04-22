package org.example;

public class PaymentProcessor {
    public boolean processPayment(String userId, double amount) {
        System.out.println("Procesando pago de " + amount + " € para usuario " + userId);
        return true; // Simula éxito
    }
}
