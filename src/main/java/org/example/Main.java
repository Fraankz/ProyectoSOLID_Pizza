package org.example;

public class Main {
    public static void main(String[] args) {
        // 1. Inicializar y conectar a la base de datos
        DataBaseManager db = new DataBaseManager();
        db.connect();

        // 2. Crear el autenticador con la conexión de db
        Authenticator auth = new Authenticator(db.getConnection());

        // 3. Autenticar usuario (debe existir en la tabla users)
        String username = "admin";     // 👉 Cambia esto por un usuario real de tu base de datos
        String password = "1234";      // 👉 Asegúrate de que coincida

        int userId = auth.authenticate(username, password);

        if (userId != -1) {
            System.out.println("✅ Usuario autenticado con ID: " + userId);

            // 4. Crear y usar el gestor de pedidos
            PaymentProcessor payment = new PaymentProcessor(); // puedes simularlo
            OrderManager orderManager = new OrderManager(db, payment);

            // 5. Crear un pedido
            String descripcion = "Pizza familiar con extra de queso";
            double precio = 17.99;
            orderManager.crearPedido(userId, descripcion, precio);

            // 6. Eliminar pedido (ejemplo: borrar el pedido con ID 1)
            orderManager.eliminarPedido(1); // Solo para testear; usa un ID real si es necesario

        } else {
            System.out.println("❌ Usuario o contraseña incorrectos.");
        }
    }
}

