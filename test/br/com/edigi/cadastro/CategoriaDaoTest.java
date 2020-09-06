package br.com.edigi.cadastro;

import br.com.edigi.modelo.Categoria;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CategoriaDaoTest {

    private CategoriaDao listaDeCategoria;
    private Categoria programacao;
    private Categoria frontend;
    private Categoria mobile;

    @Before
    public void criaCategoria() {
        this.listaDeCategoria = new CategoriaDao();
        this.programacao = new Categoria("Programação");
        this.frontend = new Categoria("Front=End");
        this.mobile = new Categoria("Programação");
    }

    @Test
    public void categoriasDevemConstarNaLista() {

        listaDeCategoria.insereCategoria(programacao);
        listaDeCategoria.insereCategoria(frontend);

        assertTrue(String.valueOf(programacao), listaDeCategoria.getListaDeCategoria().contains(programacao));
        assertTrue(String.valueOf(frontend), listaDeCategoria.getListaDeCategoria().contains(frontend));
    }

    @Test(expected = RuntimeException.class)
    public void categoriasNaoPodemTerOMesmoNome() {

        listaDeCategoria.insereCategoria(programacao);
        listaDeCategoria.insereCategoria(frontend);
        listaDeCategoria.insereCategoria(mobile);

    }

}