package br.com.edigi.cadastro;

import br.com.edigi.modelo.Autor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorDao {

    private final Connection connection = ConnectionFactory.getConnection();

    public void adiciona(Autor autor) {
        String sql = "insert into autor (nome, email) values(?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, autor.getNome());
            statement.setString(2, autor.getEmail());

            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Autor> listaAutores() {

        String sql = "select * from autor";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            List<Autor> autores = new ArrayList<>();

            while (resultSet.next()) {

                Autor autor = new Autor(
                        resultSet.getString("nome"),
                        resultSet.getNString("email"));

                autores.add(autor);

            }
            resultSet.close();
            statement.close();
            return autores;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Autor buscaAutorPeloEmail(String email) {

        String sql = "select * from autor where email = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Autor autor = new Autor(

                        resultSet.getString("nome"),
                        resultSet.getString("email"));
                autor.setId(resultSet.getLong("id_autor"));
                return autor;
            }

            return null;

        } catch(SQLException e){
                throw new RuntimeException(e);
        }

    }
}

