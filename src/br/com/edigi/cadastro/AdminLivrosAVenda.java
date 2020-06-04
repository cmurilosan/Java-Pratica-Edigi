package br.com.edigi.cadastro;

import javax.management.AttributeList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdminLivrosAVenda {

    private static List<LivroAVenda> livroAVenda = new ArrayList<>();
    private static List <LivroAVenda> carrinhoDeCompras = new ArrayList<>();

    public void insereLivrosAVenda (LivroAVenda...livros) {
        for (LivroAVenda livro : livros) {
            AdminLivrosAVenda.livroAVenda.add(livro);
        }
    }

    public static List<LivroAVenda> getLivroAVenda() {

        return Collections.unmodifiableList(livroAVenda);
    }

    public void carrinhoDeCompras (LivroAVenda livro) {
        if(livroAVenda.contains(livro)) {
            AdminLivrosAVenda.carrinhoDeCompras.add(livro);
            livro.decrementaQuantidade();
        }
    }

}
