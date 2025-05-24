import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nomeAluno;
    private String matricula;
    private String curso;

    // Lista que armazena todos os dados de alunos
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
            if(alunoInfo.getMatricula().equalsIgnoreCase(novaMatricula)){
                return true;
            }
        }
        return false;

    }


    public static void dadosArquivo(String caminhoArquivo) {
        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            // Escreve cabeçalho
            writer.write("Registro de Alunos\n");

            // Escreve cada aluno
            for (AlunoInfo aluno : listaDeAlunos) {
                writer.write("|"+aluno.getNome() + "|" + aluno.getMatricula() + "|" + aluno.getCurso() + "\n");
            }

            System.out.println("Arquivo salvo com sucesso: " + caminhoArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar: " + e.getMessage());
        }
    }
    
    public static void impressãoListaAlunos(){
      for (AlunoInfo aluno : listaDeAlunos){
            System.out.println(aluno);
        }
    }

    public static void adicionarAluno(AlunoInfo alunoInfo){
        listaDeAlunos.add(alunoInfo);
    }
}



