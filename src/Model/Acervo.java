package Model;

import java.util.ArrayList;
import java.util.List;

public class Acervo {
    private List<Livro> livros;

    public Acervo() {
        this.livros = new ArrayList<>();
    }

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> listarLivros() {
        return livros;
    }

    public boolean estaVazio() {
        return livros.isEmpty();
    }
}