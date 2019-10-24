/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.model.fatec;
import poo.model.fatec.Pessoa;

/**
 *
 * @author 0030481723013
 */
public class Professor extends Pessoa{
    
    private String regFunc;
    private int titularidade;
    private Turma turma;
    
    public Professor(String regFunc, String nome) {
        super(regFunc);
        this.regFunc = regFunc;
    }
    
    public String getRegFunc() {
        return this.regFunc;
    }
    
    public void setTurma(Turma turma) {
        this.turma = turma;
    }
    
    public String getTitularidade() {
        switch(titularidade){
            case 1:
                return "Especialista";
            case 2:
                return "Mestre";
            case 3:
                return "Doutor";
            default:
                return "Inválido";
        }
    }
    
}
