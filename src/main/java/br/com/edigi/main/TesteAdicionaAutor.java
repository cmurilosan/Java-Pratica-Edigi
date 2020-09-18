package br.com.edigi.main;

import br.com.edigi.cadastro.AutorDao;
import br.com.edigi.modelo.Autor;

import java.sql.SQLException;

public class TesteAdicionaAutor {

    public static void main(String[] args) throws SQLException {

        Autor cassioSantos = new Autor("Cassio Santos", "cassio.santos@email.com");

        AutorDao dao = new AutorDao();

        dao.adiciona(cassioSantos);

        System.out.println("Gravado!");

    }

}
