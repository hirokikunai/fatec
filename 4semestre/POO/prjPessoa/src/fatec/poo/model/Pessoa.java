package fatec.poo.model;

/**
 *
 * @author bruno
 */
public abstract class Pessoa {
    private String nome;
    private int anoInscricao;
    private double totalCompras;

    public Pessoa(String nome, int anoDescricao) {
        this.nome = nome;
        this.anoInscricao = anoDescricao;
    }
    
    abstract public double calcBonus(int anoAtual);
    
    public void addCompras(double valorCompra){
        this.totalCompras = this.totalCompras + valorCompra;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoInscricao() {
        return anoInscricao;
    }

    public double getTotalCompras() {
        return totalCompras;
    }
}
