public class InterfacePrincipal {
    public static void main(String[] args){
        System.out.println("Interface de interação");

        //teste do registro

        Aluno aluno1 = new Aluno("maria", "123456", "engenharia");
        Aluno aluno2 = new Aluno("pedro", "565656565", "engenharia");

        Aluno.impressãoListaAlunos();

    }
}
