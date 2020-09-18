package br.com.edigi.main;

import br.com.edigi.cadastro.ConnectionFactory;
import br.com.edigi.modelo.Autor;

import java.sql.*;

public class TesteInsercaoComParametros {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection connection = connectionFactory.recuperarConexao()) {

            connection.setAutoCommit(false);

            try (PreparedStatement statement =
                         connection.prepareStatement("insert into Autor(nome, email) values(?, ?)",
                                 Statement.RETURN_GENERATED_KEYS);
            ) {

                adicionaAutor(new Autor("Santos Cassio", "murilo@email.com.br"), statement);

                connection.commit();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Email já cadastrado!!!");
                connection.rollback();
            }
        }

    }
    private static void adicionaAutor(Autor autor, PreparedStatement statement) throws SQLException {
        statement.setString(1, autor.getNome());
        statement.setString(2, autor.getEmail());
        if (autor.getEmail().contains(statement.getResultSet().getString(autor.getEmail()))) {
            throw new RuntimeException("Não foi possível adicional Autor");

        }
        statement.execute();
        try(ResultSet rst = statement.getGeneratedKeys()) {
            while (rst.next()) {
                Integer id = rst.getInt(1);
                System.out.println("O ID criado foi: " + id);
            }
        }
    }
}
