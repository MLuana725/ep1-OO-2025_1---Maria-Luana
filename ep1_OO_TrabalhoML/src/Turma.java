import java.util.ArrayList;
import java.util.List;

public class Turma{
    private DisciplinaInfo disciplina;
    private String professor;
    private int capacidade;
    private int horarioAula;
    private int modoDeAvaliacao;
    private boolean presencial;

    //construtores das variávies
    public Turma(DisciplinaInfo disciplina, String professor, int capacidade, int horarioAula, int modoDeAvaliacao, boolean presencial){
        this.disciplina = disciplina;
        this.professor = professor;
        this.capacidade = capacidade;
        this.horarioAula = horarioAula;
        this.modoDeAvaliacao = modoDeAvaliacao;
        this.presencial = presencial;
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
   //////////////////////////////////////////////////////////////////////////////////////////////////
   
   ///////////////////////////////Lista de turmas/////////////////////////////////////////
   
   private static List<Turma> listaTurmas = new ArrayList<>();
   private List<AlunoInfo> alunosMatriculados = new ArrayList<>();
   
   public static List<Turma> getlistaTurmas(){
    return listaTurmas;
   }
    
   public void adicionarAluno(AlunoInfo aluno){
    alunosMatriculados.add(aluno);
   }

   public List<AlunoInfo> getalunosMatriculados(){
    return alunosMatriculados;
   }
    

   
}
