package Excecoes;

public class ExcecaoSaldoIndisponivel extends Exception {

	private static final long serialVersionUID = 1L;

	public ExcecaoSaldoIndisponivel() {
		super("Saldo para transação indisponível!");
	}
}
