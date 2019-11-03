package fatec.poo.model;

import java.util.ArrayList;
/**
 *
 * @author dimas
 */
public class Departamento {
    private String sigla;
    private String nome;
    private ArrayList<Funcionario> funcionarios;
    

    public Departamento(String sigla, String nome) {
        this.sigla = sigla;
        this.nome = nome;
        funcionarios = new ArrayList();
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }
    
    public void addFuncionario(Funcionario f){
        funcionarios.add(f);
        f.setDepartamento(this);
    }
    
    public void listar(){
        System.out.println("\n\nSigla: " + sigla);
        System.out.println("Nome : " + nome);
        System.out.println("Qtde. funcionários : " + funcionarios.size());
        System.out.println("\nRegistro\t\tNome\t\tCargo\t\tTipo");
        
        for(int x=0; x < funcionarios.size(); x++){
            System.out.printf("%-10d %-20s %-25s" ,funcionarios.get(x).getRegistro(),
                                                   funcionarios.get(x).getNome(),
                                                   funcionarios.get(x).getCargo());
            
            if (funcionarios.get(x) instanceof FuncionarioHorista){
                System.out.printf("%-15s\n","Horista");
            }else
                if (funcionarios.get(x) instanceof FuncionarioMensalista){
                   System.out.printf("%-15s\n","Mensalista");
                }else{
                    System.out.printf("%-15s\n","Comissionado");
                }
        }
        
    }
  
}
