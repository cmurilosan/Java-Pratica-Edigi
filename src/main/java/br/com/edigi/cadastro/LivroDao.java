package br.com.edigi.cadastro;

import br.com.edigi.modelo.Autor;
import br.com.edigi.modelo.Categoria;
import br.com.edigi.modelo.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LivroDao {

    ConnectionFactory connectionFactory = new ConnectionFactory();
    Connection connection = connectionFactory.getConnection();

    public void adiciona(Livro livro) throws SQLException {

        String sql = "insert into Livro" + "(titulo, resumo, sumario, paginas, isbn, " +
                "edicao, preco)" + "values(?, ?, ?, ?, ?, ?, ?)";

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
        } catch ( SQLException e) {
            System.out.println("Livro já cadastrado. Confirme o TÍTULO e ISBN");
            throw e;
        }
    }

    public void getListaLivros() throws SQLException {

        String sql = "select * from Livro";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String titulo = resultSet.getString("titulo");
            String resumo = resultSet.getString("resumo");
            String sumario = resultSet.getString("sumario");
            String paginas = resultSet.getString("paginas");
            String isbn = resultSet.getString("isbn");
            Integer edicao = resultSet.getInt("edicao");
            Double preco = resultSet.getDouble("preco");
            System.out.println(id);
            System.out.println(titulo);
            System.out.println(resumo);
            System.out.println(sumario);
            System.out.println(paginas);
            System.out.println(isbn);
            System.out.println(edicao);
            System.out.println(preco);
        }
    }

//    public void getListaLivros() throws SQLException {
//
//        String sql = "select * from Livro";
//
//        PreparedStatement statement = connection.prepareStatement(sql);
//        ResultSet resultSet = statement.executeQuery();
//
//        while (resultSet.next()) {
//            Integer id = resultSet.getInt("id");
//            String titulo = resultSet.getString("titulo");
//            String resumo = resultSet.getNString("resumo");
//            String sumario = resultSet.getNString("sumario");
//            int paginas = resultSet.getInt("pagina");
//            String isbn = resultSet.getNString("isbn");
//            String autor = resultSet.getObject("nome", Autor.class);
//            System.out.println(id);
//            System.out.println(nome);
//            System.out.println(email);
//        }
//    }

//    private static List<Livro> listaDeLivros = new ArrayList<>();

//    public void insereLivro(Livro livro) {
//        if(LivroDao.listaDeLivros.contains(livro)){
//            throw new RuntimeException("Livro já cadastrado. Confirme o TÍTULO ou o ISBN");
//        }
//        LivroDao.listaDeLivros.add(livro);
//    }
//
//    public List<Livro> buscaPorTitulo(String palavra) {
//        if (palavra.length() < 2){
//            throw new IllegalArgumentException(palavra + " é insuficiente para a pesquisa");
//        }
//
//        return listaDeLivros.stream().filter(livro -> contemNoTitulo(palavra, livro))
//                .collect(Collectors.toList());
//
//    }
//
//    private boolean contemNoTitulo(String palavra, Livro livro) {
//        String tituloMaiusculo = livro.getTitulo().toUpperCase();
//        String palavraMaiusculo = palavra.toUpperCase();
//
//        return tituloMaiusculo.contains(palavraMaiusculo);
//    }
//
//    public boolean contem(Livro livro) {
//        return listaDeLivros.contains(livro);
//    }
//
//    public List<Livro> getListaDeLivros() {
//        return Collections.unmodifiableList(listaDeLivros);
//    }
}