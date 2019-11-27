/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author saobanha
 */
public class DaoCurso {
    private Connection conn;

    public DaoCurso(Connection conn) {
        this.conn = conn;
    }
    
        public void Inserir(Curso curso) {
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("INSERT INTO tbCurso "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, curso.getSigla());
            ps.setString(2, curso.getNome());
            ps.setInt(3, curso.getCargaHoraria());
            ps.setDouble(4, curso.getValor());
            ps.setString(5, curso.getPrograma());
            ps.setString(6, curso.getDataVigencia());
            ps.setDouble(7, curso.getValorHoraInstrutor());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void Alterar (Curso curso) {
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("UPDATE tbCurso SET (NOME_CURSO = ?,"
                    + "CARGA_HORARIA = ?,VALOR = ?,PROGRAMA = ?,"
                    + "DATA_VIGENCIA = ?,VALOR_HORA_INSTRUTOR = ?) "
                    + "WHERE sigla_curso= ?");
            ps.setString(1, curso.getNome());
            ps.setInt(2, curso.getCargaHoraria());
            ps.setDouble(3, curso.getValor());
            ps.setString(4, curso.getPrograma());
            ps.setString(5, curso.getDataVigencia());
            ps.setDouble(6, curso.getValorHoraInstrutor());
            ps.setString(7, curso.getSigla());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    
    public boolean Excluir (String sigla) {
        
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("DELETE * FROM tbCurso "
                    + "WHERE sigla_curso = ?");
            ps.setString(1,sigla);
            
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
        
        return true;
    }
    
    public Curso Consultar (String sigla) {
        Curso curso = null;
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("SELECT * FROM tbCurso "
                    + "WHERE sigla_curso = ?");
            ps.setString(1, sigla);
            ResultSet rs =  ps.executeQuery();
            
            if (rs.next()) {
                curso = new Curso (sigla, rs.getString("nome_curso"));
                curso.setValor(rs.getDouble("valor"));
                curso.setCargaHoraria(rs.getInt("carga_horaria"));
                curso.setPrograma(rs.getString("programa"));
                curso.setValorHoraInstrutor((rs.getDouble("valor_hora_instrutor")));
                curso.setDataVigencia(rs.getString("data_vigencia"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return curso;
    }
    
    public ArrayList<String> ListarSiglas () {
        ArrayList<String> siglas = new ArrayList();
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("SELECT sigla_curso FROM tbCurso");

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                siglas.add(rs.getString("sigla_curso"));
            }
            
        } catch(SQLException ex) {
            System.out.println(ex.toString());
        }
           
        return siglas;
    }

    
    
}
