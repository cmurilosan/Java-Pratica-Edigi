package br.com.edigi.cadastro;

import br.com.edigi.modelo.Autor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutorDao {

    private Connection connection;

    public AutorDao(Connection connection) throws SQLException {
        this.connection = connection;
    }

    Statement stm = connection.createStatement();
    ResultSet rst = stm.getResultSet();


    private static List<Autor> listaDeAutores = new ArrayList<>();

    public List<Autor> getListaDeAutores() {
        return Collections.unmodifiableList(listaDeAutores);
    }

    public void insereAutor(Autor autor) {
        if(AutorDao.listaDeAutores.contains(autor)) {
            throw new RuntimeException("Já existe um AUTOR cadastrado em nosso sistema com esse EMAIL");
        }
        AutorDao.listaDeAutores.add(autor);
    }

}
