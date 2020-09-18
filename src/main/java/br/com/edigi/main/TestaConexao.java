package br.com.edigi.main;

import br.com.edigi.cadastro.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        connection.close();
    }
}
