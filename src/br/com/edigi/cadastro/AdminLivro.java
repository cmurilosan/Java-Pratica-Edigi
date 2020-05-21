package br.com.edigi.cadastro;

import br.com.edigi.modelo.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdminLivro {

    private static List<Livro> listaDeLivros = new ArrayList<>();

    public void insereLivro(Livro livro) {
        if(AdminLivro.listaDeLivros.contains(livro)){
            throw new RuntimeException("Já existe um livro cadastrado com esse ISBN");
        }
        AdminLivro.listaDeLivros.add(livro);
    }

    public List<Livro> buscaPorTitulo(String palavra) {
        if (palavra.length() < 2){
                throw new IllegalArgumentException(palavra + " é insuficiente para a pesquisa");
            }

        return listaDeLivros.stream().filter(livro -> contemNoTitulo(palavra, livro))
                .collect(Collectors.toList());

    }

    private boolean contemNoTitulo(String palavra, Livro livro) {
        String tituloMaiusculo = livro.getTitulo().toUpperCase();
        String palavraMaiusculo = palavra.toUpperCase();

        return tituloMaiusculo.contains(palavraMaiusculo);
    }

}