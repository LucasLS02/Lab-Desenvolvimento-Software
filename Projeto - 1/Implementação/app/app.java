package app;

import java.io.*;
import java.util.*;

public class app {
	List<Usuario> usuarios = new ArrayList<Usuario>();
	
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
		if(token == 1) {
			limparTela();
			System.out.println("Menu Secretária:\n");
	        System.out.println("1 - Cadastrar curso");
	        System.out.println("2 - Deletar curso");
	        System.out.println("3 - Editar dados de um aluno");
	        System.out.println("4 - Deletar dados de um aluno");
	        System.out.println("5 - Gerar currículo");
	        System.out.println("0 - Sair e salvar");
		}
		if(token == 2) {
			limparTela();
			System.out.println("Menu Professor:\n");
			System.out.println("1 - Realizar matrícula");
	        System.out.println("2 - Cancelar matrícula");
	        System.out.println("3 - Adicionar disciplina");
	        System.out.println("4 - Remover disciplina");
	        System.out.println("0 - sair e salvar");			
		}
		if(token == 3) {			
			limparTela();
			System.out.println("Menu Aluno:\n");
			System.out.println("1 - Realizar matrícula");
			System.out.println("2 - Cancelar matrícula");
			System.out.println("3 - Inscrever em curso");
			System.out.println("4 - Cancelar inscrição de usuário");
			System.out.println("0 - sair e salvar");
		}
    }
	
	public static Usuario realizarLogin() {
		Scanner ler = new Scanner(System.in);
		String userName = "";
		String senha = "";
		int IDArq = 0;
		String nomeArq = "";
		String userNameArq = "";
		String senhaArq = "";
		int token = 0;
		boolean login = false;
		try {
			while(!login) {
				Scanner in = new Scanner(new FileReader("teste.txt"));
				
				System.out.println("Favor informar seus dados:\nUser Name: ");
				userName = ler.nextLine();
				System.out.println("\nSenha: ");
				senha = ler.nextLine();
				
				int i = 0;
				while (in.hasNextLine()) {
					String line = in.nextLine();
					if(line.charAt(0)=='[') {
						IDArq = in.nextInt();
						line = in.nextLine();
						nomeArq = in.nextLine();
						userNameArq = in.nextLine();
						senhaArq = in.nextLine();
						i = in.nextInt();
						line = in.nextLine();
						line = in.nextLine();
					}
					if((userName.compareTo(userNameArq) == 0) && (senha.compareTo(senhaArq) == 0)) {
						login = true;
						token = i;
					}
				}
				if(!login) {
					System.out.println("User Name ou Senha inválidos! Tente novamente!");
				} else {
					System.out.println("Bem vindo(a) " + userName + "!");
				}
			}
		} catch (Exception e) {
            System.out.println("");
        }
		
		if(token==1) {
			return new Secretaria(IDArq, nomeArq, userNameArq, senhaArq);
		} else if(token==2) {
			return new Professor(IDArq, nomeArq, userNameArq, senhaArq);
		} else {
			return new Aluno(IDArq, nomeArq, userNameArq, senhaArq);
		}
	}

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        try {
        	Usuario u1 = new Secretaria("Matheus", "a", "1");
        	Usuario u2 = new Professor("Matheus", "a", "2");
        	Usuario u3 = new Aluno("Matheus", "a", "3");
        	
        	adicionarUsuario(u1, false);
        	adicionarUsuario(u2, true);
        	adicionarUsuario(u3, true);
        	
        	int x;
        	do {
	        	System.out.println("Você possui cadastro?\n0- SIM\n1- NAO");
	        	x = ler.nextInt();
	        	ler.nextLine();
	        	if(x==1) {
	        		System.out.println("Digite seu nome:");
	        		String nome = ler.nextLine();
	        		System.out.println("Digite um user name:");
	        		String userName = ler.nextLine();
	        		System.out.println("Digite uma senha:");
	        		String senha = ler.nextLine();
	        		int i; 
	        		do {
	        			System.out.println("O que você é?\n0- Secretario(a)\n1- Professor(a)\n2- Aluno(a)");
	        			i = ler.nextInt();
		        		if(i==0) {
		        			adicionarUsuario(new Secretaria(nome, userName, senha), true);
		        		} else if(i==1) {
		        			adicionarUsuario(new Professor(nome, userName, senha), true);
		        		} else if (i==2){
		        			adicionarUsuario(new Aluno(nome, userName, senha), true);
		        		}
	        		} while(i < 0 || i > 2);
	        	}
        	} while(x > 1 || x < 0);
        	
        	int k;
        	
        	Usuario u = realizarLogin();
        	
            do {
            	
            	printMenu(u.getToken());
            	
            	Secretaria s = null;
            	Professor p = null;
            	Aluno a = null;
            	if(u.getToken()==1) {
            		s = (Secretaria) u;
            	} else if(u.getToken()==2) {
            		p = (Professor) u;
            	} else {
            		a = (Aluno) u;
            	}
            	
                k = ler.nextInt();
                ler.nextLine();
                
                if(u.getToken() == 1) {
                	switch (k) {
	                    case 1:
	                    	System.out.println("Digite o nome do curso que deseja cadastrar:");
                            String nomeCurso = ler.nextLine();
                            System.out.println("Digite os créditos do curso:");
                            String creditosCurso = ler.nextLine();
                            Curso c = new Curso(nomeCurso, creditosCurso);
                            s.cadastrarCurso(c);
                            System.out.println("Curso cadastrado com sucesso!");
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
	                    	if(k!=0) {
	                    		System.out.println("ERRO: Opção não encontrada!");
	                    	}
	                        break;
                	}
        		}
        		if(u.getToken() == 2) {
        			limparTela();
                	switch (k) {
	                    case 1:
	                    	p.matricular();
	                    	System.out.println("Matrícula realizada com sucesso!");
	                        break;
	                    case 2:
	                    	p.cancelarMatricula();
	                    	System.out.println("Matrícula cancelada com sucesso!");
	                        break;
	                    case 3:
	                    	System.out.println("Digite o nome da disciplina que deseja adicionar:");
                            String nomeDisciplina = ler.nextLine();
                            System.out.println("Essa disciplina é obrigatória?\n0- SIM\n1- NAO");
                            int escolha = ler.nextInt();
                            boolean obrigatoria = false;
                            if(escolha==0) {
                            	obrigatoria = true;
                            }
                            Disciplina d = new Disciplina(nomeDisciplina, obrigatoria);
                            p.adicionarDisciplina(d);
                            System.out.println("Disciplina cadastrada com sucesso!");
                            System.out.println("ID da disciplina: " + d.getId());
	                        break;
	                    case 4:
	                    	System.out.println("Digite o ID da disciplina que deseja remover");
                            int id = ler.nextInt();
                            ler.nextLine();
	                    	p.removerDisciplina(id);
	                    	System.out.println("Disciplina removida com sucesso!");
	                        break;
	                    default:
	                    	if(k!=0) {
	                    		System.out.println("ERRO: Opção não encontrada!");
	                    	}
	                        break;
                	}		
        		}
        		if(u.getToken() == 3) {			
                	switch (k) {
	                	case 1:
	                        a.matricular();
	                        System.out.println("Matrícula Efetuada com sucesso!");
	                        break;
	                    case 2:
	                        a.cancelarMatricula();
	                        System.out.println("Matrícula cancelada com sucesso!");
	                        break;
	                    case 3:
	                        System.out.println("Digite o nome do curso que deseja cadastrar:");
	                        String nomeCurso = ler.nextLine();
	                        System.out.println("Digite os créditos do curso:");
	                        String creditosCurso = ler.nextLine();
	                        Curso c = new Curso(nomeCurso, creditosCurso);
	                        a.inscreverEmCurso(c);
	                        System.out.println("Curso cadastrado com sucesso!");
	                        break;
	                    case 4:
	                        a.cancelarInscricaoUsuario();
	                        System.out.println("Inscrição cancelada com sucesso!");
	                        break;
	                    default:
	                    	if(k!=0) {
	                    		System.out.println("ERRO: Opção não encontrada!");
	                    	}
	                        break;
                	}
        		}
                System.out.println("\nPress Enter to continue...");
                System.in.read();
            } while (k != 0);
            System.out.println("Tchau tchau!");
        } catch (Exception e) {
            System.out.println("");
        }

        ler.close();

    }
}
