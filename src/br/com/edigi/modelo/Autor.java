package br.com.edigi.modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Autor {

    private String nome;
    private String email;
    private String descricao;
    private LocalDate dataCadastro;

    public Autor(String nome,
                 String email,
                 String descricao) {
        setNome(nome);
        setEmail(email);
        setDescricao(descricao);
        this.dataCadastro = LocalDate.now();
    }

    private void setNome(String nome) {
        if(nome.isEmpty()){
            throw new IllegalArgumentException("Campo NOME deve ser preenchido!");
        }
        this.nome = nome;
    }

    private void setEmail(String email) {
        if(email.isEmpty()) {
            throw new IllegalArgumentException("Campo EMAIL deve ser preenchido!");
        }
        if(!email.matches("^([\\w][\\-]?\\.?)+@(([\\w][\\-]?)+\\.)+([A-Za-z]{2,4})+$")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.email = email;
    }

    public void setDescricao(String descricao) {
        if(descricao.isEmpty()){
            throw new IllegalArgumentException("Campo DESCRIÇÃO deve ser preenchido!");
        }
        if(descricao.length() > 400){
            throw new IllegalArgumentException("Campo excedeu mais de 400 caracteres");
        }
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object obj) {
        Autor outroAutor = (Autor) obj;
        return this.email.equals(outroAutor.email);
    }

    @Override
    public String toString() {
        return "\n------------------ Autor ------------------" +
                "\nNome: " + this.nome +
                "\nEmail: " + this.email +
                "\nDescricao: " + this.descricao;
    }
}
