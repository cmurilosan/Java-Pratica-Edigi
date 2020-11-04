package br.com.edigi.main;

import br.com.edigi.cadastro.AutorDao;
import br.com.edigi.cadastro.CategoriaDao;
import br.com.edigi.cadastro.LivroDao;
import br.com.edigi.modelo.Autor;
import br.com.edigi.modelo.Categoria;
import br.com.edigi.modelo.Livro;

public class TesteAdicionaLivro {

    public static void main(String[] args) {

        AutorDao autorDao = new AutorDao();
        Autor cassioSantos = autorDao.buscaAutorPeloEmail("kakashi.sensei@email.com");

        CategoriaDao categoriaDao = new CategoriaDao();
        Categoria programacao = categoriaDao.buscaCategoriaPorNome("Programação");
        Livro java = new Livro("Java",
                cassioSantos,
                programacao,
                "Esta é a criação do Livro Java",
                "Livro inserido na lista",
                300,
                "978-12-34567-89-0",
                1,
                30.00);

        LivroDao livroDao = new LivroDao();
        livroDao.adiciona(java);

        System.out.println("Salvo com sucesso!");
    }
}
