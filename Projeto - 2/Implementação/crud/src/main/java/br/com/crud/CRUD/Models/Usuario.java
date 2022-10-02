package br.com.crud.CRUD.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String user;
    private String senha;

    public Usuario(){}

    public Usuario(String nome, String user, String senha){
        this.nome = nome;
        this.user = user;
        this.senha = senha;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

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
    @Override
    public String toString(){
        return "Usuario{" +
                "id=" + id +
                ", nome=" + nome + '\'' +
                ", userName=" + user +
                ", senha=" + senha +
                "}";
    }

}

