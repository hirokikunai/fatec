/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class Instrutor extends Pessoa{
    
    private String Formacao;
    private String AreaAtuacao;
    private ArrayList<Turma> turma;
            
    public Instrutor(String CPF, String Nome) {
        super(CPF, Nome);
        this.turma = new ArrayList();
    }
    
    public void setTurma (Turma turma) {
        this.turma.add(turma);
    }

    public void setFormacao(String Formacao) {
        this.Formacao = Formacao;
    }

    public void setAreaAtuacao(String AreaAtuacao) {
        this.AreaAtuacao = AreaAtuacao;
    }
}
