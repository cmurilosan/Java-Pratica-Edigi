package br.com.edigi.cadastro;

import br.com.edigi.modelo.Livro;

public class LivrosAVenda {

    private Livro livro;
    private int quantidade;

    public LivrosAVenda(Livro livro, int quantidade) {

        if (this.livro == null) {
            throw new NullPointerException("Livro não pode ser NULL");
        }
        if (this.quantidade < 1) {
            throw new IllegalArgumentException("A quantidade de livros deve ser de pelo menos 1.");
        }
        this.livro = livro;
        this.quantidade = quantidade;
    }

    public void incrementaQuantidade() {
        this.quantidade++;
    }

    public void decrementaQuantidade() {
        this.quantidade--;
    }

    public void incrementaQuantidade(int quantidade) {
        this.quantidade = this.quantidade + quantidade;
    }
}
