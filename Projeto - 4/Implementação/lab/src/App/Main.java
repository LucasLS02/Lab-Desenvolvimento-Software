package App;

import Excecoes.ExcecaoSaldoIndisponivel;
import Pessoas.*;
import TransacoesEVantagens.*;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String... args) throws IOException, ExcecaoSaldoIndisponivel {

        Scanner scanner = new Scanner(System.in);
        String linha = "================================";

        Aluno aluno = new Aluno("Lucas", "lucas.lage@gjmail.com", "14562837765", "837252870",
                "rua fulano de tal, 590", "lucasls02", "123123");

        Empresa empresa = new Empresa("Empresa1", "empresa1@gmail.com", "128463209272",
                "6281574328", "rua fulano de tal, 590", "empresa1", "123123");

        Professor professor = new Professor("Breno", "breno.brandao@gjmail.com", "14562837765",
                "837252870", "rua fulano de tal, 590", "lucasls02", "123123",
                "Engenharia de Software");

        int option = 0;
        while (option != -1) {
            System.out.println(linha);
            System.out.println("O que gostaria de executar?");
            System.out.println(linha);
            System.out.println("0) Sair.");
            System.out.println("1) Empresa.");
            System.out.println("2) Aluno.");
            System.out.println("3) Professor.");
            System.out.println(linha);
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                    option = -1;
                    break;
                case 1:
<<<<<<< HEAD
                    System.out.println(linha);
=======
                    int opt = -1;
>>>>>>> 6d31840a2643809c06baa20d68db43192717b5e2
                    System.out.println("O que a empresa gostaria de executar?");
                    System.out.println(linha);
                    System.out.println("0) Sair.");
                    System.out.println("1) Cadastrar vantagem");
                    System.out.println("2) Remover vantagem");
                    System.out.println("3) Listar vantagem");
<<<<<<< HEAD
                    System.out.println(linha);
                    option = scanner.nextInt();
                    scanner.nextLine();
                    switch (option) {
                        case 0:
                            break;
                        case 1:
                            System.out.println(linha);
=======
                    System.out.println(" ");
                    opt = scanner.nextInt();
                    scanner.nextLine();
                    switch (opt) {
                        case 0 -> opt = 0;
                        case 1 -> {
                            System.out.println("");
>>>>>>> 6d31840a2643809c06baa20d68db43192717b5e2
                            System.out.println("Digite os dados para cadastrar sua vantagem: ");
                            System.out.println("Título: ");
                            String titulo = scanner.nextLine();
                            System.out.println("Descrição: ");
                            String descricao = scanner.nextLine();
                            System.out.println("Custo: ");
<<<<<<< HEAD
                            int custo = scanner.nextInt();
                            scanner.nextLine();
                            Vantagem v = new Vantagem(titulo, descricao, custo);
                            empresa.cadastrarVantagem(v);
                            break;
                        case 2:
                            System.out.println(linha);
                            System.out.println("Qual vantagem voce deseja deletar?");
                            String t = scanner.nextLine();

=======
                            String custo = scanner.nextLine();
                            Vantagem v = new Vantagem(titulo, descricao, Integer.parseInt(custo));
                            empresa.cadastrarVantagem(v);
                        }
                        case 2 -> {
                            System.out.println("Qual vantagem voce deseja deletar?");
                            String t = scanner.next();
>>>>>>> 6d31840a2643809c06baa20d68db43192717b5e2
                            List<Vantagem> vantagem_ = empresa.getVantagens();
                            Vantagem vRemovida = null;
                            for (Vantagem vantagem : vantagem_) {
                                if (vantagem.getTitulo().equals(t)) {
<<<<<<< HEAD
                                    vRemovida = vantagem;
                                }
                            }
                            if(vRemovida != null) {
                                empresa.removerVantagem(vRemovida);
                                System.out.println("Vantagem removida.");
                            } else {
                                System.out.println("Vantagem não encontrada.");
                            }
                            break;
                        case 3:
                            System.out.println(linha);
=======
                                    empresa.removerVantagem(vantagem);
                                    System.out.println("Vantagem removida.");
                                }
                            }
                        }
                        case 3 -> {
>>>>>>> 6d31840a2643809c06baa20d68db43192717b5e2
                            System.out.println("Lista de vantagens");
                            List<Vantagem> van = empresa.getVantagens();
                            for (Vantagem vantagem : van) {
                                System.out.println(vantagem.toString());
                            }
<<<<<<< HEAD
                            System.out.println(linha);
                            break;
=======
                        }
>>>>>>> 6d31840a2643809c06baa20d68db43192717b5e2
                    }
                    break;
                case 2:
                    int option_ = -1;
                    System.out.println("O que o Aluno gostaria de executar?");
                    System.out.println(linha);
                    System.out.println("0) Sair.");
                    System.out.println("1) Resgatar vantagem.");
                    System.out.println("2) Visualizar extrato.");
                    System.out.println("3) Visualizar transação.");
<<<<<<< HEAD
                    System.out.println(linha);
                    option = scanner.nextInt();
                    scanner.nextLine();
                    switch (option) {
                        case 0:
                            break;
                        case 1:
=======
                    System.out.println(" ");
                    option_ = scanner.nextInt();
                    switch (option_) {
                        case 0 -> option_ = 0;
                        case 1 -> {
>>>>>>> 6d31840a2643809c06baa20d68db43192717b5e2
                            System.out.println("Resgate de vantagem");
                            System.out.println(linha);
                            System.out.println("Qual o nome da vantagem? ");
<<<<<<< HEAD
                            String vantagem_empresa = scanner.nextLine();
                            try {
                                aluno.resgatarVantagem(empresa, vantagem_empresa);
                            } catch(ExcecaoSaldoIndisponivel e) {
                                System.out.println(e);
                            }
                            break;
                        case 2:
                            System.out.println("Extrato do aluno: ");
                            String extrto = aluno.visualizar_extrato();
                            System.out.println(extrto);
                            break;
                        case 3:
                            System.out.println("Qual o id da transação? ");
                            int id_transacao_escolhida = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println(linha);
                            List<Transacao> transacoes = aluno.getTransacoes();
                            boolean existe = false;
                            for (Transacao t : transacoes) {
                                if (t.getId_transacao() == id_transacao_escolhida) {
                                    System.out.println(t.toString());
                                    existe = true;
                                }
                            }
                            if (!existe) {
                                System.out.println("Transação informada não existe!");
=======
                            String vantagem_empresa = scanner.next();
                            aluno.resgatarVantagem(empresa, vantagem_empresa);
                        }
                        case 2 -> {
                            System.out.println("Extrato do aluno: ");
                            String extrto = aluno.visualizar_extrato();
                            System.out.println(extrto);
                        }
                        case 3 -> {
                            System.out.println("TRansações do aluno: ");
                            List<Transacao> transacoes = aluno.getTransacoes();
                            for (Transacao transacao_ : transacoes) {
                                System.out.println(transacao_.toString());
>>>>>>> 6d31840a2643809c06baa20d68db43192717b5e2
                            }
                        }
                    }
                    break;
                case 3:
                    int optio = -1;
                    System.out.println("O que gostaria de executar?");
                    System.out.println(linha);
                    System.out.println("0) Sair.");
                    System.out.println("1) Destribuir moeda.");
                    System.out.println("2) Visualizar extrato.");
                    System.out.println("3) Visualizar transação.");
<<<<<<< HEAD
                    System.out.println(linha);
                    option = scanner.nextInt();
                    scanner.nextLine();
                    switch (option) {
                        case 0:
                            break;
                        case 1:
=======
                    System.out.println(" ");
                    optio = scanner.nextInt();
                    switch (optio) {
                        case 0 -> optio = 0;
                        case 1 -> {
>>>>>>> 6d31840a2643809c06baa20d68db43192717b5e2
                            System.out.println("Destribuir moedas");
                            System.out.println(linha);
                            System.out.println("Quantas moedas gostaria de destribuir?");
                            int quantMoedas = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Qual o motivo?");
                            String motivo = scanner.nextLine();
                            professor.distribuirMoedas(quantMoedas, aluno, motivo);
                        }
                        case 2 -> {
                            System.out.println("Extrato do professor: ");
                            String extrto = professor.visualizar_extrato();
                            System.out.println(extrto);
<<<<<<< HEAD
                            break;
                        case 3:
                            System.out.println("Qual o id da transação? ");
                            int id_transacao_escolhida = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println(linha);
                            List<Transacao> transacoes = professor.getTransacoes();
                            boolean existe = false;
                            for (Transacao t : transacoes) {
                                if (t.getId_transacao() == id_transacao_escolhida) {
                                    System.out.println(t.toString());
                                    existe = true;
                                }
                            }
                            if (!existe) {
                                System.out.println("Transação informada não existe!");
=======
                        }
                        case 3 -> {
                            System.out.println("TRansações do professor: ");
                            List<Transacao> transacoes = professor.getTransacoes();
                            for (Transacao transacao_ : transacoes) {
                                System.out.println(transacao_.toString());
>>>>>>> 6d31840a2643809c06baa20d68db43192717b5e2
                            }
                        }
                    }
                    break;
            }
        }
        scanner.close();
    }
}
