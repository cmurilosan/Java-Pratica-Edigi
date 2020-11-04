package br.com.edigi.cadastro;

import br.com.edigi.modelo.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LivroDao {

    private final Connection connection = ConnectionFactory.getConnection();

    public void adiciona(Livro livro) {

        String sql = "insert into Livro (titulo, idAutor, idCategoria, resumo, sumario, paginas, isbn, edicao, preco)" +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1,livro.getTitulo());
            statement.setLong(2, livro.getAutor().getId());
            statement.setLong(3, livro.getCategoria().getId());
            statement.setString(4,livro.getResumo());
            statement.setString(5,livro.getSumario());
            statement.setInt(6, livro.getNumeroPaginas());
            statement.setString(7, livro.getIsbn());
            statement.setString(8, String.valueOf(livro.getEdicao()));
            statement.setString(9, String.valueOf(livro.getPreco()));

            statement.execute();
            statement.close();
        } catch ( SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void listar() throws SQLException {

        String sql = "select * from Livro";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String titulo = resultSet.getString("titulo");
            String resumo = resultSet.getString("resumo");
            String sumario = resultSet.getString("sumario");
            Integer paginas = resultSet.getInt("paginas");
            String isbn = resultSet.getString("isbn");
            Integer edicao = resultSet.getInt("edicao");
            Double preco = resultSet.getDouble("preco");
            System.out.println("ID: " + id);
            System.out.println("Título: " + titulo);
            System.out.println("Resumo: " + resumo);
            System.out.println("Sumário: " + sumario);
            System.out.println("Páginas: " + paginas);
            System.out.println("ISBN: " + isbn);
            System.out.println("Edição: " + edicao);
            System.out.println("Preço: " + preco);
            System.out.println("------------------------------");
        }

        connection.close();
    }
}