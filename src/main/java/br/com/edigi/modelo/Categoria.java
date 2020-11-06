package br.com.edigi.modelo;

public class Categoria {

    private Long id;
    private String nome;

    public Categoria(String nome) {

        setNome(nome);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private void setNome(String nome) {
        if(nome.isEmpty() || nome.isBlank()) {
            throw new IllegalArgumentException("Nome deve ser obrigatório!");
        }
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
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
