package Pessoas;

import java.io.IOException;
import java.util.*;

import Arquivos.ManipuladorArquivo;
import TransacoesEVantagens.Vantagem;
import Usuario.Usuario_login;

public class Empresa extends Usuario_login {
	List<Vantagem> vantagens = new LinkedList<Vantagem>();

	public Empresa(String nome, String email, String cpf, String rg, String endereco, String username, String senha) {
		super(nome, email, cpf, rg, endereco, username, senha);
	}
	
	public void cadastrarVantagem(Vantagem vantagem) throws IOException {
		ManipuladorArquivo.escritor("/Users/lucas/Desktop/vantagens.txt", vantagem.toString());
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
