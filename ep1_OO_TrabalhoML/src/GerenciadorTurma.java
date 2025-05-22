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

         System.out.print("Digite a carga horária total:");
         int cargaHoraria = scanner.nextInt();
         scanner.nextLine();

         System.out.print("Digite os pré-requisitos necessários para o aluno poder realizar a disciplina (digite o código):");
         String preRequisito = scanner.nextLine();

         DisciplinaInfo disciplina = new DisciplinaInfo(nomeDisciplina, codigo, cargaHoraria, preRequisito);

         System.out.println("Informações da Turma");

         System.out.print("Digite o nome da Turma (exemplo: turma 1):");
         String nomeTurma = scanner.nextLine();

         System.out.print("Digite o nome do professor(a):");
         String professor = scanner.nextLine();

         System.out.print("Digite o horário da aula:");
         int horarioAula = scanner.nextInt();
         scanner.nextLine();

         System.out.print("Digite a quantidade máxima de alunos que cabem na turma :");
         int capacidade = scanner.nextInt();
         scanner.nextLine();

         System.out.print("Escolha (digitando 1 ou 2) o modo de avaliação da turma:\n");
         System.out.print("1-Media Final = (P1 + P2 + P3 + L + S) / 5\n");
         System.out.print("Media Final = (P1 + P2 * 2 + P3 * 3 + L + S) / 8");
         int modoDeAvaliacao = scanner.nextInt();
         scanner.nextLine();

         System.out.print("Sua turma será presencial? Digite 'true' para sim e 'false' para não :");
         boolean presencial = scanner.nextBoolean();

         Turma novaTurma = new Turma(disciplina, professor, capacidade, horarioAula, modoDeAvaliacao, presencial, nomeTurma);
        
         System.out.println("Turma criada com sucesso!");
         System.out.println("Disciplina: " + novaTurma.getdisciplina().getnomeDaDisciplina());
         System.out.println("Professor: " + novaTurma.getprofessor());
         System.out.println("Deseja cadastrar outra turma?");
         resposta = scanner.nextLine();
        }
        System.out.println("Encerrando o cadastro de turmas.");
        

    }
 
    ////////////////////metodo listagem de turmas com alunos/////////////////////////
    
    public static void listaDasTurmasEalunos(){
        List<Turma> turmas = Turma.getlistaTurmas();

        if (turmas.isEmpty()) {
            System.out.println("Não há turmas cadastradas");
            return;
            
        }

        for (Turma turma : turmas){

         System.out.println("Disciplina: " + turma.getdisciplina().getnomeDaDisciplina());
         System.out.println("Código da Disciplina: " + turma.getdisciplina().getcodigo());
         System.out.println("Professor(a): " + turma.getprofessor());
         System.out.println("Capacidade da Turma: " + turma.getcapacidade());
         System.out.println("Presencial?: " + turma.getpresencial());

        

         List<AlunoInfo> alunos = turma.getalunosMatriculados();
           if (alunos.isEmpty()) {
              System.out.println("Não há alunos matriculados");
            
            }else{
             System.out.println("Alunos matriculados:");
               for (AlunoInfo aluno : alunos){
                 System.out.println("- " +aluno);
                }
            }
        }

    }
    ///////////////////////////////////////matricula dos alunos/////////////////////////////////////////
    
    public static void matriculaDoAluno(Scanner scanner){
        

        System.out.println("Turmas disponíveis");
        List<Turma> turmas = Turma.getlistaTurmas();

        //Caso não há turmas para matricular
        if (turmas.isEmpty()) {
            System.out.println("Não há turmas cadastradas");
            return;
        }
         
        //Há turmas
        for (int i = 0; i < turmas.size(); i++) {
         Turma turma = turmas.get(i);
         System.out.println(i + " - " + turma.getdisciplina().getnomeDaDisciplina()+ " | " + turma.getnomeTurma()+ " Capacidade: " + turma.getcapacidade() + ", Matriculados: " + turma.getalunosMatriculados().size() + ")");
        }

        System.out.print("Escolha a turma digitando de acordo com a ordem na lista:");
        int resp = scanner.nextInt();
        scanner.nextLine();

        if (resp < 0 || resp >= turmas.size()) {
            System.out.println("Opção inválida");
            return;
        }
        
        Turma turmaEscolhida = turmas.get(resp);
        if (turmaEscolhida.getalunosMatriculados().size() >= turmaEscolhida.getcapacidade()) {
            System.out.println("Não é possivel matricular, pois a turma está cheia!");
            return;
        }
        
        
        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        System.out.print("Curso: ");
        String curso = scanner.nextLine();

        AlunoInfo aluno = new AlunoInfo(nome, matricula, curso);

        if (turmaEscolhida.matriulaLimitadaDeAlunos(aluno)) {
            System.out.println("Aluno matriculado com sucesso!");
        } else {
            System.out.println("Erro ao matricular. Turma cheia.");
        }
     
    }
}
