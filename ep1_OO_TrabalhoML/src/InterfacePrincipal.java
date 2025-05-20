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
              
           
            }


        }
        scanner.close();

    }

    public static void menuModoAluno(){

    } 
    
    public static void menuModoDisciplina(){
        
    } 

    public static void menuModoAvaliação(){
        
    } 




}