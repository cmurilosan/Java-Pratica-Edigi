package br.com.edigi.main;

import br.com.edigi.cadastro.AutorDao;
import br.com.edigi.cadastro.CategoriaDao;
import br.com.edigi.cadastro.ConnectionFactory;
import br.com.edigi.cadastro.LivroDao;
import br.com.edigi.modelo.Autor;
import br.com.edigi.modelo.Categoria;
import br.com.edigi.modelo.Livro;
import com.sun.jdi.connect.spi.Connection;

import java.sql.SQLException;

public class TesteAdicionaLivro {

    public static void main(String[] args) throws SQLException {

        Autor cassioSantos = new Autor("kakashi Sensei", "kakashi.sensei@email.com");
        AutorDao autorDao = new AutorDao();
//        autorDao.adiciona(cassioSantos);

        Categoria programação = new Categoria("Programação");
        CategoriaDao categoriaDao = new CategoriaDao();
//        categoriaDao.adiciona(programação);

        Livro java = new Livro("Java",
                cassioSantos,
                programação,
                "Esta é a criação do Livro Java",
                "Livro inserido na lista",
                300,
                "978-12-34567-89-0",
                1,
                30.00);

        LivroDao livroDao = new LivroDao();
        livroDao.adiciona(java);

        System.out.println("Salvo com sucesso!");

//        livroDao.listar();
    }
}
