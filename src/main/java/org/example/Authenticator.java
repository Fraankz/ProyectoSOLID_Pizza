package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authenticator {
    private final Connection connection;

    public Authenticator(Connection connection) {
        this.connection = connection;
    }

    public int authenticate(String username, String password) {
        String sql = "SELECT id FROM users WHERE username = ? AND password = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id"); // Devuelve el ID si existe
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1; // Fallo de autenticación
    }
}
