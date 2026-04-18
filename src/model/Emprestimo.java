package model;

import java.time.LocalDateTime;

public class Emprestimo {
    private Aluno aluno;
    private Livro livro;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;

    public Emprestimo(Aluno aluno) {
        this.aluno = aluno;
        this.livro = livro;
        this.dataEmprestimo = LocalDateTime.now();
        this.dataDevolucao = dataDevolucao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
