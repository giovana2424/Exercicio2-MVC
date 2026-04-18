package service;

import model.Livro;

public class LivroService {
    public void reduzirQuantidade(Livro livro){
        Integer quantidade = 1;
        if (!livro.temDisponivel(quantidade)){
            throw new IllegalArgumentException("Não há quantidade suficiente.");
        }
        quantidade -= livro.getQuantidadeDisponivel();
        livro.setQuantidadeDisponivel(quantidade);
    }

    public void aumentarQuantidade(Livro livro){
        Integer quantidade = 1;
        quantidade += livro.getQuantidadeDisponivel();
        livro.setQuantidadeDisponivel(quantidade);
    }
}
