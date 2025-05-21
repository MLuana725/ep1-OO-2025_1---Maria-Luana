import java.util.Scanner;

public class InterfacePrincipal {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       int opcao = 0;
        
       while (opcao != 4) {
         System.out.println("=================================================================================");
         System.out.println("                     Sistema Acadêmico UnB v1.0");
         System.out.println("=================================================================================");
         System.out.println("");
         System.out.println("");
         System.out.println("Selecione o modo o qual deseja utilizar:");
         System.out.println("1-Modo Aluno");
         System.out.println("2-Modo Disciplina/Turma");
         System.out.println("3-Modo Avaliação");
         System.out.println("4-Encerrar programa");
         opcao = scanner.nextInt();
         scanner.nextLine();


         switch (opcao) {
            case 1:
                menuModoAluno();
                break;

            case 2:
                menuModoDisciplina();
                break;

            case 3:
                menuModoAvaliação();
                break;

            case 4: 
                System.out.println("encerrando programa......");
                break;

            default:
              System.out.println("Opção Inválida");
              break; 
           
            }


        }
        scanner.close();

    }

    public static void menuModoAluno(){
      Scanner scanner = new Scanner(System.in);
      int opc = 0;
      while (opc != 5) {
         System.out.println("==================================================================");
         System.out.println("                         Modo Aluno");
         System.out.println("==================================================================");
         System.out.println("Escolha o que deseja fazer:");
         System.out.println("1-Cadastrar Aluno");
         System.out.println("2-Mostrar Lista de Alunos");
         System.out.println("3-Matricular o Aluno em uma Turma");
         System.out.println("4-Editar Aluno");
         System.out.println("5-Voltar ao menu principal");
         opc = scanner.nextInt();
         scanner.nextLine();
           switch (opc) {
            case 1:
             System.out.println("Nome do Aluno:");
             String nome = scanner.nextLine();

             System.out.println("Matricula do Aluno:");
             String matricula = scanner.nextLine();

             if (Aluno.checarMatricula(matricula)) {
                System.out.println("Aluno já cadastrado.");
             }

             System.out.println("Curso:");
             String curso = scanner.nextLine();

             System.out.println("É um aluno especial?");
             String r = scanner.nextLine();
 
             if (r.equalsIgnoreCase("Sim")) {
                System.out.println("adicionando a categoria aluno especial");
                
             }else{
                new Aluno(nome, matricula, curso);
             }

               break;

            case 2:
               Aluno.impressãoListaAlunos();
               break;

            case 3:
             GerenciadorTurma.matriculaDoAluno();
              break;
            
            case 4:
             //Editar aluno
             break;
              
            case 5:
             //encerrar

            default:
              System.out.println("Opção Inválida");
              break;
            }

        }
       scanner.close();
    } 
    
    public static void menuModoDisciplina(){
     System.out.println("==================================================================");
     System.out.println("                         Modo Disciplina");
     System.out.println("==================================================================");
    } 

    public static void menuModoAvaliação(){
     System.out.println("==================================================================");
     System.out.println("                         Modo Avaliação");
     System.out.println("==================================================================");
    } 




}