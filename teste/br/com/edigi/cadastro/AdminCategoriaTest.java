package br.com.edigi.cadastro;

import br.com.edigi.modelo.Categoria;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdminCategoriaTest {

    private AdminCategoria lista;
    private Categoria programacao;
    private Categoria frontend;
    private Categoria mobile;

    @Before
    public void criaCategoria() {
        this.lista = new AdminCategoria();
        this.programacao = new Categoria("Programação");
        this.frontend = new Categoria("Front=End");
        this.mobile = new Categoria("Programação");
    }

    @Test
    public void categoriasDevemConstarNaLista() {

        lista.insereCategoria(programacao);
        lista.insereCategoria(frontend);

        assertEquals(2, lista.getListaDeCategoria().size());
        assertTrue("Programação", lista.getListaDeCategoria().contains(programacao));
        assertTrue("Front-End", lista.getListaDeCategoria().contains(frontend));
    }

    @Test(expected = RuntimeException.class)
    public void categoriasNaoPodemTerOMesmoNome() {

        lista.insereCategoria(programacao);
        lista.insereCategoria(frontend);
        lista.insereCategoria(mobile);

    }

}