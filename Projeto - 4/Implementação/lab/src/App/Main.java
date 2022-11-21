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

        Aluno aluno = new Aluno("Lucas", "lucas.lage@gjmail.com", "14562837765", "837252870",
                "rua fulano de tal, 590", "lucasls02", "123123");

        Empresa empresa = new Empresa("Empresa1", "empresa1@gmail.com", "128463209272",
                "6281574328", "rua fulano de tal, 590", "empresa1", "123123");

        Professor professor = new Professor("Breno", "breno.brandao@gjmail.com", "14562837765",
                "837252870", "rua fulano de tal, 590", "lucasls02", "123123",
                "Engenharia de Software");

        int option = 0;
        while(option != -1){
            System.out.println("O que gostaria de executar?");
            System.out.println(" ");
            System.out.println("0) Sair.");
            System.out.println("1) Empresa.");
            System.out.println("2) Aluno.");
            System.out.println("3) Professor.");
            System.out.println(" ");
            option = scanner.nextInt();
            switch (option){
                case 0:
                    option = -1;
                    break;
                case 1:
                    System.out.println("O que a empresa gostaria de executar?");
                    System.out.println(" ");
                    System.out.println("0) Sair.");
                    System.out.println("1) Cadastrar vantagem");
                    System.out.println("2) Remover vantagem");
                    System.out.println("3) Listar vantagem");
                    System.out.println(" ");
                    option = scanner.nextInt();
                    switch (option){
                        case 0:
                            break;
                        case 1:
                            System.out.println("");
                            System.out.println("Digite os dados para cadastrar sua vantagem: ");
                            System.out.println("Título: ");
                            String titulo = scanner.next();
                            System.out.println("Descrição: ");
                            String descricao = scanner.next();
                            System.out.println("Custo: ");
                            int custo = scanner.nextInt();
                            Vantagem v = new Vantagem(titulo, descricao, custo);
                            empresa.cadastrarVantagem(v);
                            break;
                        case 2:
                            System.out.println("Qual vantagem voce deseja deletar?");
                            String t = scanner.next();

                            List<Vantagem> vantagem_ = empresa.getVantagens();
                            for (Vantagem vantagem : vantagem_) {
                                if(vantagem.getTitulo().equals(t)){
                                    empresa.removerVantagem(vantagem);
                                    System.out.println("Vantagem removida.");
                                }
                            }
                            break;
                        case 3:
                            System.out.println("Lista de vantagens");
                            List<Vantagem> van = empresa.getVantagens();

                            for (Vantagem vantagem : van) {
                                System.out.println(vantagem.toString());
                            }
                            break;
                    }
                case 2:
                    System.out.println("O que o Aluno gostaria de executar?");
                    System.out.println(" ");
                    System.out.println("0) Sair.");
                    System.out.println("1) Resgatar vantagem.");
                    System.out.println("2) Visualizar extrato.");
                    System.out.println("3) Visualizar transação.");
                    System.out.println(" ");
                    option = scanner.nextInt();
                    switch (option) {
                        case 0:
                            break;
                        case 1:
                            System.out.println("Resgate de vantagem");
                            System.out.println(" ");
                            System.out.println("Qual o nome da vantagem? ");
                            String vantagem_empresa = scanner.next();
                            aluno.resgatarVantagem(empresa, vantagem_empresa);
                            break;
                        case 2:
                            System.out.println("Extrato do aluno: ");
                            String extrto = aluno.visualizar_extrato();
                            System.out.println(extrto);
                            break;
                        case 3:
                            System.out.println("TRansações do aluno: ");
                            List<Transacao> transacoes = aluno.getTransacoes();
                            for (Transacao transacao_ : transacoes){
                                System.out.println(transacao_.toString());
                            }
                            break;
                    }

                case 3:
                    System.out.println("O que gostaria de executar?");
                    System.out.println(" ");
                    System.out.println("0) Sair.");
                    System.out.println("1) Destribuir moeda.");
                    System.out.println("2) Visualizar extrato.");
                    System.out.println("3) Visualizar transação.");
                    System.out.println(" ");
                    option = scanner.nextInt();
                    switch (option) {
                        case 0:
                            break;
                        case 1:
                            System.out.println("Destribuir moedas");
                            System.out.println(" ");
                            System.out.println("Quantas moedas gostaria de destribuir?");
                            int quantMoedas = scanner.nextInt();
                            System.out.println("Qual o motivo?");
                            String motivo = scanner.next();
                            professor.distribuirMoedas(quantMoedas, aluno, motivo);
                            break;
                        case 2:
                            System.out.println("Extrato do professor: ");
                            String extrto = professor.visualizar_extrato();
                            System.out.println(extrto);
                            break;
                        case 3:
                            System.out.println("TRansações do professor: ");
                            List<Transacao> transacoes = professor.getTransacoes();
                            for (Transacao transacao_ : transacoes){
                                System.out.println(transacao_.toString());
                            }
                            break;
                    }
            }

        }
    }
}
