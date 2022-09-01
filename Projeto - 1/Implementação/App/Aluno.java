package app.App;

import app.Excecoes.ExcecaoCursoJaCadastrado;
import app.Excecoes.ExcecaoCursoNaoCadastrado;
import app.Excecoes.ExcecaoUsuarioJaCadastrado;
import app.Interfaces.Matriculavel;

public class Aluno extends Usuario implements Matriculavel {

    private String matricula;
    private Curso curso;

    Aluno(String nome, String userName, String senha) {
        ID = ID + 1;
        this.setId(ID);
        this.setNome(nome);
        this.curso = null;
        try {
            cadastrar(userName, senha);
        } catch (ExcecaoUsuarioJaCadastrado e) {
            System.err.println(e.getMessage());
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public void matricular() {
        setMatricula(this.getId() + "_" + this.getNome());
    }

    @Override
    public void cancelarMatricula() {
        setMatricula(null);
    }

    public void inscreverEmCurso(Curso curso) throws ExcecaoCursoJaCadastrado {
        if (getCurso() != null) {
            throw new ExcecaoCursoJaCadastrado();
        }
        setCurso(curso);
    }

    public void cancelarInscricaoUsuario() throws ExcecaoCursoNaoCadastrado {
        if (getCurso() == null) {
            throw new ExcecaoCursoNaoCadastrado();
        }
        setCurso(null);
    }
}
