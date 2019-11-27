/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Instrutor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author saobanha
 */
public class DaoInstrutor {
    private Connection conn;
    
    public DaoInstrutor(Connection conn){
        this.conn = conn;
    }
    
    public Instrutor Consultar(String cpf){
        Instrutor instrutor = null;
        try{
            PreparedStatement ps =  conn.prepareStatement(
                    "SELECT * FROM tbInstrutor WHERE cpf = ?");
            ps.setString(1, cpf);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                instrutor = new Instrutor(cpf, rs.getString("nome_inst"));
                instrutor.setAreaAtuacao(rs.getString("area_atuacao"));
                instrutor.setBairro(rs.getString("bairro"));
                instrutor.setCelular(rs.getString("celular"));
                instrutor.setCEP(rs.getString("cep"));
                instrutor.setCidade(rs.getString("cidade"));
                instrutor.setEmail(rs.getString("email"));
                instrutor.setEndereco(rs.getString("endereco"));
                instrutor.setEstado(rs.getString("uf"));
                instrutor.setEstadoCivil(rs.getString("civil"));
                instrutor.setFormacao(rs.getString("formacao"));
                instrutor.setNumero(rs.getString("num"));
                instrutor.setRG(rs.getString("rg"));
                instrutor.setSexo(rs.getString("sexo"));
                instrutor.setTelefone(rs.getString("telefone"));
                instrutor.setDataNasc(rs.getString("dt_nasc"));   
            }
        }catch(SQLException ex)
        {
            System.out.println(ex.toString());
        }
        return instrutor;
    }
    
    public void Inserir(Instrutor instrutor)
    {
        try
        {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO "
                    + "tbInstrutor VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + "?, ?, ?, ?, ?)");
            
            
            ps.setString(1, instrutor.getCPF());
            ps.setString(2, instrutor.getNome());
            ps.setString(3, instrutor.getDataNasc());
            ps.setString(4, instrutor.getSexo());
            ps.setString(5, instrutor.getEstadoCivil());
            ps.setString(6, instrutor.getEndereco());
            ps.setString(7, instrutor.getNumero());
            ps.setString(8, instrutor.getCEP());
            ps.setString(9, instrutor.getBairro());
            ps.setString(10, instrutor.getTelefone());
            ps.setString(11, instrutor.getCelular());
            ps.setString(12, instrutor.getCidade());
            ps.setString(13, instrutor.getEstado());
            ps.setString(14, instrutor.getRG());
            ps.setString(15, instrutor.getAreaAtuacao());
            ps.setString(16, instrutor.getFormacao());
            ps.setString(17, instrutor.getEmail());  
            
            ps.execute();
        } 
        catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void Alterar(Instrutor instrutor)
    {
        try
        {
            PreparedStatement ps = conn.prepareStatement("UPDATE tbInstrutor "
                    + "SET CPF = ?, NOME_INST = ?, DT_NASC = ?, SEXO = ?,"
                    + " CIVIL = ?, ENDERECO = ?, NUM = ?, CEP = ?, BAIRRO = ?,"
                    + " TELEFONE = ?, CELULAR = ?, CIDADE = ?, UF = ?, RG = ?,"
                    + " AREA_ATUACAO = ?, FORMACAO = ?, EMAIL = ? "
                    + " WHERE CPF = ?");
            
            ps.setString(1, instrutor.getCPF());
            ps.setString(2, instrutor.getNome());
            ps.setString(3, instrutor.getDataNasc());
            ps.setString(4, instrutor.getSexo());
            ps.setString(5, instrutor.getEstadoCivil());
            ps.setString(6, instrutor.getEndereco());
            ps.setString(7, instrutor.getNumero());
            ps.setString(8, instrutor.getCEP());
            ps.setString(9, instrutor.getBairro());
            ps.setString(10, instrutor.getTelefone());
            ps.setString(11, instrutor.getCelular());
            ps.setString(12, instrutor.getCidade());
            ps.setString(13, instrutor.getEstado());
            ps.setString(14, instrutor.getRG());
            ps.setString(15, instrutor.getAreaAtuacao());
            ps.setString(16, instrutor.getFormacao());
            ps.setString(17, instrutor.getEmail());            
           
            ps.setString(18, instrutor.getCPF());
            
            ps.execute();
        } 
        catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public boolean Excluir(Instrutor instrutor)
    {
        try
        {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM "
                    + "tbInstrutor WHERE cpf = ?");
            ps.setString(1, instrutor.getCPF());
            ps.execute();
        } 
        catch(SQLException ex){
            System.out.println(ex.toString());
            return false;
        }
        
        return true;
    }
}
