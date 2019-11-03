/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.model.fatec;

/**
 *
 * @author 0030481723013
 */
public class Curso {
    private String sigla;
    private String descricao;
    private String cargaHoraria;
    private Turma turma;
    
    public Curso(String sigla, String descricao, String cargaHoraria) {
        this.sigla = sigla;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }

    public String getSigla() {
        return sigla;
    }
    
    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }
    
}
