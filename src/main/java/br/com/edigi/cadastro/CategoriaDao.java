package br.com.edigi.cadastro;

import br.com.edigi.modelo.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaDao {

    private final Connection connection = ConnectionFactory.getConnection();

    public void adiciona(Categoria categoria) throws SQLException {

        String sql = "insert into Categoria (Nome) values(?)";

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

    public void getLista() throws SQLException {

        String sql = "select * from Categoria";

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Integer id = resultSet.getInt("IdCategoria");
            String nome = resultSet.getString("Nome");
            System.out.println("ID: " + id);
            System.out.println("Nome: " + nome);
        }
    }
}
