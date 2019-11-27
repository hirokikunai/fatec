/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Turma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author saobanha
 */
public class DaoTurma {
    private Connection conn;

    public DaoTurma(Connection conn) {
        this.conn = conn;
    }
    
    public void Inserir(Turma turma) {
        PreparedStatement ps = null;
        
        try{
            ps = conn.prepareStatement("INSERT INTO tbTurma VALUES (?,?,?,?,?,?,?)");
            
            ps.setString(1, turma.getSiglaTurma());
            ps.setString(2, turma.getCurso().getSigla());
            ps.setString(3,turma.getDescricao());
            ps.setInt(4,turma.getQtdVagas());
            ps.setString(5, turma.getDataInicio());
            ps.setString(6, turma.getPeriodo());
            ps.setString(7, turma.getDataTermino());
            
            ps.execute();
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void Alterar(Turma turma) {
        PreparedStatement ps = null;
        
        try{
            ps = conn.prepareStatement("UPDATE tbTurma SET (SIGLA_CURSO = ?, "
                    + "NOME_T = ?, QNT_VAGAS = ?,DT_INICIO = ?, PERIODO = ?, "
                    + "DT_TERM = ?) WHERE SIGLA_TURMA = ?");
            
            ps.setString(1, turma.getCurso().getSigla());
            ps.setString(2,turma.getDescricao());
            ps.setInt(3,turma.getQtdVagas());
            ps.setString(4, turma.getDataInicio());
            ps.setString(5, turma.getPeriodo());
            ps.setString(6, turma.getDataTermino());
            ps.setString(7, turma.getSiglaTurma());
            
            ps.execute();
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public Turma Consultar(String sigla) {
     Turma turma = null;
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("SELECT * FROM tbTurma "
                    + "WHERE sigla_turma = ?");
            ps.setString(1, sigla);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                DaoCurso daoCurso = new DaoCurso(conn);
                turma = new Turma(sigla, rs.getString("nome_t"));
                
                turma.setCurso(daoCurso.Consultar(rs.getString("sigla_curso")));
                turma.setQtdVagas(rs.getInt("qnt_vagas"));
                turma.setPeriodo(rs.getString("periodo"));
                turma.setDataTermino(rs.getString("dt_inicio"));
                turma.setDataInicio(rs.getString("dt_term"));
                                
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return (turma);
        
    }
    
    public void Excluir (Turma turma) {
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("DELETE FROM tbTurma "
                    + "WHERE sigla_turma = ?");
            ps.setString(1, turma.getSiglaTurma());
            
            ps.execute();            
        }catch(SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
}
