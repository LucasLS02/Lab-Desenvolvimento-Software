package Implementação;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static Implementação.utils.persistency.read;
import static Implementação.utils.persistency.write;

public class usuario {
    public static final String persitencyFile = "usuario.txt";
    private String nome;
    private String username;
    private String senha;

    usuario() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof usuario usuario)) return false;
        return nome.equals(usuario.nome) && username.equals(usuario.username) && senha.equals(usuario.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, username, senha);
    }

    @Override
    public String toString() {
        return "usuario{" +
                "nome='" + nome + '\'' +
                ", username='" + username + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    public void create(String nome, String username, String senha) {
        setNome(nome);
        setUsername(username);
        setSenha(senha);
        String content = getNome() + "," + getUsername() + "," + getSenha() + ";";
        try{
            write(persitencyFile, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void create(String nome, String username, String senha, String filename) {
        setNome(nome);
        setUsername(username);
        setSenha(senha);
        String content = getNome() + "," + getUsername() + "," + getSenha() + ";";
        try{
            write(filename, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String list() {
        String users;
        try {
            users = read(persitencyFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public void edit(String username, String content) {
        remove(username);
        String[] userInfo = content.split(",");
        create(userInfo[0], userInfo[1], userInfo[2]);
    }

    public void remove(String username) {
        String users = list();
        String[] a = users.split(";");
        List<String> x = new ArrayList<>();
        for(String user : a){
            if(!user.split(",")[1].equals(username)){
                x.add(user);
            }
        }
        for(String user : x){
            String[] userInfo = user.split(",");
            create(userInfo[0], userInfo[1], userInfo[2], "temp.txt");
        }
        new File(persitencyFile).delete();
        new File("temp.txt").renameTo(new File(persitencyFile));
    }
}
