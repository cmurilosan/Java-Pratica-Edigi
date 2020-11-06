package br.com.edigi.main;

import br.com.edigi.cadastro.AutorDao;
import br.com.edigi.modelo.Autor;

import java.sql.SQLException;
import java.util.List;

public class TesteAdicionaAutor {

    public static void main(String[] args) throws SQLException {

        Autor murilo = new Autor("Murilo Santos", "murilo@email.com");

        AutorDao dao = new AutorDao();

        dao.adiciona(murilo);

        System.out.println("Gravado!");

        List<Autor> autores = dao.listaAutores();

        for(Autor autor : autores) {
            System.out.println("Nome: " + autor.getNome());
            System.out.println("Email: " + autor.getEmail());
        }
    }

}
