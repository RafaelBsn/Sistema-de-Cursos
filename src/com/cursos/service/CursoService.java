package com.cursos.service;
import com.cursos.model.*;

import java.util.ArrayList;
import java.util.List;

public class CursoService {

    //LISTA DOS OBJETOS ALUNOS E CURSOS

    private List<Aluno> alunos = new ArrayList<>();
    private List<Curso> cursos = new ArrayList<>();

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    //CRUD DE ALUNOS

    //ADICIONAR ALUNOS À LISTA
    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }
    //LISTAR OS ALUNOS
    public void listarAlunos() {

        System.out.println("Alunos:");
        alunos.forEach(System.out::println);
    }
    //ATUALIZAR  ALUNO
    public void atualizarAluno(int matricula, String novoNome, String novoEmail) {

         alunos.stream()
              .filter(aluno -> aluno.getMatricula() == matricula)
              .findFirst()
              .ifPresentOrElse(
                      aluno -> {
                          aluno.setNome(novoNome);
                          aluno.setEmail(novoEmail);
                          System.out.println(System.lineSeparator() + "Aluno atualizado!");
                          System.out.println(System.lineSeparator() + "Lista de alunos atualizada :");
                          listarAlunos();
                      },
                      () -> System.out.println("Aluno não atualizado!")
              );
    }
    //REMOVER ALUNO
    public void removerAluno(int matricula) {

        boolean removido = alunos.removeIf(aluno -> aluno.getMatricula() == matricula);

        if (removido) {
            System.out.println(System.lineSeparator() + "Aluno removido !");
            System.out.println(System.lineSeparator() + "Lista de alunos atualizada :");
            listarAlunos();
        }else {
            System.out.println("Aluno não encontrado!");
        }
    }
    //================================================================================================

    //CRUD DE CURSOS

    //ADICIONAR CURSOS À LISTA
    public void adicionarCurso(Curso curso) {
        cursos.add(curso);
    }
    //LISTAR OS CURSOS
    public void listarCursos() {

        System.out.println(System.lineSeparator() + "Cursos :");
        cursos.forEach(System.out::println);
    }
    //ATUALIZAR CURSO
    public void atualizarCurso(long id, String novoNome, String novoProfessor, int novaCargaHoraria) {

        cursos.stream()
                .filter(curso -> curso.getId() == id)
                .findFirst()
                .ifPresentOrElse(
                        curso -> {
                            curso.setNome(novoNome);
                            curso.setProfessor(novoProfessor);
                            curso.setCargaHoraria(novaCargaHoraria);
                            System.out.println(System.lineSeparator() + "Curso atualizado!");
                            System.out.println(System.lineSeparator() + "Lista de cursos atualizada :");
                            listarCursos();
                        },
                        () -> System.out.println("Curso não atualizado!")
                );
    }
    //REMOVER CURSO
    public void removerCurso(long id) {

        boolean removido = cursos.removeIf(curso -> curso.getId() == id);

        if (removido) {
            System.out.println(System.lineSeparator() + "Curso removido !");
            System.out.println(System.lineSeparator() + "Lista de Cursos atualizada :");
            listarCursos();
        }else {
            System.out.println("Curso não encontrado!");
        }
    }
}
