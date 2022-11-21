package Pessoas;

import java.io.IOException;
import java.util.*;

import Arquivos.ManipuladorArquivo;
import TransacoesEVantagens.Vantagem;
import Usuario.Usuario_login;

public class Empresa extends Usuario_login {

	String path = "/Users/lucas/Desktop/Faculdade/4 Período/Laboratorio de desenvolvimento de software/Lab-Desenvolvimento-Software/Projeto - 4/vantagens.txt";
	private List<Vantagem> vantagens = new LinkedList<>();

	public Empresa(String nome, String email, String cpf, String rg, String endereco, String username, String senha) {
		super(nome, email, cpf, rg, endereco, username, senha);
	}

	public void zerarVantagens() throws IOException {
		ManipuladorArquivo.escritor(path, "", false);
		vantagens.clear();
	}
	
	public void cadastrarVantagem(Vantagem vantagem) throws IOException {
		ManipuladorArquivo.escritor(path, vantagem.toString(), true);
		this.vantagens.add(vantagem);
	}

	public void removerVantagem(Vantagem vantagem) throws IOException {
		vantagens.remove(vantagem);

		ManipuladorArquivo.escritor(path, "", false);

		for (Vantagem vantagen : vantagens) {
			cadastrarVantagem(vantagen);
		}
	}
	
	public String listarVantagens() throws IOException {
		return ManipuladorArquivo.leitor(path);
	}

	public List<Vantagem> getVantagens() {
		return vantagens;
	}

	public void setVantagens(List<Vantagem> vantagens) {
		this.vantagens = vantagens;
	}

	@Override
	public String toString() {
		return "Empresa{" +
				"path='" + path + '\'' +
				", vantagens=" + vantagens +
				"} " + super.toString();
	}
}
