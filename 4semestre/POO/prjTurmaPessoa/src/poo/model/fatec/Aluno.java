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
public class Aluno extends Pessoa {
    private String ra;
    private int escolaridade;
    
    public Aluno(String nome, String ra) {
        super(nome);
        this.ra = ra;
    }
    
    public String getRa() {
        return this.ra;
    }
    
    public String getEscolaridade() {
        switch(escolaridade){
            case 1:
                return "Ensino médio";
            case 2:
                return "Graduação";
            case 3:
                return "Pós Graduação";
            default:
                return "Inválido";
        }
    }
}
