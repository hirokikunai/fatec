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
public class Matricula {
    private String Data;
    private int QtdeFaltas;
    private double Nota;
    private Aluno aluno;
    private Turma turma;
    private AVista avista;
    private APrazo aprazo;

    public Matricula(String Data) {
        this.Data = Data;
    }
    
    public void setAluno (Aluno aluno) {
        this.aluno = aluno;
        aluno.setMatricula(this);
    }
    
    public void setTurma (Turma turma) {
        this.turma = turma;
    }

    public void setQtdeFaltas (int QtdeFaltas) {
        this.QtdeFaltas = QtdeFaltas;
    }

    public void setNota (double Nota) {
        this.Nota = Nota;
    }
    
    public void setAVista (AVista avista) {
        this.avista = avista;
    }
    
    public void setAPrazo (APrazo aprazo) {
        this.aprazo = aprazo;
    }
    
    public void EmitirCarne() {};
    
}
