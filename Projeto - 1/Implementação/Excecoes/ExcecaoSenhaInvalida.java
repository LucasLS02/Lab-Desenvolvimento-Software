package Excecoes;

public class ExcecaoSenhaInvalida extends Exception{
    private static final long serialVersionUID = 1L;

	public ExcecaoSenhaInvalida(String message){
        super(message);
    }
}
