# Sistema de Cursos

Olá! Este repositório guarda um **sistema de gestão de cursos e alunos** feito em Java, pensado para colocar a mão na massa com conceitos que aparecem no dia a dia do desenvolvimento: organizar o código em camadas, separar responsabilidades e simular um CRUD completo — tudo isso num programa de **terminal** simples de usar e de entender.

Se você está estudando Java ou revisando OO, espero que este projeto sirva como um mapa claro do que cada parte faz e por quê.

---

## O que este sistema faz?

Em poucas palavras: você cadastra **cursos** e **alunos**, consulta listagens, atualiza dados quando precisar, remove registros e ainda **matricula** um aluno em um curso escolhendo os IDs na hora.

Não é um site nem um app mobile — é um menu interativo no console, ideal para focar na lógica sem se preocupar com interface gráfica.

---

## Por que essa estrutura de pastas?

O código segue uma divisão clássica e didática:

| Camada | Pacote | Papel                                                                     |
|--------|--------|---------------------------------------------------------------------------|
| **Modelo** | `com.cursos.model` | Representa **Curso** e **Aluno** — os dados que o sistema manipula.       |
| **Repositório** | `com.cursos.repository` | Onde os dados ficam guardados na memória (usei a Collection `HashMap`).   |
| **Serviço** | `com.cursos.service` | Regras de negócio: validações, geração de matrícula, matrícular no curso. |
| **Aplicação** | `com.cursos.app` | O `Main` com o menu e a leitura do teclado (`Scanner`).                   |

Assim fica mais fácil evoluir depois: trocar o repositório em memória por banco de dados, por exemplo, sem reescrever o menu inteiro.

---

## Funcionalidades do menu

1. **Adicionar curso** — nome, professor e carga horária.  
2. **Listar cursos** — mostra todos os cursos cadastrados.  
3. **Atualizar curso** — altera nome, professor e carga horária pelo ID.  
4. **Remover curso** — remove pelo ID.  
5. **Adicionar aluno** — nome e idade; a matrícula é gerada automaticamente.  
6. **Matricular aluno** — associa um aluno a um curso (pelos IDs).  
7. **Listar alunos** — inclui em qual curso está matriculado, se houver.  
8. **Atualizar alunos** — nome e idade pelo ID.  
9. **Remover aluno** — remove pelo ID.  
0. **Sair** — encerra o programa.

---

## Regras que o código aplica

- **Curso:** nome e professor não podem ser vazios; carga horária precisa ser maior que zero.  
- **Aluno:** nome não pode ser vazio; idade mínima é **16 anos**.  
- **Matrícula:** formato `ANO-ALU-0001`, `ANO-ALU-0002` usando o ano atual do sistema.

Essas validações aparecem nos serviços (`CursoService` e `AlunoService`), que é o lugar natural para esse tipo de regra.

---

## Modelo mental dos dados

- Um **Curso** tem: ID, nome, carga horária e professor.  
- Um **Aluno** tem: ID, matrícula gerada, nome, idade e uma referência opcional ao **Curso** em que está matriculado.

Os dados vivem só na **memória** enquanto o programa roda. Ao fechar a aplicação, tudo é perdido — o que é proposital para um `projeto de estudos focado em estrutura e lógica`.

---

## Como rodar o projeto

### IntelliJ IDEA (recomendado neste repositório)

1. Abra a pasta do projeto no IntelliJ.  
2. Marque `src` como pasta de código-fonte, se ainda não estiver.  
3. Execute a classe `com.cursos.app.Main` (Run).

### Linha de comando (alternativa)

Na raiz do projeto, com o JDK no `PATH`. Em **Git Bash** ou terminal Unix:

```bash
mkdir -p out
javac -d out -encoding UTF-8 src/com/cursos/model/*.java src/com/cursos/repository/*.java src/com/cursos/service/*.java src/com/cursos/app/Main.java
java -cp out com.cursos.app.Main
```

No **PowerShell** nativo do Windows, passe a lista de arquivos ao `javac` assim (na raiz do projeto):

```powershell
New-Item -ItemType Directory -Force -Path out | Out-Null
javac -d out -encoding UTF-8 @(Get-ChildItem -Path src -Recurse -Filter *.java | ForEach-Object { $_.FullName })
java -cp out com.cursos.app.Main
```

---

## Estrutura do repositório (arquivos)

```
SistemaCursos/
├── src/
│   └── com/cursos/
│       ├── app/Main.java
│       ├── model/Aluno.java, Curso.java
│       ├── repository/AlunoRepository.java, CursoRepository.java
│       └── service/AlunoService.java, CursoService.java
├── SistemaCursos.iml
└── README.md
```

---

## Um último recado

Este é um projeto de **aprendizado**: console, dados em memória e camadas bem separadas para você enxergar o fluxo completo — do teclado até a “base” em `HashMap`. Se no futuro você quiser persistência (arquivo, JDBC, API), a ideia é que boa parte da lógica já esteja nos serviços e nos modelos, pronta para conversar com um novo tipo de repositório.

Bons estudos e bom código.
