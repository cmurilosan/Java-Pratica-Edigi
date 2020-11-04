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
        String sql = "insert into Autor (Nome, Email) values(?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, autor.getNome());
            statement.setString(2, autor.getEmail());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Autor> listaAutores() {

        String sql = "select * from Autor";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            List<Autor> autores = new ArrayList<>();

            while (resultSet.next()) {

                Autor autor = new Autor(
                        resultSet.getString("Nome"),
                        resultSet.getNString("Email"));

                autores.add(autor);

            }
            resultSet.close();
            statement.close();
            return autores;
        } catch (SQLException erro) {
            throw new IllegalArgumentException("Não foi possível visualizar a lista de autores");
        }
    }

    public Autor buscaAutorPeloEmail(String email) {
        //busca um autor - select * from autor where email = 'dnejnejnje';
        return null;
    }
}
