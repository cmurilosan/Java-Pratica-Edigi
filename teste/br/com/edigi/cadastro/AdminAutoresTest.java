package br.com.edigi.cadastro;

import br.com.edigi.modelo.Autor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdminAutoresTest {

    @Test
    public void autoresDevemConstarNaLista() {

        AdminAutores lista = new AdminAutores();

        Autor cassio = new Autor("Cassio", "cassio@alura.com.br");
        Autor murilo = new Autor("Murilo", "murilo@alura.com.br");
        Autor santos = new Autor("Santos", "santos@alura.com.br");

        lista.insereAutor(cassio);
        lista.insereAutor(murilo);
        lista.insereAutor(santos);

        assertEquals(3, lista.getListaDeAutores().size());
    }

    @Test(expected = RuntimeException.class)
    public void autoresNaoPodemTerOMesmoEmail() {

        AdminAutores lista = new AdminAutores();

        Autor cassio = new Autor("Cassio", "cassio@alura.com.br");
        Autor murilo = new Autor("Murilo", "murilo@alura.com.br");
        Autor santos = new Autor("Santos", "murilo@alura.com.br");

        lista.insereAutor(cassio);
        lista.insereAutor(murilo);
        lista.insereAutor(santos);

        assertEquals(3, lista.getListaDeAutores().size());

    }

}