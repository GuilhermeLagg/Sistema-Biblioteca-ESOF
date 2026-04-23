package Model;

public class ValidadorLivro {
    public boolean validar(Livro livro) {
        if (livro == null) {
            return false;
        }
        if (livro.getTitulo() == null || livro.getTitulo().trim().isEmpty()) {
            return false;
        }
        if (livro.getAutor() == null || livro.getAutor().trim().isEmpty()) {
            return false;
        }
        return true;
    }
}