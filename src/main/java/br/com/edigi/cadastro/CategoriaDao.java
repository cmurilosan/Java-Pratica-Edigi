package br.com.edigi.cadastro;

import br.com.edigi.modelo.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {

    private final Connection connection = ConnectionFactory.getConnection();

    public void adiciona(Categoria categoria) {

        String sql = "insert into Categoria (Nome) values(?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1,categoria.getNome());

            statement.execute();
            statement.close();
        } catch ( SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Categoria> listaCategorias () {

        String sql = "select * from Categoria";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            List<Categoria> categorias = new ArrayList<>();

            while (resultSet.next()) {
                Categoria categoria = new Categoria(resultSet.getString("Nome"));

                categorias.add(categoria);
            }
            resultSet.close();
            statement.close();
            return categorias;
        } catch (SQLException erro) {
            throw new IllegalArgumentException("Não foi possível visualizar a lista de Categorias");
        }
    }

    public Categoria buscaCategoriaPorNome(String programação) {
        //busca uma categoria
        return null;
    }
}
