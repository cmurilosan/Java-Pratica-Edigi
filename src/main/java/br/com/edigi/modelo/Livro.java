package br.com.edigi.modelo;

public class Livro {

    private Long id;
    private String titulo;
    private Autor autor;
    private Categoria categoria;
    private String resumo;
    private String sumario;
    private int numeroPaginas;
    private String isbn;
    private int edicao;
    private double preco;

    public Livro(String titulo,
                 Autor autor,
                 Categoria categoria,
                 String resumo,
                 String sumario,
                 int numeroPaginas,
                 String isbn,
                 int edicao,
                 double preco) {
        setTitulo(titulo);
        this.autor = autor;
        this.categoria = categoria;
        setResumo(resumo);
        setSumario(sumario);
        setNumeroPaginas(numeroPaginas);
        setIsbn(isbn);
        setEdicao(edicao);
        setPreco(preco);
    }

    public String getTitulo() {

        return this.titulo;
    }

    private void setTitulo(String titulo) {
        if(titulo.isEmpty() || titulo.isBlank()){
            throw new IllegalArgumentException("Campo TÍTULO deve ser preenchido");
        }
        this.titulo = titulo;
    }

    public String getResumo() {

        return resumo;
    }

    private void setResumo(String resumo) {
        if(resumo.isEmpty() || resumo.isBlank()){
            throw new IllegalArgumentException("Campo DESCRIÇÃO deve ser preenchido");
        }
        if(resumo.length() > 500){
            throw new IllegalArgumentException("Campo excedeu mais de 500 caracteres");
        }
        this.resumo = resumo;
    }

    public String getSumario() {
        return sumario;
    }

    private void setSumario(String sumario) {
        if(sumario.isEmpty() || sumario.isBlank()){
            throw new IllegalArgumentException("Sumário deve ser preenchido");
        }
        this.sumario = sumario;
    }

    public int getNumeroPaginas() {

        return numeroPaginas;
    }

    private void setNumeroPaginas(int numeroPaginas) {
        if(numeroPaginas < 1){
            throw new IllegalArgumentException("Número de páginas deve ser maior que zero");
        }
        this.numeroPaginas = numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    private void setIsbn(String isbn) {
        if(isbn.isEmpty() || isbn.isBlank()){
            throw new IllegalArgumentException("ISBN deve ser preenchido");
        }
        if(!isbn.startsWith("978")){
            throw new IllegalArgumentException("ISBN incorreto");
        }
        if(!isbn.matches("\\d{3}-\\d{2}-\\d{5}-\\d{2}-\\d{1}")){
            throw new IllegalArgumentException("ISBN segue a seguinte regra: xxx-xx-xxxxx-xx-x ");
        }
        this.isbn = isbn;
    }

    public int getEdicao() {

        return edicao;
    }

    private void setEdicao(int edicao) {
        if(edicao < 1){
            throw new IllegalArgumentException("Edição deve começar em 1");
        }
        this.edicao = edicao;
    }

    public double getPreco() {
        return preco;
    }

    private void setPreco(double preco) {
        if (preco < 0){
            throw new IllegalArgumentException("Valor deve ser número positivo");
        }
        this.preco = preco;
    }

    @Override
    public boolean equals(Object obj) {
        Livro outroLivro = (Livro) obj;
        return this.isbn.equals(outroLivro.isbn) ||
                this.titulo.equals(outroLivro.titulo);
    }

    @Override
    public String toString() {
        return "\n================== Livro ==================" +
                "\nTitulo = " + titulo +
                "\nAutor = " + autor +
                "\nCategoria = " + categoria +
                "\nResumo = " + resumo +
                "\nSumario = " + sumario +
                "\nNumero de Paginas = " + numeroPaginas +
                "\nEdicao = " + edicao +
                "\nPreco = R$ " + preco +
                "\nISBN = " + isbn;
    }
}
