package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseManager {
    private Connection connection;

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Fuerza carga del driver

            String url = "jdbc:mysql://caboose.proxy.rlwy.net:44898/railway?sslMode=REQUIRED";
            String user = "root";
            String password = "PSNOrnwgygMYpCPJYwlEQYnRLZGhduUT"; // Sustituye esto por tu contraseña real

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("✅ ¡Conexión exitosa a Railway!");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("❌ Error al conectar con Railway:");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    // ✅ Método para crear un pedido
    public void createOrder(int userId, String description, double amount) {
        String sql = "INSERT INTO orders (user_id, description, amount) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setString(2, description);
            stmt.setDouble(3, amount);
            stmt.executeUpdate();
            System.out.println("🟢 Pedido creado correctamente en la base de datos.");
        } catch (SQLException e) {
            System.out.println("❌ Error al crear el pedido:");
            e.printStackTrace();
        }
    }

    // ✅ Método para eliminar un pedido
    public void deleteOrder(int orderId) {
        String sql = "DELETE FROM orders WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            int result = stmt.executeUpdate();
            if (result > 0) {
                System.out.println("🗑️ Pedido con ID " + orderId + " eliminado.");
            } else {
                System.out.println("⚠️ No se encontró pedido con ID " + orderId);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar el pedido:");
            e.printStackTrace();
        }
    }
}
