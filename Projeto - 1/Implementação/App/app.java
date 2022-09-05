package App;

import java.io.*;
import java.util.*;

public class app {
	public static void limparTela() {
		System.out.flush();
	}

	public static void adicionarUsuario(Usuario usuario, boolean reescrever) {
		try {
			FileWriter arq = new FileWriter("./teste.txt", reescrever);
			PrintWriter gravarArq = new PrintWriter(arq);

			gravarArq.printf("[\n" + usuario.getId() + "\n" +
					usuario.getNome() + "\n" +
					usuario.getUsername() + "\n" +
					usuario.getSenha() + "\n" +
					usuario.getToken() + "\n]\n");

			arq.close();
		} catch (Exception e) {
			System.out.println("");
		}
	}

	public static void printMenu(int token) {
		if (token == 1) {
			limparTela();
			System.out.println("Menu Secretária:\n");
			System.out.println("1 - Cadastrar curso");
			System.out.println("2 - Deletar curso");
			System.out.println("3 - Editar dados de um aluno");
			System.out.println("4 - Deletar dados de um aluno");
			System.out.println("5 - Gerar currículo");
			System.out.println("0 - Sair e salvar");
		}
		if (token == 2) {
			limparTela();
			System.out.println("Menu Professor:\n");
			System.out.println("1 - Realizar matrícula");
			System.out.println("2 - Cancelar matrícula");
			System.out.println("3 - Adicionar disciplina");
			System.out.println("4 - Remover disciplina");
			System.out.println("0 - sair e salvar");
		}
		if (token == 3) {
			limparTela();
			System.out.println("Menu Aluno:\n");
			System.out.println("1 - Realizar matrícula");
			System.out.println("2 - Cancelar matrícula");
			System.out.println("3 - Inscrever em curso");
			System.out.println("4 - Cancelar inscrição de usuário");
			System.out.println("0 - sair e salvar");
		}
	}

	public static int realizarLogin() {
		Scanner ler = new Scanner(System.in);
		String nome = "";
		String senha = "";
		String nomeArq = "";
		String senhaArq = "";
		boolean login = false;
		int token = 0;
		try {
			while (!login) {
				Scanner in = new Scanner(new FileReader("teste.txt"));

				System.out.println("Favor informar seus dados:\nUser Name: ");
				nome = ler.next();
				System.out.println("\nSenha: ");
				senha = ler.next();

				int i = 0;
				while (in.hasNextLine()) {
					String line = in.nextLine();
					if (line.charAt(0) == '[') {
						line = in.nextLine();
						line = in.nextLine();
						nomeArq = in.nextLine();
						senhaArq = in.nextLine();
						i = in.nextInt();
						line = in.nextLine();
					}
					if ((nome.compareTo(nomeArq) == 0) && (senha.compareTo(senhaArq) == 0)) {
						login = true;
						token = i;
					}
				}
				if (!login) {
					System.out.println("User Name ou Senha inválidos! Tente novamente!");
				} else {
					System.out.println("Bem vindo(a) " + nome + "!");
				}
			}
			System.out.println(token);
		} catch (Exception e) {
			System.out.println("");
		}

		ler.close();
		return token;
	}

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		try {
			Usuario u1 = new Secretaria("Amanda", "amandinha", "1234");
			Usuario u2 = new Secretaria("Rafael", "machomen", "123");
			Usuario u3 = new Secretaria("Luiza", "luizinha", "abc");

			adicionarUsuario(u1, false);
			adicionarUsuario(u2, true);
			adicionarUsuario(u3, true);

			int x;
			do {
				System.out.println("Você possui cadastro?/n0- SIM/n1- NAO");
				x = ler.nextInt();
				if (x == 1) {
					System.out.println("Digite seu nome:");
					String nome = ler.next();
					System.out.println("Digite um user name:");
					String userName = ler.next();
					System.out.println("Digite uma senha:");
					String senha = ler.next();
					int i;
					do {
						System.out.println("O que você é?/n0- Secretario(a)/n1- Professor(a)/n2- Aluno(a)");
						i = ler.nextInt();
						if (i == 0) {
							adicionarUsuario(new Secretaria(nome, userName, senha), true);
						} else if (i == 1) {
							adicionarUsuario(new Professor(nome, userName, senha), true);
						} else {
							adicionarUsuario(new Aluno(nome, userName, senha), true);
						}
					} while (i < 0 || i > 2);
				}
			} while (x > 1 || x < 0);

			int k;
			int token = realizarLogin();

			Secretaria c = new Secretaria();

			do {
				printMenu(token);
				k = ler.nextInt();

				if (token == 1) {
					switch (k) {
						case 1:
							System.out.println("Digite o nome do curso que deseja cadastrar:");
							String nomeCurso = ler.next();
							System.out.println("Digite os créditos do curso:");
							String creditosCurso = ler.next();
							c.cadastrarCurso(new Curso(nomeCurso, creditosCurso));
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
				}
				if (token == 2) {
					limparTela();
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
				}
				if (token == 3) {
					switch (k) {
						case 1:

							break;
						case 2:

							break;
						case 3:

							break;
						case 4:

							break;
						default:
							break;
					}
				}
				System.out.println("Press Enter to continue...");
				System.in.read();
			} while (k != 0);
		} catch (Exception e) {
			System.out.println("");
		}

		ler.close();

	}
}
