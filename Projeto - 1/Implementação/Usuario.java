package app;

public abstract class Usuario {
	private String id;
	private String nome;
	private String username;
	private String senha;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public abstract Usuario cadastrar(String username, String senha);
	
	public abstract void login(String username, String senha);
	
	public abstract void redefinirSenha(String username, String senha);
}
