package Excecoes;

public class ExcecaoIdIncorreta extends Exception {

	private static final long serialVersionUID = 1L;

	public ExcecaoIdIncorreta() {
		super("Id digitada incorreta, não existe tal transação!");
	}
}
