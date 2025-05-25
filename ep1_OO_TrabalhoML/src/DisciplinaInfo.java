import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

    public static List<DisciplinaInfo> carregarDisciplinasDeArquivo(String caminhoArquivo) {
        List<DisciplinaInfo> disciplinas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha = reader.readLine(); // ler cabeçalho

            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split("\\|");
                if (partes.length == 4) {
                    String nome = partes[0];
                    String codigo = partes[1];
                    int cargaHoraria = Integer.parseInt(partes[2]);
                    String preRequisito = partes[3];

                    DisciplinaInfo d = new DisciplinaInfo(nome, codigo, cargaHoraria, preRequisito);
                    disciplinas.add(d);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar disciplinas: " + e.getMessage());
        }
        return disciplinas;
    }

}






