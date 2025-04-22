package org.example;

public class OrderManager {
    private final DataBaseManager dbManager;
    private final PaymentProcessor paymentProcessor;

    public OrderManager(DataBaseManager dbManager, PaymentProcessor paymentProcessor) {
        this.dbManager = dbManager;
        this.paymentProcessor = paymentProcessor;
    }


    public void crearPedido(int userId, String descripcion, double precio) {
        System.out.println("🧾 Creando pedido para usuario ID: " + userId);

        boolean pagado = paymentProcessor.processPayment(String.valueOf(userId), precio);

        if (pagado) {
            dbManager.createOrder(userId, descripcion, precio); // ✅ llamado al método JDBC real
        } else {
            System.out.println("❌ El pago ha fallado.");
        }
    }

    public void eliminarPedido(int pedidoId) {
        dbManager.deleteOrder(pedidoId); // ✅ llamado al método JDBC real
    }
}
