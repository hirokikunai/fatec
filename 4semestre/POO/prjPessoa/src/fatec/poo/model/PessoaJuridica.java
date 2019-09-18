/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

/**
 *
 * @author bruno
 */
public class PessoaJuridica extends Pessoa {
    
    private String CGC;
    private double taxaIncentivo;
    
    public PessoaJuridica(String CGC, String nome, int anoDescricao) {
        super(nome, anoDescricao);
        this.CGC = CGC;
    }

    @Override
    public double calcBonus(int anoAtual) {
        return this.taxaIncentivo * getTotalCompras() * (anoAtual - getAnoInscricao());
    }

    public void setTaxaIncentivo(double taxaIncentivo) {
        this.taxaIncentivo = taxaIncentivo;
    }

    public String getCGC() {
        return CGC;
    }

    public double getTaxaIncentivo() {
        return taxaIncentivo;
    }
    
    
    
    
    
    
    
    
    
}
