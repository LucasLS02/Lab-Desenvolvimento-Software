package Pessoas;

import java.util.*;

import Excecoes.ExcecaoIdIncorreta;
import Interfaces.Usuario_visualizador;
import TransacoesEVantagens.Transacao;
import TransacoesEVantagens.Vantagem;
import Usuario.Usuario_login;

public class Aluno extends Usuario_login implements Usuario_visualizador {
	private List<Transacao> transacoes = new LinkedList<>();
	private List<Vantagem> vantagensResgatadas = new LinkedList<>();
	private int moedas;

	public Aluno(String nome, String email, String cpf, String rg, String endereco, String username, String senha) {
		super(nome, email, cpf, rg, endereco, username, senha);
		this.moedas = 0;
	}

	@Override
	public String visualizar_extrato() {
		StringBuilder resp = new StringBuilder("Extrato atual: " + this.moedas + "\nTransações:\n");

		for (Transacao t : transacoes) {
			resp.append(t.toString());
		}

		resp.append("\nVantagens:\n");

		for (Vantagem v : vantagensResgatadas) {
			resp.append(v.toString());
		}

		return resp.toString();
	}

	@Override
	public Transacao visualizar_transacao(int id_transacao) throws ExcecaoIdIncorreta {
		Transacao transacao = null;

		for (Transacao t : transacoes) {
			if (t.getId_transacao() == id_transacao) {
				transacao = t;
			}
		}

		if (transacao != null) {
			return transacao;
		} else {
			throw new ExcecaoIdIncorreta();
		}
	}

	public void resgatarVantagem(Empresa empresa, String tituloVantagem) {
		for (Vantagem v : empresa.getVantagens()) {
			if (v.getTitulo().equals(tituloVantagem)) {
				this.moedas -= v.getCusto();
				vantagensResgatadas.add(v);
			}
		}
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	public int getMoedas() {
		return moedas;
	}

	public void setMoedas(int moedas) {
		this.moedas = moedas;
	}

	@Override
	public String toString() {
		return "Aluno{" +
				"transacoes=" + transacoes +
				", moedas=" + moedas +
				"} " + super.toString();
	}
}
