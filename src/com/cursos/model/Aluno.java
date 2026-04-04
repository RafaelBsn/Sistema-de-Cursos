package com.cursos.model;

public class Aluno {

    //ATRIBUTOS
    private long id;
    private String matricula;
    private String nome;
    private String email;
    private int idade;
    private Curso curso;

    //CONSTRUTOR

    public Aluno(long id, String matricula, String nome, int idade) {

        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.idade = idade;
    }

    //GETTERS

    public long getId() {
        return id;
    }


    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    //FORMATAÇÃO TO STRING

    @Override
    public String toString() {
        return String.format("ID: %s" +
                " | Nome: %s " +
                " | Matrícula: %s " +
                " | Idade: %s " +
                " | Curso: %s ", id, nome, matricula, idade, (curso != null ? curso.getNome() : "Nenhum"));
    }
}
