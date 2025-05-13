import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nomeAluno;
    private String matricula;
    private String curso;

    // Lista estática que armazena todos os dados de alunos
    private static List<AlunoInfo> listaDeAlunos = new ArrayList<>();

    public Aluno(String nomeAluno, String matricula, String curso) {
        this.nomeAluno = nomeAluno;
        this.matricula = matricula;
        this.curso = curso;

        salvarDados(); // Armazena os dados na lista estática
    }

    private void salvarDados() {
        AlunoInfo info = new AlunoInfo(nomeAluno, matricula, curso);
        listaDeAlunos.add(info);
    }

    // Método para acessar a lista de alunos cadastrados
    public static List<AlunoInfo> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public static boolean checarMatricula(String novaMatricula){
        for (AlunoInfo alunoInfo : listaDeAlunos){
            if(alunoInfo.getMatricula()==novaMatricula){
                return true;
            }
        }
        return false;

    }

}
