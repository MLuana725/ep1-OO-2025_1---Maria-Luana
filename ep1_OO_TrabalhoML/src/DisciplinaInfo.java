import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DisciplinaInfo {
    private String nomeDaDisciplina;
    private String codigo;
    private int cargaHoraria;
    private String preRequisito;
    
   //construtores das variáveis
    public DisciplinaInfo(String nomeDaDisciplina,String codigo, int cargaHoraria,String preRequisito){
        this.nomeDaDisciplina = nomeDaDisciplina;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.preRequisito = preRequisito;
    }


    public String getnomeDaDisciplina(){
        return nomeDaDisciplina;
    }

    public String getcodigo(){
        return codigo;
    }

    public int getcargaHoraria(){
        return cargaHoraria;
    }

    public String getpreRequisito(){
        return preRequisito;
    }

    public static void salvarDisciplinasEmArquivo(List<DisciplinaInfo> disciplinas, String caminhoArquivo) {
        try (FileWriter writer = new FileWriter(caminhoArquivo)) {
            writer.write("Nome|Código|CargaHoraria|PreRequisito\n"); // cabeçalho

            for (DisciplinaInfo d : disciplinas) {
                writer.write(d.getnomeDaDisciplina() + "|" + d.getcodigo() + "|" + d.getcargaHoraria() + "|" + d.getpreRequisito() + "\n");
            }
            System.out.println("Arquivo de disciplinas salvo em: " + caminhoArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar disciplinas: " + e.getMessage());
        }
    }
}






