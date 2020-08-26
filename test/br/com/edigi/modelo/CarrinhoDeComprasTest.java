package br.com.edigi.modelo;

import br.com.edigi.cadastro.AdminLivro;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CarrinhoDeComprasTest {

    private CarrinhoDeCompras carrinhoDeCompras;
    private AdminLivro adminLivro;
    private Categoria programacao;
    private Autor cassio;
    private Autor murilo;

    @Before
    public void criaCarrinhoDeComprasAutoresECategoria() {
        this.carrinhoDeCompras = new CarrinhoDeCompras();
        this.adminLivro = new AdminLivro();
        this.cassio = new Autor("Cássio", "cassio@teste.com.br");
        this.murilo = new Autor("Murilo", "murilo@teste.com.br");
        this.programacao = new Categoria("Programação");
    }

    @Test
    public void livroAdicionadoNoCarrinhoDeveConterNoCatalogo() {

        Livro java = new Livro("Java",
                "Este livro aborda Orientação a Objetos",
                "Sumário deve ser inserido",
                300,
                "978-12-34567-78-0",
                cassio,
                programacao,
                1,
                70.00);

        adminLivro.insereLivro(java);
        carrinhoDeCompras.add(java);

        assertTrue(String.valueOf(java), carrinhoDeCompras.getLivros().containsKey(java));

    }

    @Test(expected = RuntimeException.class)
    public void livroNaoEhAdicionadoNoCarrinhoQuandoEstaForaDoCatalogo() {

        Livro java = new Livro("Java",
                "Este livro aborda Orientação a Objetos",
                "Sumário deve ser inserido",
                300,
                "978-12-96325-89-0",
                cassio,
                programacao,
                1,
                70.00);

        carrinhoDeCompras.add(java);
    }

    @Test
    public void carrinhoDeComprasGeraOValorTotal() {

        Livro java = new Livro("Java",
                "Este livro aborda Orientação a Objetos",
                "Sumário deve ser inserido",
                300,
                "978-12-87412-89-0",
                cassio,
                programacao,
                1,
                70.00);

        Livro python = new Livro("Python",
                "Este livro aborda a linguagem Python",
                "Sumário deve ser inserido",
                300,
                "978-12-74125-89-0",
                murilo,
                programacao,
                1,
                70.00);

        adminLivro.insereLivro(java);
        adminLivro.insereLivro(python);

        carrinhoDeCompras.add(java);    // 70.00
        carrinhoDeCompras.add(python);  // 70.00

        assertEquals(140.00,carrinhoDeCompras.getValorTotal(), 0.00001);
    }

    @Test
    public void carrinhoDeComprarDeveFinalizarACompra() {

        Livro java = new Livro("Java",
                "Este livro aborda Orientação a Objetos",
                "Sumário deve ser inserido",
                300,
                "978-12-58963-89-0",
                cassio,
                programacao,
                1,
                70.00);

        Livro python = new Livro("Python",
                "Este livro aborda a linguagem Python",
                "Sumário deve ser inserido",
                300,
                "978-12-25874-89-0",
                murilo,
                programacao,
                1,
                70.00);

        adminLivro.insereLivro(java);
        adminLivro.insereLivro(python);

        carrinhoDeCompras.add(java);    // 70.00
        carrinhoDeCompras.add(python);  // 70.00

        carrinhoDeCompras.finalizaCompra();

    }

}