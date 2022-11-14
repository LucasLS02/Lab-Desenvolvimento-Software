package Arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManipuladorArquivo {

    public static String leitor(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        String conteudo = "";
        while (true) {
            if (linha != null) {
                conteudo += linha;

            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
        return conteudo;
    }

    public static void escritor(String path, String content) throws IOException {
        try{
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
            buffWrite.append(content).append("\n");
            buffWrite.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}