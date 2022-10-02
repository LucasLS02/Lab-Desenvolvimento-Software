package br.com.crud.CRUD.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.crud.CRUD.Models.Veiculo;

public class RequisicaoNovoVeiculo {
    @NotNull
    private int ano;
    @NotBlank
    private String marca;
    @NotBlank
    private String modelo;
    @NotBlank
    private String placa;

    public int getAno(){
        return ano;
    }

    public void setAno(int ano){
        this.ano = ano;
    }

    public String getMarca(){
        return marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getModelo(){
        return modelo;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public String getPlaca(){
        return placa;
    }

    public void setPlaca(String placa){
        this.placa = placa;
    }

    public Veiculo toVeiculo(){
        Veiculo veiculo = new Veiculo();
        veiculo.setAno(this.ano);
        veiculo.setMarca(this.marca);
        veiculo.setModelo(this.modelo);
        veiculo.setPlaca(this.placa);
        return veiculo;
    }

    public Veiculo toVeiculo(Veiculo veiculo){
        veiculo.setAno(this.ano);
        veiculo.setMarca(this.marca);
        veiculo.setModelo(this.modelo);
        veiculo.setPlaca(this.placa);
        return veiculo;
    }

    public void fromVeiculo(Veiculo veiculo){
        this.ano = veiculo.getAno();
        this.marca = veiculo.getMarca();
        this.modelo = veiculo.getModelo();
        this.placa = veiculo.getPlaca();
    }

    @Override
    public String toString(){
        return "Veiculo{" +
                "ano=" + ano +
                ", marca=" + marca + 
                ", modelo=" + modelo + '\'' +
                ", placa=" + placa +
                "}";
    }
}
