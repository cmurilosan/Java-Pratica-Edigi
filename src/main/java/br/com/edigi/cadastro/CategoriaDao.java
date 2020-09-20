package br.com.edigi.cadastro;

import br.com.edigi.modelo.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoriaDao {

    ConnectionFactory connectionFactory = new ConnectionFactory();
    Connection connection = connectionFactory.getConnection();

    public void adiciona(Categoria categoria) throws SQLException {

        String sql = "insert into Categoria" + "(nome)" + "values(?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1,categoria.getNome());

            statement.execute();
            statement.close();
        } catch ( SQLException e) {
            System.out.println("Já possuímos essa CATEGORIA em nosso cadastro");
            throw e;
        }
    }
}
