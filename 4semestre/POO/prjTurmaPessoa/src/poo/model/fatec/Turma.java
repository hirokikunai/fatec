/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.model.fatec;

import java.util.ArrayList;
import poo.model.fatec.Alunos;

/**
 *
 * @author 0030481723013
 */
public class Turma {
    private String sigla;
    private int qtdVagas;
    private Curso curso;
    private Professor professor;
    private ArrayList<Alunos> alunos;

    public Turma(String sigla, int qtdVagas) {
        this.sigla = sigla;
        this.qtdVagas = qtdVagas;
    }
    
    public String getSigla() {
        return this.sigla;
    }
    
    public int getQtdVagas() {
        return this.qtdVagas;
    }
    
    public Curso getCurso() {
        return this.curso;
    } 
    
    public Professor getProfessor() {
        return this.professor;
    }
    
    public void setProfessor(Professor professor) {
        this.professor = professor;
        professor.setTurma(this);
    }
    
    public void setCurso (Curso curso) {
        this.curso = curso;
        curso.setTurma(this);
    }
    
    public void addAluno (Alunos aluno) {
        this.alunos.add(aluno);
    }
    
    public int getNumAlunos() {
        return alunos.size();
    }
}
