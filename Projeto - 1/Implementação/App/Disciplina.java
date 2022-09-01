package app.App;

import app.Excecoes.ExcecaoLimiteDeAlunos;

import java.util.ArrayList;
import java.util.List;

public class Disciplina  {
	private static int ID = 0;
	private int id;
	private String nome;
	private boolean ativa;
	private List<Aluno> alunos;
	private boolean obrigatoria;

	Disciplina(String nome, boolean obrigatoria){
		ID = ID + 1;
		this.id = ID;
		this.nome = nome;
		this.ativa = false;
		this.alunos = new ArrayList<>();
		this.obrigatoria = obrigatoria;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public boolean isObrigatoria() {
		return obrigatoria;
	}

	public void setObrigatoria(boolean obrigatoria) {
		this.obrigatoria = obrigatoria;
	}

	public void adicionarAluno(Aluno aluno) throws ExcecaoLimiteDeAlunos {
		if(getAlunos().size() == 60){
			throw new ExcecaoLimiteDeAlunos(60, "adicionar");
		}
		alunos.add(aluno);
	}
	
	public void removerAluno(Aluno aluno) throws ExcecaoLimiteDeAlunos {
		if(getAlunos().isEmpty()){
			throw new ExcecaoLimiteDeAlunos(0, "remover");
		}
		alunos.remove(aluno);
	}
	public Aluno getAluno(int idAluno){
		Aluno alunoProcurado = null;
		for(Aluno a : getAlunos()){
			if(a.getId() == idAluno){
				alunoProcurado = a;
			}
		}
		return alunoProcurado;
	}

	@Override
	public String toString() {
		return "Disciplina { " +
				"id=" + id +
				", nome='" + nome + '\'' +
				", ativa=" + ativa +
				", alunos=" + alunos +
				", obrigatoria=" + obrigatoria +
				" } ";
	}
}
