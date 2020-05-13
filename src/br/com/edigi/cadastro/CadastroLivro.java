package br.com.edigi.cadastro;

import br.com.edigi.modelo.Livro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CadastroLivro {

    private static List<Livro> listaDeLivros = new ArrayList<>();

    public static List<Livro> getListaDeLivros(){
        return Collections.unmodifiableList(listaDeLivros);
    }

    public void insereLivro(Livro livro) {
        if(CadastroLivro.listaDeLivros.contains(livro)){
            throw new RuntimeException("Já existe um livro cadastrado com esse ISBN");
        }
        CadastroLivro.listaDeLivros.add(livro);
    }
}
