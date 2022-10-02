package br.com.crud.CRUD.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.crud.CRUD.Models.Usuario;

public class RequisicaoNovoUsuario {
    @NotBlank
    @NotNull
    private String nome;
    @NotBlank
    private String user;
    @NotBlank
    private String senha;

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getUser(){
        return user;
    }

    public void setUser(String user){
        this.user = user;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public Usuario toUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNome(this.nome);
        usuario.setUser(this.user);
        usuario.setSenha(this.senha);
        return usuario;
    }

    public Usuario toUsuario(Usuario usuario){
        usuario.setNome(this.nome);
        usuario.setUser(this.user);
        usuario.setSenha(this.senha);
        return usuario;
    }

    public void fromUsuario(Usuario usuario){
        this.nome = usuario.getNome();
        this.user = usuario.getUser();
        this.senha = usuario.getSenha();
    }

    @Override
    public String toString(){
        return "Usuario{" +
                "nome=" + nome + '\'' +
                ", userName=" + user +
                ", senha=" + senha +
                "}";
    }
}
