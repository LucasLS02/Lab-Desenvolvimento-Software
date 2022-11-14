package Pessoas;

import java.util.*;

import Excecoes.ExcecaoIdIncorreta;
import Interfaces.Usuario_visualizador;
import TransacoesEVantagens.Transacao;
import Usuario.Usuario_login;

public class Aluno extends Usuario_login implements Usuario_visualizador {
	private List<Transacao> transacoes = new LinkedList<Transacao>();
	private int moedas;
	
	public Aluno(String nome, String email, String cpf, String rg, String endereco, String username, String senha) {
		super(nome, email, cpf, rg, endereco, username, senha);
		this.moedas = 0;
	}

	@Override
	public String visualizar_extrato() {
		String resp = "Extrato atual: " + this.moedas + "\nTransações:\n";
		
		for(Transacao t : transacoes) {
			resp += t.toString();
		}
		
		return resp;
	}

	@Override
	public Transacao visualizar_transacao(int id_transacao) throws ExcecaoIdIncorreta {
		Transacao transacao = null;
		
		for(Transacao t : transacoes) {
			if(t.getId_transacao() == id_transacao) {
				transacao = t;
			}
		}
		
		if(transacao != null) {
			return transacao;
		} else {
			throw new ExcecaoIdIncorreta();
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
}
