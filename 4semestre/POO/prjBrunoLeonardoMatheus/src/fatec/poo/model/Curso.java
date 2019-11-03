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
public class Curso {
    private String Sigla;
    private String Nome;
    private int CargaHoraria;
    private double Valor;
    private String DataVigencia;
    private double ValorHoraInstrutor;
    private String Programa;
    private ArrayList<Turma> turmas;

    public Curso(String Sigla, String Nome) {
        this.Sigla = Sigla;
        this.Nome = Nome;
        turmas = new ArrayList();
    }
    
    public void setTurma(Turma turma) {
        turmas.add(turma);
        turma.setCurso(this);
    }

    public void setSigla(String Sigla) {
        this.Sigla = Sigla;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public void setValorHoraInstrutor(double ValorHoraInstrutor) {
        this.ValorHoraInstrutor = ValorHoraInstrutor;
    }

    public void setPrograma(String Programa) {
        this.Programa = Programa;
    }
    
    
}
