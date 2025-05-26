import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Turma{
    private DisciplinaInfo disciplina;
    private String professor;
    private int capacidade;
    private String horarioAula;
    private int modoDeAvaliacao;
    private boolean presencial;
    private String nomeTurma;

    //construtores das variávies
    public Turma(DisciplinaInfo disciplina, String professor, int capacidade, String horarioAula, int modoDeAvaliacao, boolean presencial, String nomeTurma){
        this.disciplina = disciplina;
        this.professor = professor;
        this.capacidade = capacidade;
        this.horarioAula = horarioAula;
        this.modoDeAvaliacao = modoDeAvaliacao;
        this.presencial = presencial;
        this.nomeTurma = nomeTurma;
        
    }

    public String getprofessor(){
        return professor;
    }

    public int getcapacidade(){
        return capacidade;
    }

    public String gethorarioAula(){
        return horarioAula;
    }

    public int getmodoDeAvaliacao(){
        return modoDeAvaliacao;
    }

    public boolean getpresencial(){
        return presencial;
    }

    public DisciplinaInfo getdisciplina(){
        return disciplina;
    }

    public String getnomeTurma(){
        return nomeTurma;
    }
   //////////////////////////////////////////////////////////////////////////////////////////////////
   
   ///////////////////////////////Lista de turmas/////////////////////////////////////////
   
   private static List<Turma> listaTurmas = new ArrayList<>();
   private List<AlunoInfo> alunosMatriculados = new ArrayList<>();
   
   public static List<Turma> getlistaTurmas(){
    return listaTurmas;
   }
    
   public List<AlunoInfo> getalunosMatriculados(){
    return alunosMatriculados;
   }
    
   ////////////////////////////metodo limitador de alunos matriculados em turmas////////////////////////
   
   public boolean matriculaLimitadaDeAlunos(AlunoInfo aluno){
    if (alunosMatriculados.size() < capacidade) {
        alunosMatriculados.add(aluno);
        return true;
        
    }else{
        return false;
    }
   }
   
  public static void salvarTurmasEmArquivo(List<Turma> turmas, String caminhoArquivo) {
   try (BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream(caminhoArquivo), StandardCharsets.UTF_8))) {

         writer.write("NomeTurma|CodigoDisciplina|Professor|Capacidade|Horario|ModoAvaliacao|Presencial\n");
          for (Turma t : turmas) {
             writer.write(t.getnomeTurma() + "|" + t.getdisciplina().getcodigo() + "|" + t.getprofessor() + "|" + t.getcapacidade() + "|" + t.gethorarioAula() + "|" + t.getmodoDeAvaliacao() + "|" + t.getpresencial() + "\n");
               if (!t.getalunosMatriculados().isEmpty()) {
                writer.write("ALUNOS");
                for (AlunoInfo aluno : t.getalunosMatriculados()) {
                    writer.write("|" + aluno.getMatricula());
                }
                writer.write("\n");
            }
            }
          System.out.println("Turmas salvas em: " + caminhoArquivo);
        } catch (IOException e) {
        System.err.println("Erro ao salvar turmas: " + e.getMessage());
    }
  }

   public static List<Turma> carregarTurmasDeArquivo(String caminhoArquivo, List<DisciplinaInfo> disciplinas) {
    listaTurmas.clear();

    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(new FileInputStream(caminhoArquivo), StandardCharsets.UTF_8))) {

        String linha = reader.readLine(); // Cabeçalho

        Turma turmaAtual = null;

        while ((linha = reader.readLine()) != null) {
            if (linha.startsWith("ALUNOS")) {
                if (turmaAtual != null) {
                    String[] partes = linha.split("\\|");
                    for (int i = 1; i < partes.length; i++) {
                        AlunoInfo aluno = Aluno.buscarAlunoPorMatricula(partes[i]);
                        if (aluno != null) {
                            turmaAtual.getalunosMatriculados().add(aluno);
                        }
                    }
                }
            } else {
                String[] partes = linha.split("\\|");
                if (partes.length == 7) {
                    String nomeTurma = partes[0];
                    String codigoDisciplina = partes[1];
                    String professor = partes[2];
                    int capacidade = Integer.parseInt(partes[3]);
                    String horario = partes[4];
                    int modoAvaliacao = Integer.parseInt(partes[5]);
                    boolean presencial = Boolean.parseBoolean(partes[6]);

                    DisciplinaInfo disciplina = disciplinas.stream().filter(d -> d.getcodigo().equalsIgnoreCase(codigoDisciplina)).findFirst().orElse(null);

                    if (disciplina != null) {
                        turmaAtual = new Turma(disciplina, professor, capacidade, horario,modoAvaliacao, presencial, nomeTurma);
                        listaTurmas.add(turmaAtual);
                    }
                }
            }
        }

    } catch (IOException e) {
        System.err.println("Erro ao carregar turmas: " + e.getMessage());
    }

    return listaTurmas;
}


}

