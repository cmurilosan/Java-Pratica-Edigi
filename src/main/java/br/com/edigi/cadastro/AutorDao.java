package br.com.edigi.cadastro;

import br.com.edigi.modelo.Autor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AutorDao {

    ConnectionFactory connectionFactory = new ConnectionFactory();
    Connection connection = connectionFactory.getConnection();

    public void adiciona(Autor autor) throws SQLException {
        String sql = "insert into Autor" + "(nome, email)" + "values(?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, autor.getNome());
            statement.setString(2, autor.getEmail());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Já temos um Autor cadastrado com este EMAIL!!!");
            throw e;
        }
    }
}
