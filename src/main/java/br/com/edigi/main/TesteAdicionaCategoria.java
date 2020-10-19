package br.com.edigi.main;

import br.com.edigi.cadastro.CategoriaDao;
import br.com.edigi.modelo.Categoria;

import java.sql.SQLException;
import java.util.List;

public class TesteAdicionaCategoria {

    public static void main(String[] args) throws SQLException {

//        Categoria programação = new Categoria("Programação");
//
        CategoriaDao dao = new CategoriaDao();
//
//        dao.adiciona(programação);
//
//        System.out.println("Gravado com sucesso!");

        List<Categoria> categorias = dao.listaCategorias();

        for(Categoria categoria : categorias) {
            System.out.println("Nome: " + categoria.getNome());
        }

    }
}
