package com.cursos.repository;
import com.cursos.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlunoRepository {

    // LISTA ALUNOS
    Map<Long, Aluno> alunos = new HashMap<>();

    // CRUD DE ALUNOS

    public void salvar(Aluno aluno) {
        alunos.put(aluno.getId(), aluno);
    }


    public List<Aluno> listar() {
        return new ArrayList<>(alunos.values());
    }

    public void remover(long id) { alunos.remove(id); }

    // BUSCA POR ID
    public Aluno buscarPorId(long id) { return alunos.get(id);}

    // VERIFICACAO DE EXISTENCIA
    public boolean existe(long id) {
        return alunos.containsKey(id);
    }
}
