package Excecoes;

public class ExcecaoDisciplinaJaExistente extends Exception{
    private static final long serialVersionUID = 1L;

	public ExcecaoDisciplinaJaExistente(){
        super("Não é possíve adicionar essa disciplina pois ela já existe.");
    }
}
