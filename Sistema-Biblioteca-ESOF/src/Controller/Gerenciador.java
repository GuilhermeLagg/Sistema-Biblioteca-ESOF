package Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Gerenciador {

    Scanner sc = new Scanner(System.in);

    public void iniciarPrograma(){
        System.out.println(" ----- MENU ----- ");
        int opcao;

        do{
            opcao = menu();
            switch (opcao) {
                case 1:
                    SistemaBiblioteca.cadastrarLivro();
                    break;
                case 2:
                    SistemaBiblioteca.carregarDados();
                    break;
                case 3:
                    System.out.println("Saindo");
                    break;
            }
        }while(opcao!=3);
    }

    public int menu() {
        System.out.println("informe a opcao desejada:\n\n");
        System.out.println("1 - Adicionar Livro \n"+
        "2 - Visualizar Acervo \n"+
        "3 - Fechar Programa \n");
        try {
            int opcao = sc.nextInt();
            return opcao;
        } catch (InputMismatchException e) {
            sc.nextLine();
            return -1;
        }
    }
}
