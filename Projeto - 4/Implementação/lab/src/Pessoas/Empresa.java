package Pessoas;

import java.io.IOException;
import java.util.*;

import Arquivos.ManipuladorArquivo;
import TransacoesEVantagens.Vantagem;
import Usuario.Usuario_login;

public class Empresa extends Usuario_login {
	private List<Vantagem> vantagens = new LinkedList<Vantagem>();

	public Empresa(String nome, String email, String cpf, String rg, String endereco, String username, String senha) {
		super(nome, email, cpf, rg, endereco, username, senha);
	}

	public void zerarVantagens() throws IOException {
		ManipuladorArquivo.escritor("../Lab_de_Desenvolvimento/Projeto - 4/vantagens.txt", "", false);
		vantagens.clear();
	}
	
	public void cadastrarVantagem(Vantagem vantagem) throws IOException {
		ManipuladorArquivo.escritor("../Lab_de_Desenvolvimento/Projeto - 4/vantagens.txt", vantagem.toString(), true);
		this.vantagens.add(vantagem);
	}

	public void removerVantagem(Vantagem vantagem) throws IOException {
		vantagens.remove(vantagem);
		int tamanhoAtual = vantagens.size();

		ManipuladorArquivo.escritor("../Lab_de_Desenvolvimento/Projeto - 4/vantagens.txt", "", false);
		
		for(int i=0; i<tamanhoAtual; i++) {
			cadastrarVantagem(vantagens.get(i));
		}
	}
	
	public String listarVantagens() throws IOException {
		return ManipuladorArquivo.leitor("../Lab_de_Desenvolvimento/Projeto - 4/vantagens.txt");
	}

	public List<Vantagem> getVantagens() {
		return vantagens;
	}

	public void setVantagens(List<Vantagem> vantagens) {
		this.vantagens = vantagens;
	}
	
	@Override
	public String toString() {
		return  super.toString() +
				"Empresa{" +
				"vantagens=" + vantagens+
				"} ";
	}

}
