package app.Excecoes;

public class ExcecaoDisciplinaJaExistente extends Exception{
    public ExcecaoDisciplinaJaExistente(){
        super("Não é possíve adicionar essa disciplina pois ela já existe.");
    }
}
