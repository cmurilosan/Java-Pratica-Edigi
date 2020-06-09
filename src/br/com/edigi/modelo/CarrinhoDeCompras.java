package br.com.edigi.modelo;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CarrinhoDeCompras {

    private LocalDateTime dataVenda;

    private Map<Livro, Integer> livros = new HashMap<>();

    public void add(Livro livro) {
        if (this.livros.containsKey(livro)) {
            int novaQuantidade = this.livros.get(livro) + 1;
            this.livros.put(livro, novaQuantidade);
        } else {
            this.livros.put(livro, 1);
        }
    }

    public double getValorTotal() {
        double valorTotal = 0;
        for (Livro valor: livros.keySet()) {
            valorTotal += valor.getPreco();
        }
        return valorTotal;
    }

    public void finalizaCompra() {
        System.out.println("VENDA REALIZADA COM SUCESSO");
        this.dataVenda = LocalDateTime.now();
        String livroQuantidade = "";
        for (Livro livro : livros.keySet()) {
            livroQuantidade += "Livro " + livro.getTitulo() +
                    " - Quantidade " + livros.get(livro) +
                    " - Valor Unitário: " + livro.getPreco() +  "\n";
        }
        System.out.println(livroQuantidade + "Total da Compra: " + this.getValorTotal());
    }
}
