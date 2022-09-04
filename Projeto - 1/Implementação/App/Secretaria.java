package app;

import java.util.*;

import excecoes.ExcecaoLimiteDeAlunos;

public class Secretaria extends Usuario {
	private List<Curso> cursos = new ArrayList<Curso>();
	
	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public void cadastrarCurso(Curso curso) {
		cursos.add(curso);;
	}
	
	public void deletarCurso(Curso curso) {
		cursos.remove(curso);
	}
	
	public void editarAluno(Aluno aluno, String novoNome, String novoUserName, String novaSenha) {
		aluno.setNome(novoNome);
		aluno.setUsername(novoUserName);
		aluno.setSenha(novaSenha);
	}
	
	public void deletarAluno(Disciplina disciplina, Aluno aluno) throws ExcecaoLimiteDeAlunos {
		disciplina.removerAluno(aluno);
	}
	
	public String gerarCurriculoSemestre() {
		String resp = "";
		int cont = 1;
		
		for(Curso c : cursos) {
			resp += "-----------------------------\n" + "Curso: " + c.toString();
			for(Disciplina d : c.getDisciplinas()) {
				resp += "\n\nDisciplina" + cont + ": " + d.toString() + "\n" + "Alunos: ";
				for(Aluno a : d.getAlunos()) {
					resp += a.toString() + "\n";
				}
				cont++;
			}
			resp += "-----------------------------";
		}
		
		return resp;
	}
	
	public String gerarCurriculoSemestre(int IDCurso) {
		int cont = 1;
		Curso curso = null;
		
		for(Curso c : cursos) {
			if(c.getId() == IDCurso) {
				curso = c;
				c = cursos.get(cursos.size() - 1);
			}
		}
		
		String resp = "-----------------------------\n" + "Curso: " + curso.toString();
		for(Disciplina d : curso.getDisciplinas()) {
			resp += "\n\nDisciplina" + cont + ": " + d.toString() + "\n" + "Alunos: ";
			for(Aluno a : d.getAlunos()) {
				resp += a.toString() + "\n";
			}
			cont++;
		}
		resp += "-----------------------------";
		
		return resp;
	}
}
