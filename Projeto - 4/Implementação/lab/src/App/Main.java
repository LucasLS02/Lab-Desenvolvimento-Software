package App;

import Pessoas.*;
import TransacoesEVantagens.*;

import java.io.*;

public class Main {

    public static void main(String... args) throws IOException {

        Aluno aluno = new Aluno("Lucas", "lucas.lage@gjmail.com", "14562837765", "837252870",
                "rua fulano de tal, 590", "lucasls02", "123123");

        Empresa empresa = new Empresa("Empresa1", "empresa1@gmail.com", "128463209272",
                "6281574328", "rua fulano de tal, 590", "empresa1", "123123");

        Vantagem v1 = new Vantagem("Titulo1", "descrição1", 78);
        Vantagem v2 = new Vantagem("Titulo2", "descrição2", 1567);
        Vantagem v3 = new Vantagem("Titulo3", "descrição3", 1456);
        Vantagem v4 = new Vantagem("Titulo4", "descrição4", 1234);

        System.err.println("Aluno: ");
        System.err.println(aluno);
        System.err.println("Empresa: ");
        System.err.println(empresa);
        
        empresa.cadastrarVantagem(v1);
        empresa.cadastrarVantagem(v2);
        empresa.cadastrarVantagem(v3);
        empresa.cadastrarVantagem(v4);

        System.err.println("\n\nVantagens cadastradas!\n\n");
        System.err.println("Vantagens: ");
        System.err.println(empresa.listarVantagens());

        empresa.zerarVantagens();

        System.err.println("\n\nVantagens removidas!\n\n");
        System.err.println("Vantagens: ");
        System.err.println(empresa.listarVantagens());

        empresa.cadastrarVantagem(v1);
        empresa.cadastrarVantagem(v2);
        empresa.cadastrarVantagem(v3);
        empresa.cadastrarVantagem(v4);

        System.err.println("\n\nVantagens cadastradas!\n\n");
        System.err.println("Vantagens: ");
        System.err.println(empresa.listarVantagens());

        empresa.removerVantagem(v3);

        System.err.println("\n\nVantagens v3 removida!\n\n");

        System.err.println("Vantagens: ");
        System.err.println(empresa.listarVantagens());
    }
}
