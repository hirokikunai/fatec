package fatec.poo.model;

/**
 *
 * @author bruno
 */
public class PessoaFisica extends Pessoa{

    private String CPF;
    private double base;
    
    public PessoaFisica(String CPF, String nome, int anoDescricao) {
        super(nome, anoDescricao);
        this.CPF = CPF;
    }
    
    @Override
    public double calcBonus(int anoAtual) {
        if (getTotalCompras() > 12000) {
            return (anoAtual - getAnoInscricao())* this.base;
        }else{
            return 0;
        }
    }

    public String getCPF() {
        return CPF;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }
   
}
