package Controller;

import Model.Acervo;
import Model.ArquivoLivroRepository;
import Model.Livro;
import Model.ValidadorLivro;
import java.util.List;

public class SistemaBiblioteca {
    private Acervo acervo;
    private ArquivoLivroRepository repositorio;
    private String caminhoArquivo;

    public SistemaBiblioteca(String caminhoArquivo) {
        this.acervo = new Acervo();
        this.repositorio = new ArquivoLivroRepository();
        this.caminhoArquivo = caminhoArquivo;
    }

    public void cadastrarLivro(String titulo, String autor) {
        Livro livro = new Livro(titulo, autor);
        ValidadorLivro validador = new ValidadorLivro();
        
        if (validador.validar(livro)) {
            acervo.cadastrarLivro(livro);
        } else {
            System.out.println("ERRO AO CADASTRAR LIVRO - Informações inválidas.");
        }
    }

    public List<Livro> listarAcervo() {
        return acervo.listarLivros();
    }

    public void carregarDados() {
        List<Livro> livrosCarregados = repositorio.carregarLivros(caminhoArquivo);
        for (Livro l : livrosCarregados) {
            acervo.cadastrarLivro(l);
        }
    }

    public void salvarDados() {
        repositorio.salvarLivros(caminhoArquivo, acervo.listarLivros());
    }
}