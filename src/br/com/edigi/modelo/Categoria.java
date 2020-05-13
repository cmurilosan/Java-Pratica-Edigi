package br.com.edigi.modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Categoria {

    private String nome;
    private LocalDate dataCadastro;

    public Categoria(String nome) {
        setNome(nome);
    }

    private void setNome(String nome) {
        if(nome.isEmpty()) {
            throw new IllegalArgumentException("Nome deve ser obrigatório!");
        }
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        Categoria outraCategoria = (Categoria) obj;
        return this.nome.equals(outraCategoria.nome);
    }

    @Override
    public String toString() {
        return "\n------------------ Categoria ------------------" +
                "\nCategoria: " + this.nome +
                "\n";
    }
}
