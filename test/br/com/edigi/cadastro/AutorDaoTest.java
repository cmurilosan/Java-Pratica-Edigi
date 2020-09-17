//package br.com.edigi.cadastro;
//
//import br.com.edigi.modelo.Autor;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.assertTrue;
//
//public class AutorDaoTest {
//
//    private AutorDao listaDeAutores;
//    private Autor cassio;
//    private Autor murilo;
//    private Autor santos;
//
//    @Before
//    public void criaAdminAutoresEAutor() {
//        this.listaDeAutores = new AutorDao();
//        this.cassio = new Autor("Cássio", "cassio@alura.com.br");
//        this.murilo = new Autor("Murilo", "murilo@alura.com.br");
//        this.santos = new Autor("Santos", "murilo@alura.com.br");
//    }
//
//    @Test
//    public void autoresDevemConstarNaLista() {
//
//        listaDeAutores.insereAutor(cassio);
//        listaDeAutores.insereAutor(murilo);
//
//        assertTrue(String.valueOf(cassio), listaDeAutores.getListaDeAutores().contains(cassio));
//        assertTrue(String.valueOf(murilo), listaDeAutores.getListaDeAutores().contains(murilo));
//    }
//
//    @Test(expected = RuntimeException.class)
//    public void autoresNaoPodemTerOMesmoEmail() {
//
//        listaDeAutores.insereAutor(cassio);
//        listaDeAutores.insereAutor(murilo);
//        listaDeAutores.insereAutor(santos);
//
//    }
//
//}