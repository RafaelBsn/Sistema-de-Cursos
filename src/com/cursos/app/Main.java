package com.cursos.app;

import com.cursos.model.Aluno;
import com.cursos.model.Curso;
import com.cursos.service.CursoService;

public class Main {
    public static void main(String[] args) {
        CursoService cursoService = new CursoService();

        Aluno aluno1 = new Aluno("Rafael",11257, "user1@mail", 1);
        Aluno aluno2 = new Aluno("Júlia",11258, "user2@mail", 1);

        Curso curso1 = new Curso(1L, "JavaScript",80,"Julio");
        Curso curso2 = new Curso(2L, "MySQL",80,"Bruno");

        /*cursoService.adicionarAluno(aluno1);
        cursoService.adicionarAluno(aluno2);
        cursoService.listarAlunos();
        cursoService.atualizarAluno(11257,"João","usuario@mail");
        cursoService.removerAluno(11257);*/


        cursoService.adicionarCurso(curso1);
        cursoService.adicionarCurso(curso2);
        cursoService.listarCursos();
        cursoService.atualizarCurso(1,"Java","Mário",120);
        cursoService.removerCurso(1);


    }
}
