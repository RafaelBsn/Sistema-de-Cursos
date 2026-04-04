package com.cursos.service;

import com.cursos.model.Aluno;
import com.cursos.model.Curso;
import com.cursos.repository.AlunoRepository;
import com.cursos.repository.CursoRepository;

import java.util.List;

public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    private int contador = 1;
    private long proximoId = 1;

    public AlunoService(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    private String gerarMatricula() {
        int ano = java.time.LocalDateTime.now().getYear();

        return ano + "-ALU-" + String.format("%04d", contador++);
    }

    // CREATE
    public void adicionarAluno(String nome, int idade) {

        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome inválido !");

        if (idade < 16) throw new IllegalArgumentException("Idade não o suficiente !");

        String matricula = gerarMatricula();

        Aluno aluno = new Aluno(proximoId++, matricula, nome, idade);
        alunoRepository.salvar(aluno);
    }

    // READ
    public List<Aluno> listarAlunos() {
        return alunoRepository.listar();
    }

    // UPDATE
    public boolean atualizarAluno(Long id, String novoNome, int novaIdade) {

        if (novoNome == null || novoNome.isBlank()) throw new IllegalArgumentException("Nome inválido !");

        if (novaIdade < 16) throw new IllegalArgumentException("Idade não o suficiente !");

        Aluno aluno = alunoRepository.buscarPorId(id);

        if (aluno == null) {
            return false;
        }

        aluno.setNome(novoNome);
        aluno.setIdade(novaIdade);
        return true;
    }

    // DELETE
    public boolean removerAluno(long id) {
        if (!alunoRepository.existe(id)) {
            return false;
        }

        alunoRepository.remover(id);
        return true;
    }

    // MATRÍCULAR ALUNO
    public boolean matricularAluno(long alunoId, long cursoId) {
        Aluno aluno = alunoRepository.buscarPorId(alunoId);
        Curso curso = cursoRepository.buscarPorId(cursoId);

        System.out.println("Buscando curso ID: " + cursoId);
        System.out.println("Cursos disponíveis:");
        cursoRepository.listar().forEach(System.out::println);

        if(aluno == null){
            System.out.println("Aluno não encontrado!");
            return false;
        }

        if(curso == null){
            System.out.println("Curso não encontrado!");
            return false;
        }

        aluno.setCurso(curso);
        return true;
    }
}
