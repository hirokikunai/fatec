package fatec.poo.model;

/**
 *
 * @author Dimas
 */
public class FuncionarioComissionado extends Funcionario{
    private double SalBase;
    private double TaxaComissao;//em porcentagem Exemplo: 5%
    private double TotalVendas;

    public FuncionarioComissionado(int registro, String nome, String dtAdmissao, double TaxaComissao) {
        super(registro, nome, dtAdmissao);
        this.TaxaComissao = TaxaComissao;
    }
    
    public double getSalBase() {
        return SalBase;
    }

    public void setSalBase(double SalBase) {
        this.SalBase = SalBase;
    }

    public double getTaxaComissao() {
        return TaxaComissao;
    }

    public double getTotalVendas() {
        return TotalVendas;
    }
    
    public void addVendas(double Vendas){
        TotalVendas += Vendas;
    }
    
    public double calcSalBruto(){
        return SalBase + (TaxaComissao/100 * TotalVendas);
    }
    
    public double calcGratificacao(){
        if(TotalVendas <= 5000){
            return 0;
        }else if(TotalVendas > 5000 && TotalVendas <= 10000){
             return calcSalBruto()*0.035;
        } 
        else{
            return calcSalBruto()*0.05;
        }
    }
    
    public double calcSalLiquido(){
        return (super.calcSalLiquido() + calcGratificacao());
    }
}
