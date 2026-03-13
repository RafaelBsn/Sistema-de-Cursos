package com.cursos.model;

public class Curso {

    //ATRIBUTOS
    private String nome;
    private int cargaHoraria;
    private String professor;
    private long id;

    //CONSTRUTOR
    public Curso(long id,String nome, int cargaHoraria, String professor) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
    }

    //GETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    //FORMATAÇÃO TO STRING

    @Override
    public String toString() {
        return String.format("Curso : %s " +
                " | ID: %s " +
                " | Carga horária : %s " +
                " | Professor : %s",nome,id,cargaHoraria,professor);
    }
}
