
public class AlunoInfo {
    private String nome;
    private String matricula;
    private String curso;
    protected boolean alunoEspecial = false;

    public AlunoInfo(String nome, String matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    public boolean isAlunoEspecial(){
        return alunoEspecial;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCurso(String curso){
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "| Matrícula: " + matricula + "| Curso: " + curso; //1?versão
    }
}

