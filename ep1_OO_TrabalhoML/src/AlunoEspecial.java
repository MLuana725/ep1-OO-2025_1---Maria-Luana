import java.util.ArrayList;
import java.util.List;

public class AlunoEspecial extends AlunoInfo{
    private List<String> disciplinasMatriculadas;

    public AlunoEspecial(String mome, String matricula, String curso ){
        super(mome, matricula, curso);

        this.alunoEspecial = true;
        this.disciplinasMatriculadas = new ArrayList<>();
    }
    
    public boolean podeMatricular(){
        return disciplinasMatriculadas.size()<2;
    }

    public boolean adicDisciplina(String codigoDisciplina){
        if (podeMatricular()) {
            disciplinasMatriculadas.add(codigoDisciplina);
            return true;
        }else{
            System.out.println("Aluno especial só pode se matricular em até 2 disciplinas.");
            return false;
        }
    }

    public List<String> getDisciplinasMatriculadas(){
        return disciplinasMatriculadas;
    }

    @Override
    public String toString(){
        return super.toString()+ "[Aluno especial - Máximo de 2 disciplinas, sem notas]";
    }
}
