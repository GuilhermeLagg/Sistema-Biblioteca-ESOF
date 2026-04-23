package Controller;

import Model.Livro;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Gerenciador {

    Scanner sc = new Scanner(System.in);
    SistemaBiblioteca sistema = new SistemaBiblioteca("D:\\Perfil\\caio.sousa\\Downloads\\Sistema-Biblioteca-ESOF-main\\Sistema-Biblioteca-ESOF\\src\\Livros.txt");

    public void iniciarPrograma() {
        sistema.carregarDados();
        System.out.println(" ----- MENU ----- ");
        int opcao;

        do {
            opcao = menu();
            switch (opcao) {
                case 1:
                    System.out.println(" ---- Cadastro de novo livro ---- ");
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    
                    sistema.cadastrarLivro(titulo, autor);
                    sistema.salvarDados();
                    System.out.println("\nLivro cadastrado com sucesso!");
                    break;
                case 2:
                    List<Livro> lista = sistema.listarAcervo();
                    if (lista.isEmpty()) {
                        System.out.println("Acervo vazio, adicione um livro para visualizar");
                    } else {
                        System.out.println("Livros no acervo:");
                        for (Livro l : lista) {
                            System.out.println("----------------");
                            System.out.println(l);
                        }
                        System.out.println("----------------");
                    }
                    break;
                case 3:
                    sistema.salvarDados();
                    System.out.println("Saindo");
                    break;
            }
        } while (opcao != 3);
    }

    public int menu() {
        System.out.println("\nInforme a opcao desejada:");
        System.out.println("1 - Adicionar Livro");
        System.out.println("2 - Visualizar Acervo");
        System.out.println("3 - Fechar Programa");
        
        try {
            int opcao = sc.nextInt();
            sc.nextLine(); 
            return opcao;
        } catch (InputMismatchException e) {
            sc.nextLine();
            return -1;
        }
    }
}