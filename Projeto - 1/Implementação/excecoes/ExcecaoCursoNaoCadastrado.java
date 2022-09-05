package excecoes;

public class ExcecaoCursoNaoCadastrado extends Exception{
    private static final long serialVersionUID = 1L;

	public ExcecaoCursoNaoCadastrado(){
        super("Não é possível cancelar a inscricao do aluno pois ele não está associado a um curso.");
    }
}
