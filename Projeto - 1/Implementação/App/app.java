package app;

import java.util.*;

public class app {
	public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
	
	public static void printMenu() {
        limparTela();
        System.out.println("1 - Cadastrar Usuário");
        System.out.println("2 - Login de Usuário");
        System.out.println("3 - Universidade - Gerar Currículo");
        System.out.println("4 - Aluno - Cadastrar Matrícula");
        System.out.println("4 - Professor - Listar Alunos");
        System.out.println("0 - sair e salvar");
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        try {
            int k;
            do {
                printMenu();
                k = ler.nextInt();

                switch (k) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    default:
                        break;

                }
                System.out.println("Press Enter to continue...");
                System.in.read();
            } while (k != 0);
        } catch (Exception e) {
            System.out.println("");
        }


    }
}
