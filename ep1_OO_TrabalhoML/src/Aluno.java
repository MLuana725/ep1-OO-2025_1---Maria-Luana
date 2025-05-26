import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nomeAluno;
    private String matricula;
    private String curso;

    // Lista que armazena todos os dados de alunos
    private static final List<AlunoInfo> listaDeAlunos = new ArrayList<>();

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

    public static void salvarAlunosEmArquivo(String caminhoArquivo) {
        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            writer.write("Nome|Matricula|Curso\n"); // cabeçalho correto
            for (AlunoInfo aluno : listaDeAlunos) {
               writer.write(aluno.getNome() + "|" + aluno.getMatricula() + "|" + aluno.getCurso() + "|" + aluno.isAlunoEspecial() + "\n");

            }
            System.out.println("Arquivo salvo com sucesso: " + caminhoArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar alunos: " + e.getMessage());
        }
    }

    public static void carregarAlunosDeArquivo(String caminhoArquivo) {
        listaDeAlunos.clear(); 

        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha = reader.readLine(); 

            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split("\\|");
                if (partes.length >= 4) {
                  String nome = partes[0];
                  String matricula = partes[1];
                  String curso = partes[2];
                  boolean especial = Boolean.parseBoolean(partes[3]);

                  AlunoInfo aluno;
                  if (especial) {
                      aluno = new AlunoEspecial(nome, matricula, curso);
                    } else {
                      aluno = new AlunoInfo(nome, matricula, curso);
                    }

                  listaDeAlunos.add(aluno);
                }

            }
            System.out.println("Alunos carregados com sucesso de: " + caminhoArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao carregar alunos: " + e.getMessage());
        }
    }
    
    public static void impressãoListaAlunos(){
       if (listaDeAlunos.isEmpty()) {
          System.out.println("Não há alunos cadastrados.");
        } else {
           for (AlunoInfo aluno : listaDeAlunos) {
              System.out.println(aluno);
            }
        }
    }
    
    //metodos relacionados a matricula
    public static boolean checarMatricula(String novaMatricula){
        for (AlunoInfo alunoInfo : listaDeAlunos){
            if(alunoInfo.getMatricula().equalsIgnoreCase(novaMatricula)){
                System.out.println("Matrícula já cadastrada.");
                return false;
            }
        }
        
        return true;

    }

    public static boolean adicionarAluno(AlunoInfo aluno) {
        if (!checarMatricula(aluno.getMatricula())) {
            System.out.println("Matrícula já cadastrada.");
            return false;
        }
        listaDeAlunos.add(aluno);
        return true;
    }

    public static AlunoInfo buscarAlunoPorMatricula(String matricula) {
        for (AlunoInfo aluno : listaDeAlunos) {
            if (aluno.getMatricula().equalsIgnoreCase(matricula)) {
                return aluno;
            }
        }
        return null;
    }
}



