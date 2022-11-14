package Pessoas;

import java.util.*;

import TransacoesEVantagens.Vantagem;
import Usuario.Usuario_login;

public class Empresa extends Usuario_login {
	List<Vantagem> vantagens = new LinkedList<Vantagem>();

	public Empresa(String nome, String email, String cpf, String rg, String endereco, String username, String senha) {
		super(nome, email, cpf, rg, endereco, username, senha);
	}
	
	public void cadastrarVantagem(Vantagem vantagem) {
		this.vantagens.add(vantagem);
	}
	
	public String listarVantagens() {
		String resp = "";
		
		for(Vantagem v : vantagens) {
			resp += v.toString();
		}
		
		return resp;
	}

}
