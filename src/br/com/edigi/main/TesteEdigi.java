package br.com.edigi.main;

import br.com.edigi.cadastro.*;
import br.com.edigi.modelo.Autor;
import br.com.edigi.modelo.CarrinhoDeCompras;
import br.com.edigi.modelo.Categoria;
import br.com.edigi.modelo.Livro;

public class TesteEdigi {

    public static void main(String[] args) {

        AdminAutores listaDeAutores = new AdminAutores();

        Autor cassio = new Autor("Cassio", "cassio.java@primeiroautor.com.br");
        Autor murilo = new Autor("Murilo", "murilo.logica@segundoautor.com.br");
        Autor santos = new Autor("Santos", "santos.forum@terceiroautor.com.br");
        Autor kakashi = new Autor("Kakashi", "kakashi.forum@quartoautor.com.br");

        listaDeAutores.insereAutor(cassio);
        listaDeAutores.insereAutor(murilo);
        listaDeAutores.insereAutor(santos);
        listaDeAutores.insereAutor(kakashi);

        AdminCategoria listaDeCategoria = new AdminCategoria();

        Categoria programacao = new Categoria("Programação");
        Categoria frontend = new Categoria("FrontEnd");
        Categoria mobile = new Categoria("Mobile");

        listaDeCategoria.insereCategoria(programacao);
        listaDeCategoria.insereCategoria(frontend);
        listaDeCategoria.insereCategoria(mobile);

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
        Livro javascript = new Livro(
                "Javascript",
                "Esta é a criação do Livro Javascript",
                "Livro inserido na lista",
                280,
                "978-85-23698-74-1",
                kakashi,
                frontend,
                1,
                33.00);
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
        Livro android = new Livro(
                "Android",
                "Esta é a criação do Livro Android",
                "Livro inserido na lista",
                330,
                "978-34-56789-01-2",
                santos,
                mobile,
                3,
                35.60);

        cadastroDeLivros.insereLivro(java);
        cadastroDeLivros.insereLivro(react);
        cadastroDeLivros.insereLivro(android);

//		System.out.println(CadastroAutores.getListaDeAutores());
//		System.out.println(CadastroCategorias.getListaDeCategoria());

//        List<Livro> livrosEncontrados = cadastroDeLivros.buscaPorTitulo("ja");
//        System.out.println("Resultado da busca: " + livrosEncontrados);

        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        carrinhoDeCompras.add(android);
        carrinhoDeCompras.add(android);
        carrinhoDeCompras.add(java);

        carrinhoDeCompras.finalizaCompra();

    }

}
