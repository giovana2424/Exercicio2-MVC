package controller;

import model.Aluno;
import model.Emprestimo;
import model.Livro;
import service.EmprestimoService;

public class EmprestimoController {
    EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService){
        this.emprestimoService = emprestimoService;
    }

    public Emprestimo registrarEmprestimo(Aluno aluno, Livro livro){
        Emprestimo emprestimo = emprestimoService.registrarEmprestimo(aluno, livro);
        return emprestimo;
    }
}
