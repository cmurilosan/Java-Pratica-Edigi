package br.com.edigi.main;

import br.com.edigi.cadastro.AdminAutores;
import br.com.edigi.cadastro.AdminCategoria;
import br.com.edigi.cadastro.AdminLivro;
import br.com.edigi.modelo.Autor;
import br.com.edigi.modelo.Categoria;
import br.com.edigi.modelo.Livro;

import java.util.List;

public class TesteEdigi {

    public static void main(String[] args) {

        AdminAutores listaDeAutores = new AdminAutores();

        Autor cassio = new Autor("Cassio", "cassio.java@primeiroautor.com.br");
        Autor murilo = new Autor("Murilo", "murilo.logica@segundoautor.com.br");
        Autor santos = new Autor("Santos", "santos.forum@terceiroautor.com.br");
        Autor kakashi = new Autor("Kakashi", "kakashi.forum@quartoautor.com.br");
//      AUTOR COM O MESMO EMAIL
//      Autor equipe = new Autor("Equipe", "santos.forum@terceiroautor.com.br");

        listaDeAutores.insereAutor(cassio);
        listaDeAutores.insereAutor(murilo);
        listaDeAutores.insereAutor(santos);
        listaDeAutores.insereAutor(kakashi);
//      listaDeAutores.insereAutor(equipe);

        AdminCategoria listaDeCategoria = new AdminCategoria();

        Categoria programacao = new Categoria("Programação");
        Categoria frontend = new Categoria("FrontEnd");
        Categoria mobile = new Categoria("Mobile");
//      CATEGORIA COM O MESMO NOME
//      Categoria bancoDados = new Categoria("Mobile");

        listaDeCategoria.insereCategoria(programacao);
        listaDeCategoria.insereCategoria(frontend);
        listaDeCategoria.insereCategoria(mobile);
//		listaDeCategoria.setListaDeCategorias(bancoDados);

        AdminLivro cadastroDeLivros = new AdminLivro();

        Livro java = new Livro("Java", "Esta é a criação do Livro Java", "Livro inserido na lista", 300, "978-12-34567-89-0", cassio, programacao, 1, 30.00);
        Livro javascript = new Livro("Javascript", "Esta é a criação do Livro Javascript", "Livro inserido na lista", 280, "978-85-23698-74-1", kakashi, frontend, 1, 33.00);
        Livro react = new Livro("React", "Esta é a criação do Livro React", "Livro inserido na lista", 320, "978-23-45678-90-1", murilo, frontend, 2, 40.30);
        Livro android = new Livro("Android", "Esta é a criação do Livro Android", "Livro inserido na lista", 330, "978-34-56789-01-2", santos, mobile, 3, 35.60);
//		ISBN e EDICÃO com os devidos erros
//		Livro mySql = new Livro("mySql", "Esta é a criação do Livro mySql", "Livro inserido na lista", 350, "977-98-74125-89-6", equipe, bancoDados, 0, 41.35);

        cadastroDeLivros.insereLivro(java);
        cadastroDeLivros.insereLivro(react);
        cadastroDeLivros.insereLivro(android);
        cadastroDeLivros.insereLivro(javascript);
//		cadastroDeLivros.setListaDeLivros(mySql);

//		System.out.println(CadastroAutores.getListaDeAutores());
//		System.out.println(CadastroCategorias.getListaDeCategoria());
//        System.out.println(AdminLivro.getListaDeLivros());

        List<Livro> livrosEncontrados = cadastroDeLivros.buscaPorTitulo("ja");
        System.out.println("Resultado da busca: " + livrosEncontrados);

    }

}
