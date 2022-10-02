package br.com.crud.CRUD.DTO;

import javax.validation.constraints.NotBlank;
/* import javax.validation.constraints.NotNull; */

import br.com.crud.CRUD.Models.Cliente;

public class RequisicaoNovoCliente {
    @NotBlank
    private String rg;
    @NotBlank
    private String cpf;
    @NotBlank
    private String nome;
    @NotBlank
    private String endereco;

    public String getRg(){
        return rg;
    }

    public void setRg(String rg){
        this.rg = rg;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEndereco(){
        return endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public Cliente toCliente(){
        Cliente cliente = new Cliente();
        cliente.setRg(this.rg);
        cliente.setCpf(this.cpf);
        cliente.setNome(this.nome);
        cliente.setEndereco(this.endereco);
        return cliente;
    }

    public Cliente toCliente(Cliente cliente){
        cliente.setRg(this.rg);
        cliente.setCpf(this.cpf);
        cliente.setNome(this.nome);
        cliente.setEndereco(this.endereco);
        return cliente;
    }

    public void fromCliente(Cliente cliente){
        this.rg = cliente.getRg();
        this.cpf = cliente.getCpf();
        this.nome = cliente.getNome();
        this.endereco = cliente.getEndereco();
    }

    @Override
    public String toString(){
        return "Cliente{" +
                "rg=" + rg +
                ", cpf=" + cpf + 
                ", nome=" + nome + '\'' +
                ", endereco=" + endereco +
                "}";
    }
}
