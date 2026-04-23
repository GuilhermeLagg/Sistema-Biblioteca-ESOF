package Controller;

import java.util.List;
import java.util.Scanner;

import Model.GerenciarArquivos;
import Model.Livro;

public class SistemaBiblioteca {
    private static List<Livro> Acervo = GerenciarArquivos.lerLivros();

    public static Scanner sc = new Scanner(System.in);

    public static void cadastrarLivro(){
        System.out.println(" ---- Cadastro de novo livro ---- ");
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Autor: ");
        String autor = sc.nextLine();
        
        if(titulo == null || autor == null){
            System.out.println("ERRO AO CADASTRAR LIVRO - Informações inválidas \nOperação cancelada.\n");
            return;
        }

        Acervo.add(new Livro(titulo, autor));
        GerenciarArquivos.salvarDados(Acervo);
        System.out.println("\nLivro cadastrado com sucesso!");
    }

    public static void carregarDados(){
        if(Acervo.isEmpty()){
            System.out.println("Acervo vazio, adicione um livro para visualizar");
            return;
        }

        System.out.println("Livros no acervo");
        for(Livro l : Acervo){
            System.out.println("----------------\n");
            System.out.println(l);
            System.out.println("\n----------------\n");
        }

    }
}
