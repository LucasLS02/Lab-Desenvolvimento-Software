package app.Excecoes;

public class ExcecaoCursoJaCadastrado extends Exception{
    public ExcecaoCursoJaCadastrado(){
        super("Não é possível adicionar um curso pois o aluno já está matriculado em um curso.");
    }
}
