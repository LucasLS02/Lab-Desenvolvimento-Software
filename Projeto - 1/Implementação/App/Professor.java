package app;

import excecoes.ExcecaoDisciplinaJaExistente;
import excecoes.ExcecaoUsuarioJaCadastrado;
import interfaces.Matriculavel;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario implements Matriculavel {

    private String matricula;
    private List<Disciplina> disciplinas;

    Professor(String nome, String userName, String senha) {
        ID = ID + 1;
        this.setId(ID);
        this.setNome(nome);
        matricular();
        this.disciplinas = new ArrayList<Disciplina>();
        try {
            cadastrar(userName, senha, 2);
        } catch (ExcecaoUsuarioJaCadastrado e) {
            System.err.println(e.getMessage());
        }
    }

    public String getMatricula() {
        return matricula;
    }

    private void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<Aluno> listarAlunos(int idDisciplina) {
        List<Aluno>listaAlunos = null;
        for(Disciplina dis : disciplinas){
            if(dis.getId() == idDisciplina){
                listaAlunos = dis.getAlunos();
            }
        }
        return listaAlunos;
    }

    @Override
    public void matricular() {
        setMatricula(this.getId() + "_" + this.getNome() + "_Professor");
    }

    @Override
    public void cancelarMatricula() {
        setMatricula(null);
    }

    public void adicionarDisciplina(Disciplina disciplina) throws ExcecaoDisciplinaJaExistente {
        if (disciplinas.contains(disciplina)) {
            throw new ExcecaoDisciplinaJaExistente();
        }
        disciplinas.add(disciplina);
    }

    public void removerDisciplina(int idDisciplina) {
        for (Disciplina dis : disciplinas) {
            if (dis.getId() == idDisciplina) {
                disciplinas.remove(dis.getId());
            }
        }
    }

    @Override
    public String toString() {
        return "{ " +
                "matricula='" + matricula + '\'' +
                ", disciplinas=" + disciplinas +
                " } " + super.toString();
    }
}
