package app.App;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private static int ID = 0;
    private int id;
    private String nome;
    private String creditos;
    private List<Disciplina> disciplinas;

    Curso(String nome, String creditos) {
        ID = ID + 1;
        this.id = ID;
        this.nome = nome;
        this.creditos = creditos;
        this.disciplinas = new ArrayList<Disciplina>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Disciplina getDisciplina(int idDisciplina) {
        Disciplina disciplinaProcurada = null;
        for (Disciplina dis : disciplinas) {
            if (dis.getId() == idDisciplina) {
                disciplinaProcurada = dis;
            }
        }
        return disciplinaProcurada;
    }

    @Override
    public String toString() {
        return "Curso{ " +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", creditos='" + creditos + '\'' +
                ", disciplinas=" + disciplinas +
                " }";
    }
}
