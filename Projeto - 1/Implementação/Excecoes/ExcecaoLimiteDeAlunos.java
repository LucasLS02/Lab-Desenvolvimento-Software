package app.Excecoes;

public class ExcecaoLimiteDeAlunos extends Exception{
    public ExcecaoLimiteDeAlunos(int num, String operacao){
        super("Não é possível" + operacao + " o numero de alunos pois o limite é " + num + ".");
    }
}
