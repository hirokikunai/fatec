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
public class AVista extends FormaPagamento{
    private double Valor;
    private int Agencia;
    private int NCheque;
    private String PreData;
    private Matricula matricula;

    public void setMatricula (Matricula matricula) {
        this.matricula = matricula;
        matricula.setFormaPagamento(this);
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public void setAgencia(int Agencia) {
        this.Agencia = Agencia;
    }

    public void setNCheque(int NCheque) {
        this.NCheque = NCheque;
    }

    public void setPreData(String PreData) {
        this.PreData = PreData;
    }
    
    
}
