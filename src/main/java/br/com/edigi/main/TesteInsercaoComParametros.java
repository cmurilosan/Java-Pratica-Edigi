package br.com.edigi.main;

import br.com.edigi.cadastro.ConnectionFactory;
import br.com.edigi.modelo.Autor;

import java.sql.*;

public class TesteInsercaoComParametros {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        PreparedStatement statement = connection.prepareStatement("insert into Autor(nome, email) values(?, ?)",
                Statement.RETURN_GENERATED_KEYS);

        adicionaAutor(new Autor("Santos Cassio", "murilo@email.com.br"), statement);
    }

    private static void adicionaAutor(Autor autor, PreparedStatement statement) throws SQLException {
        statement.setString(1, autor.getNome());
        statement.setString(2, autor.getEmail());
        statement.execute();
        ResultSet rst = statement.getGeneratedKeys();
        while (rst.next()) {
            Integer id = rst.getInt(1);
            System.out.println("O ID criado foi: " + id);
        }
        rst.close();
    }
}
