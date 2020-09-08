package br.com.edigi.modelo;

public class Categoria {

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
