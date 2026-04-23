package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerenciarArquivos {

    private static final String NOME_ARQUIVO = "D:\\Perfil\\caio.sousa\\Downloads\\Sistema-Biblioteca-ESOF-main\\Sistema-Biblioteca-ESOF\\src\\Livros.txt";

    public static void salvarDados(List<Livro> acervo){
        FileWriter fw = null;
        BufferedWriter bw = null;
        try{
            fw = new FileWriter(NOME_ARQUIVO);
            bw = new BufferedWriter((fw));

            for (Livro l: acervo){
                String linha = "";
                //Informações do livro
                linha = l.getTitulo() + ";" +l.getAutor();
                bw.write(linha); //Escrevendo no arquivo
                bw.newLine();
            }
        } catch (IOException e){ 
            System.out.println("Erro ao salvar dados: " + e.getMessage()); 
        }
        try {
            //fechamos sempre do mais externo para o mais interno
            if (bw !=null){
                bw.close();
            }
            if (fw != null) {
                fw.close();
            }
        } catch (IOException e){
            System.out.println("Erro ao fechar o arquivo: " + e.getMessage());
        }
    }

    public static List<Livro> lerLivros() {
        //criar lista vazia
        List<Livro> acervo = new ArrayList<>();
        File arquivo = new File(NOME_ARQUIVO);

        //Se não existir o arquivo, retorna lista vazia
        if (!arquivo.exists()){
            return acervo;
        }

        FileReader fr = null;
        BufferedReader br = null;

        //Parte adaptada do trabalho de POO 💀☠💀☠💀☠💀☠
        try{
            fr = new FileReader(NOME_ARQUIVO);
            br = new BufferedReader(fr);
            String linha;

            while ((linha = br.readLine()) != null){
                if (linha.trim().isEmpty()){
                    continue;
                }
                String[] partes = linha.split(";");

                try{
                    String titulo = partes[0];
                    String autor = partes[1];
        
                    Livro l = null;
                    l = new Livro(titulo, autor);

                    if(l != null){
                        acervo.add(l);
                    }
                }catch(NumberFormatException e){}
            }
        } catch(IOException e){
            System.out.println("Erro ao carregar livros: " + e.getMessage());
        }finally{
            try {
                if (br != null) br.close();
                if (fr != null) fr.close();
            } catch (IOException e){
                System.out.println("Erro ao fechar leitor: "+ e.getMessage());
            }
        }
        return acervo;
    }
}
