package br.com.edigi.modelo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LivroTest {

    private Autor cassio;
    private Categoria programacao;

    @Before
    public void criaAutor() {
        this.cassio = new Autor("Cassio", "cassio@teste.com.br");
        this.programacao = new Categoria("Programação");
    }

    @Test
    public void livroDeveConterTituloResumoSumarioNumeroDePaginasIsbnAutorCategoriaEdicaoEPreco() {

        Livro livro = new Livro(
                "Java",
                "Este livro aborda Orientação a Objetos",
                "Sumário deve ser inserido",
                300,
                "978-12-34567-89-0",
                cassio,
                programacao,
                1,
                70.00);

        assertEquals("Java", livro.getTitulo());
        assertEquals("Este livro aborda Orientação a Objetos", livro.getResumo());
        assertEquals("Sumário deve ser inserido", livro.getSumario());
        assertEquals(300, livro.getNumeroPaginas());
        assertEquals("978-12-34567-89-0", livro.getIsbn());
        assertEquals(cassio, livro.getAutor());
        assertEquals(programacao, livro.getCategoria());
        assertEquals(1, livro.getEdicao());
        assertEquals(70.00, livro.getPreco(), 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void tituloDoLivroNaoDeveSerVazio() {

        Livro livro = new Livro(
                "",
                "Este livro aborda Orientação a Objetos",
                "Sumário deve ser inserido",
                300,
                "978-12-34567-89-0",
                cassio,
                programacao,
                1,
                70.00);

    }

    @Test(expected = IllegalArgumentException.class)
    public void resumoDoLivroNaoDeveSerVazio() {

        Livro livro = new Livro(
                "Java",
                "",
                "Sumário deve ser inserido",
                300,
                "978-12-34567-89-0",
                cassio,
                programacao,
                1,
                70.00);

    }

    @Test(expected = IllegalArgumentException.class)
    public void resumoDoLivroNaoPodeTerMaisDeQuinhentosCaracteres() {

        Livro livro = new Livro(
                "Java",
                "Lorem ipsum dolor sit amet consectetur adipisicing elit. " +
                        "Quis consequuntur laboriosam at, animi dolorem omnis vero aperiam officia quod hic minima eveniet obcaecati, " +
                        "aliquam unde ea adipisci veniam nemo tempore! " +
                        "Lorem ipsum dolor sit amet consectetur adipisicing elit. " +
                        "Quis consequuntur laboriosam at, animi dolorem omnis vero aperiam officia quod hic minima eveniet obcaecati, " +
                        "aliquam unde ea adipisci veniam nemo tempore!" +
                        "Lorem ipsum dolor sit amet consectetur adipisicing elit. " +
                        "Quis consequuntur laboriosam at, animi dolorem omnis vero aperiam officia quod hic minima eveniet obcaecati, " +
                        "aliquam unde ea adipisci veniam nemo tempore!",
                "Sumário deve ser inserido",
                300,
                "978-12-34567-89-0",
                cassio,
                programacao,
                1,
                70.00);

    }

    @Test(expected = IllegalArgumentException.class)
    public void sumarioDoLivroNaoPodeSerVazio() {

        Livro livro = new Livro(
                "Java",
                "Este livro aborda Orientação a Objetos",
                "",
                300,
                "978-12-34567-89-0",
                cassio,
                programacao,
                1,
                70.00);

    }

    @Test(expected = IllegalArgumentException.class)
    public void numeroDePaginasDoLivroNaoDeveSerMenorQueUm() {

        Livro livro = new Livro(
                "Java",
                "Este livro aborda Orientação a Objetos",
                "Sumário deve ser inserido",
                0,
                "978-12-34567-89-0",
                cassio,
                programacao,
                1,
                70.00);

    }

    @Test (expected = IllegalArgumentException.class)
    public void isbnDoLivroNaoPodeSerVazio() {

        Livro livro = new Livro(
                "Java",
                "Este livro aborda Orientação a Objetos",
                "Sumário deve ser inserido",
                300,
                "",
                cassio,
                programacao,
                1,
                70.00);

    }

    @Test (expected = IllegalArgumentException.class)
    public void isbnDoLivroTeraQueComecarCom987() {

        Livro livro = new Livro(
                "Java",
                "Este livro aborda Orientação a Objetos",
                "Sumário deve ser inserido",
                300,
                "123-12-34567-89-0",
                cassio,
                programacao,
                1,
                70.00);

    }

    @Test (expected = IllegalArgumentException.class)
    public void isbnDoLivroDeveTerFormatoPadrao() {

        Livro livro = new Livro(
                "Java",
                "Este livro aborda Orientação a Objetos",
                "Sumário deve ser inserido",
                300,
                "97812-34567-890",
                cassio,
                programacao,
                1,
                70.00);

    }

    @Test (expected = IllegalArgumentException.class)
    public void edicaoDoLivroNaoDeveSerMenorQueUm() {

        Livro livro = new Livro(
                "Java",
                "Este livro aborda Orientação a Objetos",
                "Sumário deve ser inserido",
                300,
                "978-12-34567-89-0",
                cassio,
                programacao,
                0,
                70.00);

    }

    @Test (expected = IllegalArgumentException.class)
    public void precoDoLivroNaoDeveSerComNumerosNegativos() {

        Livro livro = new Livro(
                "Java",
                "Este livro aborda Orientação a Objetos",
                "Sumário deve ser inserido",
                300,
                "978-12-34567-89-0",
                cassio,
                programacao,
                1,
                -01.00);

    }

}