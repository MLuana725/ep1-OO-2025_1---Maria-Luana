public class DisciplinaInfo {
    private String nomeDaDisciplina;
    private String codigo;
    private int cargaHoraria;
    private String preRequisito;
    
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







}
