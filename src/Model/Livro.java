package Model;

public class Livro {

    protected String titulo;
    protected String autor;
    //protected boolean alugado;

    public Livro(){}

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
    
    @Override
    public String toString() {
        return "Livro [titulo=" + titulo + ", autor=" + autor + "]";
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String preço) {
        this.autor = preço;
    }
    /*public boolean isAlugado() {
        return alugado;
    }
    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }*/

    
}
