package TransacoesEVantagens;

public class Vantagem {
	private String titulo;
	private String descricao;
	private int custo;
	
	public Vantagem(String titulo, String descricao, int custo) {
		setTitulo(titulo);
		setDescricao(descricao);
		setCusto(custo);
	}

	@Override
	public String toString() {
		return "Vantagem{" +
				"titulo='" + titulo + '\'' +
				", descricao='" + descricao + '\'' +
				", custo=" + custo +
				'}';
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCusto() {
		return custo;
	}

	public void setCusto(int custo) {
		this.custo = custo;
	}
	
	
}
