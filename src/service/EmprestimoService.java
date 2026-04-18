package service;

import model.Aluno;
import model.Emprestimo;
import model.Livro;

import java.time.LocalDateTime;

public class EmprestimoService {
    LivroService livroService = new LivroService();

    public Emprestimo registrarEmprestimo(Aluno aluno, Livro livro){
        Emprestimo emprestimo = new Emprestimo(aluno);
        adicionarLivro(emprestimo, livro);
        return emprestimo;
    }

    public void adicionarLivro(Emprestimo emprestimo, Livro livro){
        emprestimo.setLivro(livro);
        livroService.reduzirQuantidade(livro);
    }

    public void definirDataDevolucao(Emprestimo emprestimo, LocalDateTime dataDevolucao) {
        if (dataDevolucao.isBefore(emprestimo.getDataEmprestimo())){
            throw new IllegalArgumentException("Data de devolução não pode ser anterior a data do empréstimo.");
        }
        emprestimo.setDataDevolucao(dataDevolucao);
        livroService.aumentarQuantidade(emprestimo.getLivro());
    }
}
