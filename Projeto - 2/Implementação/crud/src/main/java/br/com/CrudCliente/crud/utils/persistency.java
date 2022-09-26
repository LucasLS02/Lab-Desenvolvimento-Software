package br.com.CrudCliente.crud.utils;

import java.io.*;

public class persistency {
    public static void write(String fileName, String content) throws IOException {
        File arquivo = new File(fileName);
        if(!arquivo.exists() && !arquivo.createNewFile()){
            throw new FileNotFoundException();
        }
        FileWriter fw = new FileWriter(arquivo, true);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(content);
            bw.newLine();
        }
        fw.close();
    }

    public static String read(String fileName) throws IOException {
        File arquivo = new File(fileName);
        StringBuilder content = new StringBuilder();
        if(arquivo.exists()){
            FileReader fr = new FileReader(arquivo);
            try (BufferedReader br = new BufferedReader(fr)) {
                while (br.ready()) {
                    content.append(br.readLine());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            fr.close();
        }
        else{
            throw new FileNotFoundException();
        }
        return content.toString();
    }
}
