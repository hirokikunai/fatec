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
public class APrazo {
    private double Valor;
    private String DtVencimento;
    private double TaxaJuros;
    private int QtdeMensalidade;
    private Matricula matricula;

    public void setMatricula (Matricula matricula) {
        this.matricula = matricula;
        matricula.setAPrazo(this);
    }
    
    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public void setDtVencimento(String DtVencimento) {
        this.DtVencimento = DtVencimento;
    }

    public void setTaxaJuros(double TaxaJuros) {
        this.TaxaJuros = TaxaJuros/100;
    }
    
    
}
