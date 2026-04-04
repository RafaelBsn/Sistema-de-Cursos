package com.cursos.repository;
import com.cursos.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class   CursoRepository {

    // LISTA CURSOS
    private final Map<Long, Curso> cursos = new HashMap<>();

    // CRUD DE CURSOS
    public void salvar(Curso curso) {
        cursos.put(curso.getId(),curso);
    }

    public  Curso buscarPorId(long id) {
        return cursos.get(id);
    }

    public List<Curso> listar() {
        return new ArrayList<>(cursos.values());
    }

    public void remover(long id) {
        cursos.remove(id);
    }

    // VERIFICACAO DE EXISTENCIA
    public boolean existe(long id) {
        return cursos.containsKey(id);
    }
}

