package app;

import excecoes.ExcecaoSenhaInvalida;
import excecoes.ExcecaoUsuarioJaCadastrado;

public abstract class Usuario {

	public static int ID = 0;
	private int id;
	private int token;
	private String nome;
	private String username;
	private String senha;
	
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getToken() {
		return token;
	}

	public void setToken(int token) {
		this.token = token;
	}

	public void cadastrar(String userName, String senha, int token) throws ExcecaoUsuarioJaCadastrado {
		if(this.getUsername() != null || this.getSenha() != null){
			throw new ExcecaoUsuarioJaCadastrado();
		}
		else{
			this.setUsername(userName);
			this.setSenha(senha);
			this.setToken(token);
		}
	}

	public boolean login(String username, String senha) {
		return this.getUsername().equals(username) && this.getSenha().equals(senha);
	}

	public void redefinirSenha(String username, String senha) throws ExcecaoSenhaInvalida {
		if(login(username, senha)){
			if(this.getSenha().equals(senha)){
				throw new ExcecaoSenhaInvalida("Não é possível redefinir a senha pois ela é igual a atual.");
			}
			else{
				setSenha(senha);
			}
		}
	}

	@Override
	public String toString() {
		return "{\n" +
				"id=" + id + "," + "\n" +
				"nome='" + nome + '\'' + "," + "\n" +
				"username='" + username + '\'' + "," + "\n" +
				"senha='" + senha + '\'' + "," + "\n" +
				"token='" + token + '\'' + "\n" +
				'}';
	}

}
