package br.com.edigi.cadastro;

import br.com.edigi.modelo.Autor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdminAutoresTest {

    private AdminAutores lista;
    private Autor cassio;
    private Autor murilo;
    private Autor santos;

    @Before
    public void criaAdminAutoresEAutor() {
        this.lista = new AdminAutores();
        this.cassio = new Autor("Cássio", "cassio@alura.com.br");
        this.murilo = new Autor("Murilo", "murilo@alura.com.br");
        this.santos = new Autor("Santos", "murilo@alura.com.br");
    }

    @Test
    public void autoresDevemConstarNaLista() {

        lista.insereAutor(cassio);
        lista.insereAutor(murilo);

        assertEquals(2, lista.getListaDeAutores().size());
        assertTrue("Cássio", lista.getListaDeAutores().contains(cassio));
        assertTrue("cassio@alura.com.br", lista.getListaDeAutores().contains(cassio));
        assertTrue("Murilo", lista.getListaDeAutores().contains(murilo));
        assertTrue("murilo@alura.com.br", lista.getListaDeAutores().contains(murilo));
    }

    @Test(expected = RuntimeException.class)
    public void autoresNaoPodemTerOMesmoEmail() {

        lista.insereAutor(cassio);
        lista.insereAutor(murilo);
        lista.insereAutor(santos);

    }

}