package br.com.edigi.cadastro;

import br.com.edigi.modelo.Livro;

public class LivroAVenda {

    private Livro livro;
    private int quantidade;

    public LivroAVenda(Livro livro, int quantidade) {

        if (livro == null) {
            throw new NullPointerException("Livro não pode ser NULL");
        }
        if (quantidade < 1) {
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

    @Override
    public String toString() {
        return "\n================== LIVROS DISPONÍVEIS PARA VENDA ==================" +
                "\n" + livro +
                "\nUNIDADES DISPONÍVEIS: " + quantidade;
    }
}
