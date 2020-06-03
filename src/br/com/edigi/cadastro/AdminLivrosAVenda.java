package br.com.edigi.cadastro;

import java.util.ArrayList;
import java.util.List;

public class AdminLivrosAVenda {

    private static List<LivrosAVenda> livrosAVenda = new ArrayList<>();

    public void insereLivrosAVenda (LivrosAVenda ...livros) {
        for (LivrosAVenda livro : livros) {
            AdminLivrosAVenda.livrosAVenda.add(livro);
        }
    }

    public static List<LivrosAVenda> getLivrosAVenda() {
        return livrosAVenda;
    }

}
