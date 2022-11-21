package Pessoas;

import java.io.IOException;
import java.util.*;

import Excecoes.*;
import Interfaces.Usuario_visualizador;
import TransacoesEVantagens.Transacao;
import Usuario.Usuario_login;

public class Professor extends Usuario_login implements Usuario_visualizador {
	private List<Transacao> transacoes = new LinkedList<>();
	private String departamento;
	private double moedas;
	
	public Professor(String nome, String email, String cpf, String rg, String endereco, String username, String senha, String departamento) {
		super(nome, email, cpf, rg, endereco, username, senha);
		this.departamento = departamento;
		this.moedas = 1000;
	}

	@Override
	public String visualizar_extrato() {
		StringBuilder resp = new StringBuilder("Extrato atual: " + this.moedas + "\nTransações:\n");
		
		for(Transacao t : transacoes) {
			resp.append(t.toString());
		}
		
		return resp.toString();
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
	
	public void distribuirMoedas(int moedasDoacao, Aluno aluno, String motivo) throws ExcecaoSaldoIndisponivel, IOException {
		if((this.moedas - moedasDoacao) >= 0) {
			Transacao t = new Transacao(this, aluno, moedasDoacao, motivo);
			this.transacoes.add(t);
			aluno.getTransacoes().add(t);
			aluno.setMoedas(aluno.getMoedas() + moedasDoacao);
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

	@Override
	public String toString() {
		//return String.format("Professor: transacoes: %s, departamento:x//")
		return "Professor{" +
				"transacoes=" + transacoes.toString() +
				", departamento='" + departamento + '\'' +
				", moedas=" + moedas +
				"} " + super.toString();
	}

}
