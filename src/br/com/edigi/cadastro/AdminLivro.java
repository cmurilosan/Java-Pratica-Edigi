package br.com.edigi.cadastro;

import br.com.edigi.modelo.Livro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AdminLivro {

    private static List<Livro> listaDeLivros = new ArrayList<>();

    public void insereLivro(Livro livro) {
        if(AdminLivro.listaDeLivros.contains(livro)){
            throw new RuntimeException("Livro já cadastrado. Confirme o TÍTULO ou o ISBN");
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

    public boolean contem(Livro livro) {
        return listaDeLivros.contains(livro);
    }

    public List<Livro> getListaDeLivros() {
        return Collections.unmodifiableList(listaDeLivros);
    }
}