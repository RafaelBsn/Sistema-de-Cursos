package com.cursos.service;
import com.cursos.model.Curso;
import com.cursos.repository.CursoRepository;

import java.util.List;


public class CursoService {

    private CursoRepository repository = new CursoRepository();
    private long proximoId = 1;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public void criarCurso(String nome, String professor, int cargaHoraria) {

        // VALIDAÇÕES
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido !");
        }

        if (professor == null || professor.isBlank()) {
            throw new IllegalArgumentException("Nome inválido !");
        }
        if (cargaHoraria <= 0 ) {
            throw new IllegalArgumentException("Carga horária inválida !");
        }


        // CRIAÇÃO DO CURSO
        Curso curso = new Curso(proximoId++, nome, cargaHoraria, professor);

        // SALVANDO NO REPOSITORY
        repository.salvar(curso);

    }

    // READ
    public List<Curso> listarCursos() {
        return repository.listar();
    }

    // UPDATE
    public boolean atualizarCurso(long id, String nome, String professor, int cargaHoraria) {

        Curso curso = repository.buscarPorId(id);

        // VALIDAÇÃO
        if (curso == null) {
            return false;
        }

        curso.setNome(nome);
        curso.setProfessor(professor);
        curso.setCargaHoraria(cargaHoraria);
        return true;
    }

    // DELETE
    public boolean removerCurso(long id) {

        if (!repository.existe(id)) {
            return false;
        }

        repository.remover(id);
        return true;
    }

    // FIND BY ID
    public Curso buscarCurso(long id) {
        return repository.buscarPorId(id);
    }

}