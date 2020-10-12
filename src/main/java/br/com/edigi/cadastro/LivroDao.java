package br.com.edigi.cadastro;

import br.com.edigi.modelo.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LivroDao {

    ConnectionFactory connectionFactory = new ConnectionFactory();
    Connection connection = connectionFactory.getConnection();

    public void adiciona(Livro livro) throws SQLException {

        String sql = "insert into Livro (Titulo, IdAutor, IdCategoria, Resumo, Sumario, Paginas, Isbn, Edicao, Preco)" +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1,livro.getTitulo());
            statement.setString(2,livro.getResumo());
            statement.setString(3,livro.getSumario());
            statement.setInt(4, livro.getNumeroPaginas());
            statement.setString(5, livro.getIsbn());
            statement.setString(6, String.valueOf(livro.getEdicao()));
            statement.setString(7, String.valueOf(livro.getPreco()));

            statement.execute();
            statement.close();
            connection.close();
        } catch ( SQLException e) {
            System.out.println("Livro já cadastrado. Confirme o TÍTULO e ISBN");
            throw e;
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