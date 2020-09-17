package br.com.edigi.main;

import br.com.edigi.cadastro.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteDelete {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        PreparedStatement statement = connection.prepareStatement("delete from Autor where id > ?");
        statement.setInt(1, 2);
        statement.execute();

        Integer linhasExcluidas = statement.getUpdateCount();

        System.out.println(linhasExcluidas + " foram excluidas");
    }

}
