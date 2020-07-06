package br.com.edigi.cadastro;

import br.com.edigi.modelo.Categoria;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdminCategoriaTest {

    AdminCategoria lista = new AdminCategoria();

    @Test
    public void categoriasDevemConstarNaLista() {

        Categoria programacao = new Categoria("Programação");
        Categoria frontend = new Categoria("Front-End");
        Categoria mobile = new Categoria("mobile");

        lista.insereCategoria(programacao);
        lista.insereCategoria(frontend);
        lista.insereCategoria(mobile);

        assertEquals(3, lista.getListaDeCategoria().size());
    }

    @Test(expected = RuntimeException.class)
    public void categoriasNaoPodemTerOMesmoNome() {

        Categoria programação = new Categoria("Programação");
        Categoria frontend = new Categoria("Front-End");
        Categoria mobile = new Categoria("Programação");

        lista.insereCategoria(programação);
        lista.insereCategoria(frontend);
        lista.insereCategoria(mobile);

        assertEquals(3, lista.getListaDeCategoria().size());

    }

}