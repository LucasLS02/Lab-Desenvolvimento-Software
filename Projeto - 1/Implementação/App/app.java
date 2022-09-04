package app;

import java.util.*;

public class app {
     public static void main(String args[]){
	     Disciplina dis = new Disciplina("Disciplina", true);
	     System.out.println(dis);
	     Secretaria s = new Secretaria();
	     Curso c0 = new Curso("matematica", "1");
	     Curso c1 = new Curso("matematica", "2");
	     Curso c2 = new Curso("matematica", "3");
	     
	     s.cadastrarCurso(c0);
	     s.cadastrarCurso(c1);
	     s.cadastrarCurso(c2);
	     List<Curso> cursos = s.getCursos();
	     
	     for(Curso x : cursos) {
	    	 System.out.println(x.getNome() + " " + x.getId());
	     }
	     
	     s.deletarCurso(c1);
	     
	     System.out.println("\n");
	     
	     for(Curso x : cursos) {
	    	 System.out.println(x.getNome() + " " + x.getId());
	     }
     }
}
