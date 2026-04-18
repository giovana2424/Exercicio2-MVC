import controller.EmprestimoController;
import model.Aluno;
import model.Emprestimo;
import model.Livro;
import service.EmprestimoService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static List<Emprestimo> emprestimosAtuais = new ArrayList<>();
    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    public static void main(String[] args) {
        EmprestimoService emprestimoService = new EmprestimoService();
        EmprestimoController emprestimoController = new EmprestimoController(emprestimoService);

        Aluno aluno1 = new Aluno("25002423", "Ivy", "44123456798");
        Aluno aluno2 = new Aluno("25002324", "Ian", "44987654321");

        Livro livro1 = new Livro("Banco de Dados Relacionais", "Carlos Alberto Heuser", 10);
        Livro livro2 = new Livro("Algoritmos: Teoria e Prática", "Thomas Cormen", 8);
        Livro livro3 = new Livro("Python para Análise de Dados", "Wes McKinney", 4);

        Emprestimo emprestimo1 = emprestimoController.registrarEmprestimo(aluno1, livro2);
        emprestimosAtuais.add(emprestimo1);
        Emprestimo emprestimo2 = emprestimoController.registrarEmprestimo(aluno2, livro1);
        emprestimosAtuais.add(emprestimo2);
        Emprestimo emprestimo3 = emprestimoController.registrarEmprestimo(aluno2, livro3);
        emprestimosAtuais.add(emprestimo3);

        emprestimo1.setDataDevolucao(LocalDateTime.now());
        emprestimosAtuais.remove(emprestimo1);

        consultarEmprestimos();
        consultarEmprestimosPorAluno(aluno2);

    }

    public static void consultarEmprestimos(){
        List<Emprestimo> resultados = emprestimosAtuais.stream().toList();

        if (resultados.isEmpty()) {
            System.out.println("Nenhum empréstimo atual.");
        } else {
            resultados.forEach(emprestimo -> {
                System.out.println("Título: " + emprestimo.getLivro().getTitulo());
                System.out.println("Aluno: " + emprestimo.getAluno().getNome());
                System.out.println("Data do empréstimo: " + dateTimeFormatter.format(emprestimo.getDataEmprestimo()));
                System.out.println("------------------------------------------");
            });
        }
    }

    public static void consultarEmprestimosPorAluno(Aluno aluno){
        List<Emprestimo> resultados = emprestimosAtuais.stream().
                filter(e -> e.getAluno().equals(aluno)).
                collect(Collectors.toList());

        if (resultados.isEmpty()) {
            System.out.println("Nenhum empréstimo atual para esse aluno: " + aluno.getNome());
        } else {
            System.out.println("Aluno: " + aluno.getNome());
            System.out.println("Emprestimos em aberto:");
            resultados.forEach(e -> {
                System.out.println("\tLivro: " + e.getLivro().getTitulo());
                System.out.println("\tData: " + dateTimeFormatter.format(e.getDataEmprestimo()));
                System.out.println("------------------------------------------");
            });
        }
    }
}