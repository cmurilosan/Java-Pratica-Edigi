package br.com.edigi.main;

import br.com.edigi.cadastro.CadastroAutores;
import br.com.edigi.cadastro.CadastroCategoria;
import br.com.edigi.cadastro.CadastroLivro;
import br.com.edigi.modelo.Autor;
import br.com.edigi.modelo.Categoria;
import br.com.edigi.modelo.Livro;

public class TestaCadastro {

    public static void main(String[] args) {

        CadastroAutores listaDeAutores = new CadastroAutores();

        Autor cassio = new Autor("Cassio", "cassio.java@primeiroautor.com.br", "campo preenchido");
        Autor murilo = new Autor("Murilo", "murilo.logica@segundoautor.com.br", "não pode ficar vazio");
        Autor santos = new Autor("Santos", "santos.forum@terceiroautor.com.br", "não pode mais que 400");
//      AUTOR COM O MESMO EMAIL
//      Autor equipe = new Autor("Equipe", "santos.forum@terceiroautor.com.br", "teste feito");

        listaDeAutores.insereAutor(cassio);
        listaDeAutores.insereAutor(murilo);
        listaDeAutores.insereAutor(santos);
//      listaDeAutores.insereAutor(equipe);

        CadastroCategoria listaDeCategoria = new CadastroCategoria();

        Categoria programacao = new Categoria("Programação");
        Categoria frontend = new Categoria("FrontEnd");
        Categoria mobile = new Categoria("Mobile");
//      CATEGORIA COM O MESMO NOME
//      Categoria bancoDados = new Categoria("Mobile");

        listaDeCategoria.insereCategoria(programacao);
        listaDeCategoria.insereCategoria(frontend);
        listaDeCategoria.insereCategoria(mobile);
//		listaDeCategoria.setListaDeCategorias(bancoDados);

        CadastroLivro listaDeLivros = new CadastroLivro();

        Livro java = new Livro("Java", "Esta é a criação do Livro Java", "Livro inserido na lista", 300, "978-12-34567-89-0", cassio, programacao, 1, 30.00);
        Livro react = new Livro("React", "Esta é a criação do Livro React", "Livro inserido na lista", 320, "978-23-45678-90-1", murilo, frontend, 2, 40.30);
        Livro android = new Livro("Android", "Esta é a criação do Livro Android", "Livro inserido na lista", 330, "978-34-56789-01-2", santos, mobile, 3, 35.60);
//		ISBN e EDICÃO com os devidos erros
//		Livro mySql = new Livro("mySql", "Esta é a criação do Livro mySql", "Livro inserido na lista", 350, "977-98-74125-89-6", equipe, bancoDados, 0, 41.35);

        listaDeLivros.insereLivro(java);
        listaDeLivros.insereLivro(react);
        listaDeLivros.insereLivro(android);
//		listaDeLivros.setListaDeLivros(mySql);

//		System.out.println(CadastroAutores.getListaDeAutores());
//		System.out.println(CadastroCategorias.getListaDeCategoria());
        System.out.println(CadastroLivro.getListaDeLivros());
    }
}
