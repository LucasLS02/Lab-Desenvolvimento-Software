package Pessoas;

import java.util.*;

import Excecoes.*;
import Interfaces.Usuario_visualizador;
import Transacao.Transacao;
import Usuario.Usuario_login;

public class Professor extends Usuario_login implements Usuario_visualizador {
	private List<Transacao> transacoes = new LinkedList<Transacao>();
	private String departamento;
	private double moedas;
	
	public Professor(String nome, String email, String cpf, String rg, String endereco, String username, String senha, String departamento) {
		super(nome, email, cpf, rg, endereco, username, senha);
		this.departamento = departamento;
		this.moedas = 1000;
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
	
	public void novoSemestre() {
		this.moedas += 1000;
	}
	
	public void distribuirMoedas(double moedasDoacao, Aluno aluno, String motivo) throws ExcecaoSaldoIndisponivel {
		if((this.moedas - moedasDoacao) >= 0) {
			aluno.receberMoedas(moedasDoacao, motivo);
			this.moedas -= moedasDoacao;
		} else {
			throw new ExcecaoSaldoIndisponivel();
		}
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public double getMoedas() {
		return moedas;
	}

	public void setMoedas(double moedas) {
		this.moedas = moedas;
	}
}
