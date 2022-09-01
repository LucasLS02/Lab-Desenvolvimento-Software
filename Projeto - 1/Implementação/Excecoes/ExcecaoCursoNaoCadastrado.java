package app.Excecoes;

public class ExcecaoCursoNaoCadastrado extends Exception{
    public ExcecaoCursoNaoCadastrado(){
        super("Não é possível cancelar a inscricao do aluno pois ele não está associado a um curso.");
    }
}
