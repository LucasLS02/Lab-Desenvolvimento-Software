package App;

import Pessoas.Aluno;
import Pessoas.Empresa;
import TransacoesEVantagens.Vantagem;

import java.io.IOException;

public class Main {

    public static void main(String ... args) throws IOException {

        Aluno aluno = new Aluno("Lucas", "lucas.lage@gjmail.com", "14562837765", "837252870",
                "rua fulano de tal, 590", "lucasls02", "123123");

        Empresa empresa = new Empresa("Empresa1", "empresa1@gmail.com", "128463209272",
                "6281574328", "rua fulano de tal, 590", "empresa1", "123123");

        empresa.cadastrarVantagem(new Vantagem("Tutulo", "descrição", 78));
        empresa.cadastrarVantagem(new Vantagem("Tutulo2", "descrição1", 1567));
        empresa.cadastrarVantagem(new Vantagem("Tutulo3", "descrição2", 1456));
        empresa.cadastrarVantagem(new Vantagem("Tutulo4", "descrição3", 1234));

        String vantagens = empresa.listarVantagens();

        System.err.println("Aluno: ");
        System.err.println(aluno);
        System.err.println("");

        System.err.println("Vantagens: ");
        System.err.println(vantagens);

    }
}
