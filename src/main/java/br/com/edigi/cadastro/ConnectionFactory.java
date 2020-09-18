package br.com.edigi.cadastro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection
                    ("jdbc:mysql://localhost/edigi?useTimezone=true&serverTimezone=UTC",
                            "root", "groove10");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
