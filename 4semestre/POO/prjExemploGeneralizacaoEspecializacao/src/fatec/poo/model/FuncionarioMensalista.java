/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

/**
 *
 * @author 0030481723013
 */
public class FuncionarioMensalista extends Funcionario{
    
    private double valSalMin;
    private double numSalMin;

    public FuncionarioMensalista(int registro, String nome, String dtAdmissao, double numSalMin) {
        super(registro, nome, dtAdmissao);
        this.numSalMin = numSalMin;
    }
    
    public void apontarValSalMin (double valSalMin) {
        this.valSalMin = valSalMin;
    }
    
    @Override
    public double calcSalBruto() {
        return this.numSalMin*this.valSalMin;
    }
    
}
