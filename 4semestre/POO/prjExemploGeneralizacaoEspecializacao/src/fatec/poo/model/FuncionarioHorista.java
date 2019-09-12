package fatec.poo.model;

/**
 *
 * @author dimas
 */
public class FuncionarioHorista extends Funcionario{
    private double valHorTrab;
    private int qtdeHorTrab;
    
    public FuncionarioHorista(int registro, 
                              String nome, 
                              String dtAdmissao, 
                              double valHorTrab) {
       super(registro, nome, dtAdmissao);//chamada do método construtor da superclasse
       this.valHorTrab = valHorTrab;
    }

    @Override
    public double calcSalBruto() {
        return(valHorTrab * qtdeHorTrab);
    }
    
    public void apontarHoras(int qtdeHorTrab){
        this.qtdeHorTrab = qtdeHorTrab;
    }
    
    public double calcGratificacao() {
        return this.calcSalBruto()*0.075;
    }
    
    @Override
    public double calcSalLiquido() {
        return (super.calcSalLiquido() + this.calcGratificacao());
    }
    
}
