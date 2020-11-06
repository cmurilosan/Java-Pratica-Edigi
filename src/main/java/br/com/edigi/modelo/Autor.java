package br.com.edigi.modelo;

public class Autor {

    private Long id;
    private String nome;
    private String email;

    public Autor(String nome,
                 String email) {
        setNome(nome);
        setEmail(email);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private void setNome(String nome) {
        if(nome.isEmpty() || nome.isBlank()){
            throw new IllegalArgumentException("Campo NOME deve ser preenchido!");
        }
        this.nome = nome;
    }

    private void setEmail(String email) {
        if(email.isEmpty() || email.isBlank()) {
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
