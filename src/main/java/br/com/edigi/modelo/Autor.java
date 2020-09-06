package br.com.edigi.modelo;

import javax.persistence.*;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    
    @Column(unique = true)
    private String email;

    public Autor(String nome,
                 String email) {
        setNome(nome);
        setEmail(email);
    }

    @Deprecated
    private Autor() {
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

    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
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
                "\nEmail: " + this.email;
    }

}
