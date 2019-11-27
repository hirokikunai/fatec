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
public class Pessoa {
    private String Nome;
    private String DataNasc;
    private String Endereco;
    private String Numero;
    private String Bairro;
    private String Cidade;
    private String Estado;
    private String CEP;
    private String Telefone;
    private String Celular;
    private String Sexo;
    private String EstadoCivil;
    private String RG;
    private String CPF;
    private String Email;
    
    public Pessoa(String CPF, String Nome) {
        
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setDataNasc(String DataNasc) {
        this.DataNasc = DataNasc;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public void setEstadoCivil(String EstadoCivil) {
        this.EstadoCivil = EstadoCivil;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getNome() {
        return Nome;
    }

    public String getDataNasc() {
        return DataNasc;
    }

    public String getEndereco() {
        return Endereco;
    }

    public String getNumero() {
        return Numero;
    }

    public String getBairro() {
        return Bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public String getCEP() {
        return CEP;
    }

    public String getTelefone() {
        return Telefone;
    }

    public String getCelular() {
        return Celular;
    }

    public String getSexo() {
        return Sexo;
    }

    public String getEstadoCivil() {
        return EstadoCivil;
    }

    public String getRG() {
        return RG;
    }

    public String getCPF() {
        return CPF;
    }

    public String getEmail() {
        return Email;
    }

    public static boolean validarCPF(String CPF){
        if(!valPrimeiroDigito(CPF)){
            return false;
        }
        if(!valSegundoDigito(CPF)){
            return false;
        }

        return true;
    }

    private static boolean valPrimeiroDigito(String CPF){
        int soma = 0;
        int count;
        int divisao;
        int numeroValidador;
        
        if(CPF.length() < 11)
            return false;
        
        for(count = 1; count < 10; count++){
            int number = Integer.parseInt(CPF.substring( count - 1, count));
            soma += number * count;
        }

        numeroValidador = Integer.parseInt(CPF.substring(9,10));
        divisao = soma % 11;
        
        if(divisao == numeroValidador || (divisao == 10 && numeroValidador == 0)){
            return true;
        }
        
        return false;
    }

    private static boolean valSegundoDigito(String CPF){
        
        int soma = 0;
        int count = 0;
        int validador;
        int numeroValidador;
        
        for(int i = 11; i > 1; i--){
            int number = Integer.parseInt(CPF.substring( count, count + 1));
            soma += number * i;
            count++;
        }

        numeroValidador = Integer.parseInt(CPF.substring(10,11));
        validador = (soma * 10) % 11;

        if(validador == numeroValidador || (validador == 10 && numeroValidador == 0)){
            return true;
        }
        
        return false;
    }
}
