package br.com.edigi.modelo;

import br.com.edigi.cadastro.AdminLivro;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CarrinhoDeCompras {

    private LocalDateTime dataVenda;
    private AdminLivro adminLivro = new AdminLivro();

    private Map<Livro, Integer> livros = new HashMap<>();

    public void add(Livro livro) {
        if (!adminLivro.contem(livro)) {
            throw new RuntimeException("Os livros adicionados a venda precisam existir no catálogo de livros.");
            //Erro de tempo de execução
        }
        if (this.livros.containsKey(livro)) {
            int novaQuantidade = this.livros.get(livro) + 1;
            this.livros.put(livro, novaQuantidade);
        } else {
            this.livros.put(livro, 1);
        }
    }

    public double getValorTotal() {
        return livros.keySet()
                .stream()
                .mapToDouble(Livro::getPreco)
                .sum();
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
