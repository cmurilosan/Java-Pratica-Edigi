//package br.com.edigi.cadastro;
//
//import br.com.edigi.modelo.Autor;
//import br.com.edigi.modelo.Categoria;
//import br.com.edigi.modelo.Livro;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.assertTrue;
//
//public class LivroDaoTest {
//
//    private LivroDao listaDeLivros;
//    private Categoria programacao;
//    private Autor cassio;
//    private Autor murilo;
//
//    @Before
//    public void criaAdminLivroCategoriaEAutor() {
//        this.listaDeLivros = new LivroDao();
//        this.programacao = new Categoria("Programação");
//        this.cassio = new Autor("Cássio", "cassio@teste.com.br");
//        this.murilo = new Autor("Murilo", "murilo@teste.com.br");
//    }
//
//    @Test
//    public void livroDeveConstarNaLista() {
//
//        Livro java = new Livro(
//                "JSP e Hibernate",
//                "Este livro aborda Orientação a Objetos",
//                "Sumário deve ser inserido",
//                300,
//                "978-14-78523-69-0",
//                cassio,
//                programacao,
//                1,
//                70.00);
//
//        listaDeLivros.insereLivro(java);
//
//        assertTrue(String.valueOf(java), listaDeLivros.getListaDeLivros().contains(java));
//
//    }
//
//    @Test(expected = RuntimeException.class)
//    public void livrosNaoPodemTerOMesmoNumeroIsbn() {
//
//        Livro java = new Livro(
//                "Java",
//                "Este livro aborda Orientação a Objetos",
//                "Sumário deve ser inserido",
//                300,
//                "978-12-34567-89-0",
//                cassio,
//                programacao,
//                1,
//                70.00);
//        Livro python = new Livro(
//                "Python",
//                "Este livro aborda a linguigem Python",
//                "Sumário deve ser inserido",
//                300,
//                "978-12-34567-89-0",
//                murilo,
//                programacao,
//                1,
//                70.00);
//
//        listaDeLivros.insereLivro(java);
//        listaDeLivros.insereLivro(python);
//
//    }
//
//    @Test(expected = RuntimeException.class)
//    public void livrosNaoPodemTerOMesmoTitulo() {
//
//        Livro java = new Livro(
//                "Java",
//                "Este livro aborda Orientação a Objetos",
//                "Sumário deve ser inserido",
//                300,
//                "978-12-34567-89-0",
//                cassio,
//                programacao,
//                1,
//                70.00);
//        Livro python = new Livro(
//                "Java",
//                "Este livro aborda a linguigem Python",
//                "Sumário deve ser inserido",
//                300,
//                "978-12-85214-89-0",
//                murilo,
//                programacao,
//                1,
//                70.00);
//
//        listaDeLivros.insereLivro(java);
//        listaDeLivros.insereLivro(python);
//
//    }
//
//    @Test
//    public void buscaPorTituloDeveTerNoMinimoDoisCaracteres() {
//
//        Livro java = new Livro(
//                "Java",
//                "Este livro aborda Orientação a Objetos",
//                "Sumário deve ser inserido",
//                300,
//                "978-12-45678-89-0",
//                cassio,
//                programacao,
//                1,
//                70.00);
//
//        listaDeLivros.insereLivro(java);
//        assertTrue("Java", listaDeLivros.buscaPorTitulo("Ja").contains(java));
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void buscaPorTituloNaoDeveTerMenosQueDoisCaracteres() {
//
//        Livro java = new Livro(
//                "Orientação a Objetos",
//                "Este livro aborda Orientação a Objetos",
//                "Sumário deve ser inserido",
//                300,
//                "978-12-65478-89-0",
//                cassio,
//                programacao,
//                1,
//                70.00);
//
//        listaDeLivros.insereLivro(java);
//        listaDeLivros.buscaPorTitulo("J");
//    }
//
//    @Test
//    public void buscaPorTituloPodeSerEmLetraMaiusculaOuMinuscula() {
//
//        Livro java = new Livro(
//                "Solid",
//                "Este livro aborda Orientação a Objetos",
//                "Sumário deve ser inserido",
//                300,
//                "978-12-85236-89-0",
//                cassio,
//                programacao,
//                1,
//                70.00);
//
//        listaDeLivros.insereLivro(java);
//        assertTrue("Java", listaDeLivros.buscaPorTitulo("so").contains(java));
//        assertTrue("Java", listaDeLivros.buscaPorTitulo("SO").contains(java));
//
//    }
//
//}