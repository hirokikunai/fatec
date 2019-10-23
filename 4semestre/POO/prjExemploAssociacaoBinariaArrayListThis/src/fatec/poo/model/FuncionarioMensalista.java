package fatec.poo.model;

/**
 *
 * @author dimas
 */
public class FuncionarioMensalista extends Funcionario{
    private double numSalMin;
    private double valSalMin;

    public FuncionarioMensalista(int registro, String nome, String dtAdmissao, double numSalMin) {
        super(registro, nome, dtAdmissao);//chamada ao método construtor da superclasse
        this.numSalMin = numSalMin;
    }

    public void apontarValSalMin(double valSalMin){
        this.valSalMin = valSalMin;
    }
    @Override
    public double calcSalBruto() {
        return(valSalMin * numSalMin);
    }
}
