package br.com.edigi.cadastro;

import br.com.edigi.modelo.Categoria;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdminCategoriaTest {

    AdminCategoria lista = new AdminCategoria();

    @Test
    public void categoriasDevemConstarNaLista() {

        Categoria programacao = new Categoria("Programação");
        Categoria frontend = new Categoria("Front-End");

        lista.insereCategoria(programacao);
        lista.insereCategoria(frontend);

        assertEquals(2, lista.getListaDeCategoria().size());
        assertTrue("Programação", lista.getListaDeCategoria().contains(programacao));
        assertTrue("Front-End", lista.getListaDeCategoria().contains(frontend));
    }

    @Test(expected = RuntimeException.class)
    public void categoriasNaoPodemTerOMesmoNome() {

        Categoria programação = new Categoria("Programação");
        Categoria frontend = new Categoria("Front-End");
        Categoria mobile = new Categoria("Programação");

        lista.insereCategoria(programação);
        lista.insereCategoria(frontend);
        lista.insereCategoria(mobile);

    }

}