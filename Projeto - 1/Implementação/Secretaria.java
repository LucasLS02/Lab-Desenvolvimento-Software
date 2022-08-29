package app;

import java.util.*;

public class Secretaria extends Usuario{

	@Override
	public Usuario cadastrar(String username, String senha) {
		return null;
	}

	@Override
	public void login(String username, String senha) {
		
	}

	@Override
	public void redefinirSenha(String username, String senha) {
		
	}

	public void gerarRelatorio(String cursoId) {
		
	}
	
	public void matricularAluno(String cursoId, String alunoId) {
		
	}
	
	public List<Aluno> listarAlunos() {
		return null;
	}
	
	public List<Aluno> listarAlunos(String alunoId) {
		return null;
	}
	
	public void editarDadosAlunos(Aluno aluno, String nome, String userName, String senha) {
		
	}
	
	public void deletarAlunos(String alunoId) {
		
	}
}
