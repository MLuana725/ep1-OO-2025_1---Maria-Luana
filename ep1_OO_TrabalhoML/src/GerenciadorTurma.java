import java.util.List;
import java.util.Scanner;

public class GerenciadorTurma {
    public static void novaTurma(Scanner scanner){
        String resposta = "sim";
        
        
        while (resposta.equalsIgnoreCase("sim")) {
         System.out.println("Cadastro de Turmas\nInformações da disciplina:");
        
         System.out.print("Digite o nome da Disciplina:");
         String nomeDisciplina = scanner.nextLine();

         System.out.print("Digite o código da disciplina:");
         String codigo = scanner.nextLine();

         System.out.print("Digite a carga horária total (em horas):");
         int cargaHoraria = scanner.nextInt();
         scanner.nextLine();

         System.out.print("Digite os pré-requisitos necessários para o aluno poder realizar a disciplina (digite o código), se não, digite 'nenhum':");
         String preRequisito = scanner.nextLine();

         DisciplinaInfo disciplina = DisciplinaInfo.getListaDisciplinas().stream().filter(d -> d.getcodigo().equalsIgnoreCase(codigo)).findFirst().orElse(null);

         if (disciplina == null) {
             disciplina = new DisciplinaInfo(nomeDisciplina, codigo, cargaHoraria, preRequisito);
             DisciplinaInfo.adicionarDisciplina(disciplina);
            }


         System.out.println("Informações da Turma");

         System.out.print("Digite o nome da Turma (exemplo: turma 1):");
         String nomeTurma = scanner.nextLine();

         System.out.print("Digite o nome do professor(a):");
         String professor = scanner.nextLine();

         System.out.print("Digite o horário da aula:");
         String horarioAula = scanner.nextLine();
         

         System.out.print("Digite a quantidade máxima de alunos que cabem na turma :");
         int capacidade = scanner.nextInt();
         scanner.nextLine();

         System.out.print("Escolha (digitando 1 ou 2) o modo de avaliação da turma:\n");
         System.out.print("1-Media Final = (P1 + P2 + P3 + L + S) / 5\n");
         System.out.println("2-Media Final = (P1 + P2 * 2 + P3 * 3 + L + S) / 8");
         int modoDeAvaliacao = scanner.nextInt();
         scanner.nextLine();

         System.out.print("Sua turma será presencial? Digite 'true' para sim e 'false' para não :");
         String presencaInput = scanner.nextLine();
         boolean presencial = Boolean.parseBoolean(presencaInput);

         Turma novaTurma = new Turma(disciplina, professor, capacidade, horarioAula, modoDeAvaliacao, presencial, nomeTurma);
         Turma.getlistaTurmas().add(novaTurma);


         System.out.println("Turma criada com sucesso!");
         System.out.println("Disciplina: " + novaTurma.getdisciplina().getnomeDaDisciplina());
         System.out.println("Professor: " + novaTurma.getprofessor());
         System.out.print("Deseja cadastrar outra turma? (sim/não): ");
         resposta = scanner.nextLine();

         
        }
        Turma.salvarTurmasEmArquivo(Turma.getlistaTurmas(), "turmas.txt");
        System.out.println("Encerrando o cadastro de turmas.");
        

    }
 
    ////////////////////metodo listagem de turmas com alunos/////////////////////////
    
    public static void listaDasTurmasEalunos(){
        List<Turma> turmas = Turma.getlistaTurmas();

        if (turmas.isEmpty()) {
            System.out.println("Não há turmas cadastradas");
            return;
            
        }

        System.out.printf("%-15s %-10s %-15s %-12s %-10s %-15s %-10s%n","Turma", "Código", "Professor", "Capacidade", "Alunos", "Horário", "Presencial");

        for (Turma turma : turmas){
          System.out.printf("%-15s %-10s %-15s %-12d %-10d %-15s %-10s%n",
            turma.getnomeTurma(),
            turma.getdisciplina().getcodigo(),
            turma.getprofessor(),
            turma.getcapacidade(),
            turma.getalunosMatriculados().size(),
            turma.gethorarioAula(),
            turma.getpresencial() ? "Sim" : "Não");
         

         List<AlunoInfo> alunos = turma.getalunosMatriculados();
           if (alunos.isEmpty()) {
              System.out.println("Não há alunos matriculados");
            
            }else{
             System.out.println("Alunos matriculados:");
               for (AlunoInfo aluno : alunos){
                  System.out.println("    - " + aluno.getNome() + " (" + aluno.getMatricula() + ")");

                }
            }
        }

    }
    ///////////////////////////////////////matricula dos alunos/////////////////////////////////////////
    
   public static void matriculaDoAluno(Scanner scanner){
    System.out.println("Turmas disponíveis");
    List<Turma> turmas = Turma.getlistaTurmas();

    if (turmas.isEmpty()) {
        System.out.println("Não há turmas cadastradas");
        return;
    }

    for (int i = 0; i < turmas.size(); i++) {
        Turma turma = turmas.get(i);
        System.out.println(i + " - " + turma.getdisciplina().getnomeDaDisciplina() +
            " | " + turma.getnomeTurma() + 
            " Capacidade: " + turma.getcapacidade() + 
            ", Matriculados: " + turma.getalunosMatriculados().size());
    }

    System.out.print("Escolha a turma digitando de acordo com a ordem na lista: ");
    int resp = scanner.nextInt();
    scanner.nextLine();

    if (resp < 0 || resp >= turmas.size()) {
        System.out.println("Opção inválida");
        return;
    }

    Turma turmaEscolhida = turmas.get(resp);
    if (turmaEscolhida.getalunosMatriculados().size() >= turmaEscolhida.getcapacidade()) {
        System.out.println("Não é possível matricular, pois a turma está cheia!");
        return;
    }

    System.out.print("Digite a matrícula do aluno: ");
    String matricula = scanner.nextLine();

    AlunoInfo aluno = Aluno.buscarAlunoPorMatricula(matricula);

    if (aluno == null) {
        System.out.println("Aluno não encontrado. Verifique se foi cadastrado corretamente.");
        return;
    }

    if (turmaEscolhida.getalunosMatriculados().contains(aluno)) {
        System.out.println("Aluno já está matriculado nesta turma.");
        return;
    }

    if (aluno instanceof AlunoEspecial) {
        AlunoEspecial especial = (AlunoEspecial) aluno;
        if (!especial.podeMatricular()) {
            System.out.println("Aluno especial já está matriculado em 2 disciplinas.");
            return;
        }
        especial.adicDisciplina(turmaEscolhida.getdisciplina().getcodigo());
    }

    if (turmaEscolhida.matriculaLimitadaDeAlunos(aluno)) {
        System.out.println("Aluno matriculado com sucesso!");
    } else {
        System.out.println("Erro ao matricular. Turma cheia.");
    }
}

}
