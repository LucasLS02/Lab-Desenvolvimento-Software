package excecoes;

public class ExcecaoCursoJaCadastrado extends Exception{
    private static final long serialVersionUID = 1L;

	public ExcecaoCursoJaCadastrado(){
        super("Não é possível adicionar um curso pois o aluno já está matriculado em um curso.");
    }
}
