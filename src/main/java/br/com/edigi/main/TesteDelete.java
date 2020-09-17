package br.com.edigi.main;

import br.com.edigi.cadastro.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteDelete {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        Statement statement = connection.createStatement();
        statement.execute("delete from Autor where id > 2");

        Integer linhasExcluidas = statement.getUpdateCount();

        System.out.println(linhasExcluidas + " foram excluidas");
    }

}
