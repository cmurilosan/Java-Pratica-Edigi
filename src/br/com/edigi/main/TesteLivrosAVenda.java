package br.com.edigi.main;

import br.com.edigi.cadastro.*;
import br.com.edigi.modelo.Autor;
import br.com.edigi.modelo.Categoria;
import br.com.edigi.modelo.Livro;

public class TesteLivrosAVenda {

    public static void main(String[] args) {

        AdminAutores listaDeAutores = new AdminAutores();

        Autor cassio = new Autor("Cassio", "cassio.java@primeiroautor.com.br");
        Autor murilo = new Autor("Murilo", "murilo.logica@segundoautor.com.br");

        listaDeAutores.insereAutor(cassio);
        listaDeAutores.insereAutor(murilo);

        AdminCategoria listaDeCategoria = new AdminCategoria();

        Categoria programacao = new Categoria("Programação");
        Categoria frontend = new Categoria("FrontEnd");

        listaDeCategoria.insereCategoria(programacao);
        listaDeCategoria.insereCategoria(frontend);

        AdminLivro cadastroDeLivros = new AdminLivro();

        Livro java = new Livro(
                "Java",
                "Esta é a criação do Livro Java",
                "Livro inserido na lista",
                300,
                "978-12-34567-89-0",
                cassio,
                programacao,
                1,
                30.00);
        Livro react = new Livro(
                "React",
                "Esta é a criação do Livro React",
                "Livro inserido na lista",
                320,
                "978-23-45678-90-1",
                murilo,
                frontend,
                2,
                40.30);

        cadastroDeLivros.insereLivro(java);
        cadastroDeLivros.insereLivro(react);

        LivrosAVenda livroReactAVenda = new LivrosAVenda(react, 10);
        LivrosAVenda livroJavaAVenda = new LivrosAVenda(java, 5);

        AdminLivrosAVenda adminLivrosAVenda = new AdminLivrosAVenda();

        adminLivrosAVenda.insereLivrosAVenda(livroReactAVenda, livroJavaAVenda);

        System.out.println(AdminLivrosAVenda.getLivrosAVenda());
    }
}
