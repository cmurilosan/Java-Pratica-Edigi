package br.com.edigi.cadastro;

import br.com.edigi.modelo.Livro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdminLivro {

    private static List<Livro> listaDeLivros = new ArrayList<>();

    public static List<Livro> getListaDeLivros(){

        return Collections.unmodifiableList(listaDeLivros);
    }

    public void insereLivro(Livro livro) {
        if(AdminLivro.listaDeLivros.contains(livro)){
            throw new RuntimeException("Já existe um livro cadastrado com esse ISBN");
        }
        AdminLivro.listaDeLivros.add(livro);
    }

    public List<Livro> buscaPorTitulo(String palavra) {
        List<Livro> resultadoDaBusca = new ArrayList<>();
        for (Livro livro: listaDeLivros) {
            if (palavra.length() < 2){
                throw new IllegalArgumentException(palavra + " é insuficiente para a pesquisa");
            }
            if (contemNoTitulo(palavra, livro)){
                resultadoDaBusca.add(livro);
            }
            if (resultadoDaBusca.isEmpty()) {
                throw new IllegalArgumentException("Não há registro de TÍTULO com a palavra: " + palavra);
            }
        }
        return resultadoDaBusca;
    }

    private boolean contemNoTitulo(String palavra, Livro livro) {
        String tituloMaiusculo = livro.getTitulo().toUpperCase();
        String palavraMaiusculo = palavra.toUpperCase();

        return tituloMaiusculo.contains(palavraMaiusculo);
    }

}
