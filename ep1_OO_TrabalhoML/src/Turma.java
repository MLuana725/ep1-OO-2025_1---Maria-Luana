import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Turma{
    private DisciplinaInfo disciplina;
    private String professor;
    private int capacidade;
    private int horarioAula;
    private int modoDeAvaliacao;
    private boolean presencial;
    private String nomeTurma;

    //construtores das variávies
    public Turma(DisciplinaInfo disciplina, String professor, int capacidade, int horarioAula, int modoDeAvaliacao, boolean presencial, String nomeTurma){
        this.disciplina = disciplina;
        this.professor = professor;
        this.capacidade = capacidade;
        this.horarioAula = horarioAula;
        this.modoDeAvaliacao = modoDeAvaliacao;
        this.presencial = presencial;
        this.nomeTurma = nomeTurma;
        listaTurmas.add(this);
    }

    public String getprofessor(){
        return professor;
    }

    public int getcapacidade(){
        return capacidade;
    }

    public int gethorarioAula(){
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
   

    public static List<Turma> carregarTurmasDeArquivo(String caminhoArquivo, List<DisciplinaInfo> disciplinas) {
     List<Turma> turmas = new ArrayList<>();
       try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
          String linha = reader.readLine(); // cabeçalho

           while ((linha = reader.readLine()) != null) {
             String[] partes = linha.split("\\|");
               if (partes.length == 7) {
                  String nomeTurma = partes[0];
                  String codigoDisciplina = partes[1];
                  String professor = partes[2];
                  int capacidade = Integer.parseInt(partes[3]);
                  int horario = Integer.parseInt(partes[4]);
                  int modoAvaliacao = Integer.parseInt(partes[5]);
                  boolean presencial = Boolean.parseBoolean(partes[6]);

                 // Busca disciplina pelo código
                 DisciplinaInfo disciplina = null;
                   for (DisciplinaInfo d : disciplinas) {
                       if (d.getcodigo().equalsIgnoreCase(codigoDisciplina)) {
                          disciplina = d;
                          break;
                        }
                    }

                    if (disciplina != null) {
                       Turma turma = new Turma(disciplina, professor, capacidade, horario, modoAvaliacao, presencial, nomeTurma);
                       turmas.add(turma);
                    } else {
                       System.out.println("Disciplina não encontrada para código: " + codigoDisciplina);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar turmas: " + e.getMessage());
        }
        return turmas;
    }
}

