package fatec.poo.model;

/**
 *
 * @author dimas
 */
public class Departamento {
    private String sigla;
    private String nome;
    private Funcionario[] funcionarios;
    private int numFunc;

    public Departamento(String sigla, String nome) {
        this.sigla = sigla;
        this.nome = nome;
        funcionarios = new Funcionario[10];
        numFunc = 0;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }
    
    public void addFuncionario(Funcionario func) {
        funcionarios[numFunc] = func;
        numFunc++;
    }
    
    public void listar() {
        System.out.println("\n\nSigla: " + sigla);
        System.out.println("Nome: "+ nome);
        System.out.println("Qtd de funcionarios: " + numFunc);
        System.out.println("\nRegistro\t\tNome\t\tCargo\t\tTipo");
        for (int x=0; x<numFunc; x++) {
            System.out.printf("%-10d %-20s %-25s", funcionarios[x].getRegistro(),
                                                   funcionarios[x].getNome(),
                                                   funcionarios[x].getCargo());
            if (funcionarios[x] instanceof FuncionarioHorista) {
                System.out.printf("%-15s\n","Horista");
            } else {
                if (funcionarios[x] instanceof FuncionarioMensalista) {
                    System.out.printf("%-15s\n", "Mensalista");
                } else {
                    System.out.printf("%-15s\n", "Comissionado");
                }
            }
        }
    }
    
}
