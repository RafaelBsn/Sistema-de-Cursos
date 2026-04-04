package com.cursos.app;

import com.cursos.repository.AlunoRepository;
import com.cursos.repository.CursoRepository;
import com.cursos.service.AlunoService;
import com.cursos.service.CursoService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CursoRepository cursoRepository = new CursoRepository();
        AlunoRepository alunoRepository = new AlunoRepository();

        CursoService cursoService = new CursoService(cursoRepository);
        AlunoService alunoService = new AlunoService(alunoRepository, cursoRepository);

        int opcao;
        do {

            System.out.println("======== MENU ========\n");
            System.out.println("1 - Adicionar curso \n" +
                    "2 - Listar cursos \n" +
                    "3 - Atualizar curso \n" +
                    "4 - Remover curso \n" +
                    "5 - Adicionar aluno \n" +
                    "6 - Matricular aluno \n" +
                    "7 - Listar alunos \n" +
                    "8 - Atualizar alunos \n" +
                    "9 - Remover aluno \n" +
                    "0 - Sair");
            System.out.println("Escolha:");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Informe o nome do curso: ");
                    String nome = scanner.nextLine();

                    System.out.println("Professor: ");
                    String professor = scanner.nextLine();

                    System.out.println("Carga horária: ");
                    int cargaHoraria = scanner.nextInt();
                    scanner.nextLine();

                    cursoService.criarCurso(nome, professor, cargaHoraria);
                    System.out.println("Curso criado com sucesso!");
                    break;

                case 2:
                    System.out.println("Lista de Cursos: ");
                    cursoService.listarCursos().forEach(System.out::println);
                    break;

                case 3:
                    System.out.println("\n--- Cursos ---");
                    cursoService.listarCursos().forEach(System.out::println);

                    System.out.println("Informe o ID do curso: ");
                    long atualizarId = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("Informe o novo nome do curso:");
                    String novoNome = scanner.nextLine();

                    System.out.println("Informe o novo professor do curso:");
                    String novoProfessor = scanner.nextLine();

                    System.out.println("Informe a nova carga do curso:");
                    int novaCarga = scanner.nextInt();
                    scanner.nextLine();

                    boolean cursoAtualizado = cursoService.atualizarCurso(atualizarId, novoNome, novoProfessor, novaCarga);
                    System.out.println(cursoAtualizado ? "Curso Atualizado com sucesso!" : "Não foi possível atualizar o curso!");
                    break;

                case 4:
                    System.out.println("\n--- Cursos ---");
                    cursoService.listarCursos().forEach(System.out::println);

                    System.out.println("Informe o ID do curso: ");
                    long removerId = scanner.nextLong();
                    scanner.nextLine();

                    boolean cursoRemovido = cursoService.removerCurso(removerId);
                    System.out.println(cursoRemovido ? "Curso removido com sucesso!" : "Não foi possível remover o curso!");
                    break;

                case 5:
                    System.out.println("Informe o nome do Aluno: ");
                    String nomeAluno = scanner.nextLine();

                    System.out.println("Informe a idade do aluno: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();

                    alunoService.adicionarAluno(nomeAluno, idade);
                    System.out.println("Aluno adicionado com sucesso !");
                    break;

                case 6:
                    System.out.println("\n--- Alunos ---");
                    alunoService.listarAlunos().forEach(System.out::println);

                    System.out.println("\n--- Cursos ---");
                    cursoService.listarCursos().forEach(System.out::println);

                    System.out.println("Informe o ID do aluno:");
                    long alunoId = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("Informe o ID do curso que deseja matricular o aluno:");
                    long cursoId = scanner.nextLong();
                    scanner.nextLine();

                    boolean matriculado = alunoService.matricularAluno(alunoId, cursoId);

                    System.out.println(matriculado ? "Aluno matrículado!" : "Não foi possível matricular o aluno!");
                    break;

                case 7:
                    System.out.println("Lista de alunos: ");
                    alunoService.listarAlunos().forEach(System.out::println);
                    break;

                case 8:
                    System.out.println("\n--- Alunos ---");
                    alunoService.listarAlunos().forEach(System.out::println);

                    System.out.println("Informe o ID do aluno:");
                    long atualizarCursoId = scanner.nextLong();
                    scanner.nextLine();

                    System.out.println("Informe o novo nome:");
                    String novoNomeAluno = scanner.nextLine();

                    System.out.println("Informe a nova idade:");
                    int novaIdade = scanner.nextInt();
                    scanner.nextLine();

                    boolean alunoAtualizado = alunoService.atualizarAluno(atualizarCursoId, novoNomeAluno, novaIdade);

                    System.out.println(alunoAtualizado ? "Aluno atualizadoo!" : "Não foi possível atualizar o aluno!");
                    break;

                case 9:
                    System.out.println("\n--- Alunos ---");
                    alunoService.listarAlunos().forEach(System.out::println);

                    System.out.println("Informe o ID do aluno:");
                    long removerAlunoId = scanner.nextLong();
                    scanner.nextLine();

                    boolean alunoRemovido = alunoService.removerAluno(removerAlunoId);

                    System.out.println(alunoRemovido ? "Aluno removido!" : "Não foi possível remover o aluno!");
                    break;
                default:
                    System.out.println("Escolha uma das opções!");
                    break;
            }
        } while (opcao != 0);
    }

}
