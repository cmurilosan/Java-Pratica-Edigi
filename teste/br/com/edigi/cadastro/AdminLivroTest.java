package br.com.edigi.cadastro;

import br.com.edigi.modelo.Autor;
import br.com.edigi.modelo.Categoria;
import br.com.edigi.modelo.Livro;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AdminLivroTest {

    private AdminLivro lista;
    private Categoria programacao;
    private Autor cassio;
    private Autor murilo;

    @Before
    public void criaAdminLivroCategoriaEAutor() {
        this.lista = new AdminLivro();
        this.programacao = new Categoria("Programação");
        this.cassio = new Autor("Cássio", "cassio@teste.com.br");
        this.murilo = new Autor("Murilo", "murilo@teste.com.br");
    }

    @Test
    public void livroDeveConstarNaLista() {

        Livro java = new Livro(
                "Java",
                "Este livro aborda Orientação a Objetos",
                "Sumário deve ser inserido",
                300,
                "978-14-78523-69-0",
                cassio,
                programacao,
                1,
                70.00);

        lista.insereLivro(java);

        assertTrue("Java", lista.getListaDeLivros().contains(java));
        assertTrue("Este livro aborda Orientação a Objetos", lista.getListaDeLivros().contains(java));
        assertTrue("Sumário deve ser inserido", lista.getListaDeLivros().contains(java));
        assertTrue(String.valueOf(300), lista.getListaDeLivros().contains(java));
        assertTrue("978-12-34567-89-0", lista.getListaDeLivros().contains(java));
        assertTrue(String.valueOf(cassio), lista.getListaDeLivros().contains(java));
        assertTrue(String.valueOf(programacao), lista.getListaDeLivros().contains(java));
        assertTrue(String.valueOf(1), lista.getListaDeLivros().contains(java));
        assertTrue(String.valueOf(70.00), lista.getListaDeLivros().contains(java));
    }

    @Test(expected = RuntimeException.class)
    public void livrosNaoPodemTerOMesmoNumeroIsbn() {

        Livro java = new Livro(
                "Java",
                "Este livro aborda Orientação a Objetos",
                "Sumário deve ser inserido",
                300,
                "978-12-34567-89-0",
                cassio,
                programacao,
                1,
                70.00);
        Livro python = new Livro(
                "Python",
                "Este livro aborda a linguigem Python",
                "Sumário deve ser inserido",
                300,
                "978-12-34567-89-0",
                murilo,
                programacao,
                1,
                70.00);

        lista.insereLivro(java);
        lista.insereLivro(python);

    }

    @Test
    public void buscaPorTituloDeveTerNoMinimoDoisCaracteres() {

        Livro java = new Livro(
                "Java",
                "Este livro aborda Orientação a Objetos",
                "Sumário deve ser inserido",
                300,
                "978-12-45678-89-0",
                cassio,
                programacao,
                1,
                70.00);

        lista.insereLivro(java);
        assertTrue("Java", lista.buscaPorTitulo("Ja").contains(java));
    }

    @Test(expected = IllegalArgumentException.class)
    public void buscaPorTituloNaoDeveTerMenosQueDoisCaracteres() {

        Livro java = new Livro(
                "Java",
                "Este livro aborda Orientação a Objetos",
                "Sumário deve ser inserido",
                300,
                "978-12-65478-89-0",
                cassio,
                programacao,
                1,
                70.00);

        lista.insereLivro(java);
        lista.buscaPorTitulo("J");
    }

    @Test
    public void buscaPorTituloPodeSerEmLetraMaiusculaOuMinuscula() {

        Livro java = new Livro(
                "Java",
                "Este livro aborda Orientação a Objetos",
                "Sumário deve ser inserido",
                300,
                "978-12-85236-89-0",
                cassio,
                programacao,
                1,
                70.00);

        lista.insereLivro(java);
        assertTrue("Java", lista.buscaPorTitulo("ja").contains(java));
        assertTrue("Java", lista.buscaPorTitulo("JA").contains(java));

    }

}