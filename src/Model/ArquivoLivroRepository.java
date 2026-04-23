package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArquivoLivroRepository {
    
    public List<Livro> carregarLivros(String caminho) {
        List<Livro> acervo = new ArrayList<>();
        File arquivo = new File(caminho);

        if (!arquivo.exists()) {
            return acervo;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) {
                    continue;
                }
                String[] partes = linha.split(";");

                if (partes.length >= 2) {
                    String titulo = partes[0];
                    String autor = partes[1];
                    Livro l = new Livro(titulo, autor);
                    acervo.add(l);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar livros: " + e.getMessage());
        }
        return acervo;
    }

    public void salvarLivros(String caminho, List<Livro> livros) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
            for (Livro l : livros) {
                String linha = l.getTitulo() + ";" + l.getAutor();
                bw.write(linha);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }
}