/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

/**
 *
 * @author 0030481723013
 */
public class Projeto {

    private int codigo;
    private String descricao;
    private String dtInicio;
    private String dtTermino;
    private Funcionario[] funcionarios;
    private int numFunc;

    public Projeto(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
        funcionarios = new Funcionario[10];
        numFunc = 0;
    }
    
    public void addFuncionario (Funcionario funcionario) {
        funcionarios[numFunc] = funcionario;
        numFunc++;
    }
    
    public void setDtInicio(String dtInicio) {
        this.dtInicio = dtInicio;
    }

    public void setDtTermino(String dtTermino) {
        this.dtTermino = dtTermino;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDtInicio() {
        return dtInicio;
    }

    public String getDtTermino() {
        return dtTermino;
    }  
    
    public void listar() {
        System.out.println("\n\nCodigo: " + codigo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Duração: " + dtInicio + " ~ " + dtTermino);
        System.out.println("\nRegistro\t\tNome\t\tCargo\t\tDepartamento");
        for (int x=0; x<numFunc; x++) {
            System.out.printf("%-10d %-20s %-25s %-25s\n", funcionarios[x].getRegistro(),
                                                   funcionarios[x].getNome(),
                                                   funcionarios[x].getCargo(),
                                                   funcionarios[x].getDepartamento().getNome()
                                                   );
        }
        
    }
}
