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
public class Pessoa {
    private String nome;
    private String dtNascimento;
    private String endereco;
    private String cidade;

    public Pessoa (String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public String getDtNascimento() {
        return this.dtNascimento;
    }
    
    public String getEndereco() {
        return this.endereco;
    }
    
    public String getCidade() {
        return this.cidade;
    }
}
