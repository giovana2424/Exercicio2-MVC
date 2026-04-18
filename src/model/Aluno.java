package model;

public class Aluno {
    private String ra;
    private String nome;
    private String telefone;

    public Aluno(String ra, String nome, String telefone) {
        this.ra = ra;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getRa() {
        return ra;
    }

    public String getNome() {
        return nome;
    }
}
