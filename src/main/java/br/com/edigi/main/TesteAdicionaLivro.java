package br.com.edigi.main;

import br.com.edigi.cadastro.LivroDao;
import br.com.edigi.modelo.Livro;

import java.sql.SQLException;

public class TesteAdicionaLivro {

    public static void main(String[] args) throws SQLException {

        Livro java = new Livro("Java",
                "Esta é a criação do Livro Java",
                "Livro inserido na lista",
                300,
                "978-12-34567-89-0",
                1,
                30.00);

        Livro mySql = new Livro("MySql",
                "Esta é a criação do Livro MySql",
                "Livro inserido na lista",
                400,
                "978-12-52147-89-0",
                2,
                50.00);

        LivroDao livroDao = new LivroDao();
//        livroDao.adiciona(java);
//        livroDao.adiciona(mySql);

//        System.out.println("Salvo com sucesso!");

        livroDao.getListaLivros();
    }
}
