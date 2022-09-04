package app.App;

public class app {
     public static void limparTela() {
          System.out.print("Limpa Tela");
          System.out.flush();
     }

     public static void printMenu() {
          limparTela();
          System.out.println("1 - Cadastrar Usuário");
          System.out.println("2 - Login de Usuário");
          System.out.println("3 - Universidade - Gerar currículo");
          System.out.println("4 - Aluno - Fazer matrícula");
          System.out.println("5 - Professor - Listar Alunos");
          System.out.println("0 - Sair e Salvar");
     }

     public static void main(String args[]) {
          /*
           * Disciplina dis = new Disciplina("Disciplina", true);
           * System.out.println(dis);
           */
          Scanner ler = new Scanner(System.in);
          try {
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
