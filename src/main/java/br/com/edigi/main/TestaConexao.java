package br.com.edigi.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost/edigi?useTimezone=true&serverTimezone=UTC", "root", "groove10");

        connection.close();
    }
}
