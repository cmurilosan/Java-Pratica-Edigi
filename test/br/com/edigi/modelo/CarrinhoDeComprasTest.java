package br.com.edigi.modelo;

import br.com.edigi.cadastro.LivroDao;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CarrinhoDeComprasTest {

    private CarrinhoDeCompras carrinhoDeCompras;
    private LivroDao livroDao;
    private Categoria programacao;
    private Autor cassio;
    private Autor murilo;

    @Before
    public void criaCarrinhoDeComprasAutoresECategoria() {
        this.carrinhoDeCompras = new CarrinhoDeCompras();
        this.livroDao = new LivroDao();
        this.cassio = new Autor("Cássio", "cassio@teste.com.br");
        this.murilo = new Autor("Murilo", "murilo@teste.com.br");
        this.programacao = new Categoria("Programação");
    }

    @Test
    public void livroAdicionadoNoCarrinhoDeveConterNoCatalogo() {

        Livro maven = new Livro("Maven",
                "Este livro aborda Orientação a Objetos",
                "Sumário deve ser inserido",
                300,
                "978-12-65478-78-0",
                cassio,
                programacao,
                1,
                70.00);

        livroDao.insereLivro(maven);
        carrinhoDeCompras.add(maven);

        assertTrue(String.valueOf(maven), carrinhoDeCompras.getLivros().containsKey(maven));
    }

    @Test(expected = RuntimeException.class)
    public void livroNaoEhAdicionadoNoCarrinhoQuandoEstaForaDoCatalogo() {

        Livro poo = new Livro("Orientação a Objetos",
                "Este livro aborda Orientação a Objetos",
                "Sumário deve ser inserido",
                300,
                "978-12-96325-89-0",
                cassio,
                programacao,
                1,
                70.00);

        carrinhoDeCompras.add(poo);
    }

    @Test
    public void carrinhoDeComprasGeraOValorTotal() {

        Livro web = new Livro("Web",
                "Este livro aborda Orientação a Objetos",
                "Sumário deve ser inserido",
                300,
                "978-12-32145-89-0",
                cassio,
                programacao,
                1,
                70.00);

        Livro solid = new Livro("Solid",
                "Este livro aborda a linguagem Python",
                "Sumário deve ser inserido",
                300,
                "978-12-74125-89-0",
                murilo,
                programacao,
                1,
                70.00);

        livroDao.insereLivro(web);
        livroDao.insereLivro(solid);

        carrinhoDeCompras.add(web);    // 70.00
        carrinhoDeCompras.add(solid);  // 70.00

        assertEquals(140.00,carrinhoDeCompras.getValorTotal(), 0.00001);
    }

    @Test
    public void carrinhoDeComprarDeveFinalizarACompra() {

        Livro jsp = new Livro("JSP",
                "Este livro aborda Orientação a Objetos",
                "Sumário deve ser inserido",
                300,
                "978-12-58963-89-0",
                cassio,
                programacao,
                1,
                70.00);

        Livro servlet = new Livro("Servlet",
                "Este livro aborda a linguagem Python",
                "Sumário deve ser inserido",
                300,
                "978-12-25874-89-0",
                murilo,
                programacao,
                1,
                70.00);

        livroDao.insereLivro(jsp);
        livroDao.insereLivro(servlet);

        carrinhoDeCompras.add(jsp);    // 70.00
        carrinhoDeCompras.add(servlet);  // 70.00

        carrinhoDeCompras.finalizaCompra();

    }

}