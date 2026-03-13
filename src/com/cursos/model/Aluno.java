package com.cursos.model;

public class Aluno {

    //ATRIBUTOS

    private String nome;
    private int matricula;
    private String email;
    private int idade;

    //CONSTRUTOR

    public Aluno(String nome, int matricula, String email, int idade) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.idade = idade;
    }

    //GETTERS

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    //FORMATAÇÃO TO STRING

    @Override
    public String toString() {
        return String.format("Aluno: %s " +
                             " | Matrícula: %s " +
                             " | Email: %s",nome,matricula,email );
    }
}
