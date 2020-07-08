package br.com.edigi.cadastro;

import br.com.edigi.modelo.Autor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdminAutoresTest {

    @Test
    public void autoresDevemConstarNaLista() {

        AdminAutores lista = new AdminAutores();

        Autor cassio = new Autor("Cassio", "cassio@alura.com.br");
        Autor murilo = new Autor("Murilo", "murilo@alura.com.br");

        lista.insereAutor(cassio);
        lista.insereAutor(murilo);

        assertEquals(2, lista.getListaDeAutores().size());
        assertTrue("Cassio", lista.getListaDeAutores().contains(cassio));
        assertTrue("cassio@alura.com.br", lista.getListaDeAutores().contains(cassio));
        assertTrue("Murilo", lista.getListaDeAutores().contains(murilo));
        assertTrue("murilo@alura.com.br", lista.getListaDeAutores().contains(murilo));
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

    }

}