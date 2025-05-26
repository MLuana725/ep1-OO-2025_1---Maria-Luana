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
        try (BufferedWriter writer = new BufferedWriter(
             new OutputStreamWriter(new FileOutputStream(caminhoArquivo), StandardCharsets.UTF_8))) {
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
    listaDisciplinas.clear(); // Limpa a lista antes de carregar
    try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(new FileInputStream(caminhoArquivo), StandardCharsets.UTF_8))) {

        String linha = reader.readLine(); 

        while ((linha = reader.readLine()) != null) {
            String[] partes = linha.split("\\|");
            if (partes.length == 4) {
                String nome = partes[0];
                String codigo = partes[1];
                int cargaHoraria = Integer.parseInt(partes[2]);
                String preRequisito = partes[3];

                DisciplinaInfo d = new DisciplinaInfo(nome, codigo, cargaHoraria, preRequisito);
                listaDisciplinas.add(d);
            } else {
                System.out.println("Linha inválida (esperado 4 campos): " + linha);
            }
        }
    } catch (IOException e) {
        System.err.println("Erro ao carregar disciplinas: " + e.getMessage());
    }

    return listaDisciplinas;
}


    private static final List<DisciplinaInfo> listaDisciplinas = new ArrayList<>();

    public static List<DisciplinaInfo> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public static void adicionarDisciplina(DisciplinaInfo disciplina) {
      listaDisciplinas.add(disciplina); 
    }


}






