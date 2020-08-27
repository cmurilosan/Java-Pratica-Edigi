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
                .mapToDouble(livro -> livros.get(livro) * livro.getPreco())
                .sum();
    }

    public void finalizaCompra() {
        StringBuilder builder = new StringBuilder("VENDA REALIZADA COM SUCESSO!!!\n");

        this.dataVenda = LocalDateTime.now();

        for (Livro livro : livros.keySet()) {
            builder.append("Livro: ")
                    .append(livro.getTitulo())
                    .append(" - ")
                    .append("Quantidade: ")
                    .append(livros.get(livro))
                    .append(" - ")
                    .append("Valor unitario: ")
                    .append(livro.getPreco())
                    .append("\n");
        }
        builder.append("\nTOTAL DA COMPRA: ")
                .append(this.getValorTotal());

        System.out.println(builder.toString());
    }

    public Map<Livro, Integer> getLivros() {
        return this.livros;
    }
}
