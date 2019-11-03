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
abstract public class Turma {
    private String SiglaTurma;
    private String Descricao;
    private String DataInicio;
    private String DataTermino;
    private String Periodo;
    private int QtdVagas;
    private String Observacoes;
    private Instrutor instrutor;
    private ArrayList<Matricula> matriculas;
    private Curso curso;
    
    public Turma(String SiglaTurma, String Descricao) {
        this.SiglaTurma = SiglaTurma;
        this.Descricao = Descricao;
        this.matriculas = new ArrayList();
    }
    
    public void setCurso (Curso curso) {
        this.curso = curso;
    }
    
    public void setInstrutor(Instrutor instrutor) {
       this.instrutor = instrutor;
       instrutor.setTurma(this);
    }
    
    public void addMatricula (Matricula matricula) {
        matriculas.add(matricula);
        matricula.setTurma(this);
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public void setDataInicio(String DataInicio) {
        this.DataInicio = DataInicio;
    }

    public void setDataTermino(String DataTermino) {
        this.DataTermino = DataTermino;
    }

    public void setPeriodo(String Periodo) {
        this.Periodo = Periodo;
    }

    public void setQtdVagas(int QtdVagas) {
        this.QtdVagas = QtdVagas;
    }

    public void setObservacoes(String Observacoes) {
        this.Observacoes = Observacoes;
    }
    
    public abstract void EmitirListaFrequencia();
    
}
