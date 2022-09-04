package excecoes;

public class ExcecaoLimiteDeAlunos extends Exception{
    private static final long serialVersionUID = 1L;

	public ExcecaoLimiteDeAlunos(int num, String operacao){
        super("Não é possível" + operacao + " o numero de alunos pois o limite é " + num + ".");
    }
}
