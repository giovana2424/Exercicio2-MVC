package model;

public class Livro {
    private String titulo;
    private String autor;
    private Integer quantidadeDisponivel;

    public Livro(String titulo, String autor, Integer quantidadeDisponivel) {
        if(titulo == null || titulo.isBlank()){
            throw new IllegalArgumentException("Nome do livro não pode ser vazio.");
        }

        if(autor == null || autor.isBlank()){
            throw new IllegalArgumentException(("Nome do autor não pode ser vazio."));
        }

        if(quantidadeDisponivel == null || quantidadeDisponivel < 0){
            throw new IllegalArgumentException("Quantidade não pode ser negativa.");
        }
        this.titulo = titulo;
        this.autor = autor;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public boolean temDisponivel(int quantidade) {
        return quantidadeDisponivel >= quantidade;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }
}
