
package fatec.poo.model;

import java.util.ArrayList;

public class Projeto {
    private int codigo;
    private String descricao;
    private String dtInicio;
    private String dtTermino;
    private ArrayList<Funcionario> funcionarios;

    public Projeto(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
        funcionarios = new ArrayList();
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

    public void setDtInicio(String dtInicio) {
        this.dtInicio = dtInicio;
    }

    public void setDtTermino(String dtTermino) {
        this.dtTermino = dtTermino;
    }
    public void addFuncionario(Funcionario f){
        funcionarios.add(f);
        f.setProjeto(this);
    }
    public void listar(){
        System.out.println("\n\nCódigo: " + codigo);
        System.out.println("Descrição: " + descricao);
        System.out.println("Data de Inicio: " + dtInicio);
        System.out.println("Data de termino: " + dtTermino);
        System.out.println("Qtde. Funcionários: " + funcionarios.size());
        System.out.println("\nRegistro\t\tNome\t\tCargo\t\t\tDepartamento");
        
        for(int x =0; x < funcionarios.size();x++){
            System.out.printf("%-15d %-15s %-20s %-25s\n",funcionarios.get(x).getRegistro(),
                              funcionarios.get(x).getNome(),     
			      funcionarios.get(x).getCargo(),
			      funcionarios.get(x).getDepartamento().getNome());
        }
    }
    
}
