package br.com.edigi.main;

import br.com.edigi.cadastro.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteAutorDao {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        Statement stm = connection.createStatement();
        stm.execute("select id, nome, email from Autor");
        ResultSet rst = stm.getResultSet();
        while (rst.next()) {
            Integer id = rst.getInt("id");
            String nome = rst.getString("nome");
            String email = rst.getNString("email");
            System.out.println(id);
            System.out.println(nome);
            System.out.println(email);
        }
    }
}
