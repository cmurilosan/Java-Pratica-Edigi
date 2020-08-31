package br.com.edigi.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categoria {

    @Id
    @Column
    private String nome;

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

    public String getNome() {
        return this.nome;
    }
}
