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

    
}
