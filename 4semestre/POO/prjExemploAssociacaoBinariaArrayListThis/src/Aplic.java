
import fatec.poo.model.Departamento;
import fatec.poo.model.FuncionarioComissionado;
import fatec.poo.model.FuncionarioHorista;
import fatec.poo.model.FuncionarioMensalista;
import fatec.poo.model.Projeto;


/**
 *
 * @author dimas
 */
public class Aplic {
    public static void main(String[] args) {
         FuncionarioHorista funcHor  = new FuncionarioHorista(1010,
                                                             "Pedro Silveira",
                                                             "14/05/78",
                                                             15.80);
        
        funcHor.setCargo("Programador");
        
        FuncionarioMensalista funcMen  = new FuncionarioMensalista(2020,
                                                                   "Ana Beatriz",
                                                                   "22/07/88",
                                                                   2.5);
        
        funcMen.setCargo("Aux. Administrativo");
        
        FuncionarioComissionado funcCom = new FuncionarioComissionado(3030, 
                                                                     "Joao Mendes",
                                                                     "10/12/1975",
                                                                     10);
       funcCom.setCargo("Vendedor");
       
       //instanciação de objetos da 
       //classe Projeto
       Departamento dep1 = new Departamento("RH","Recursos Humanos");
       Departamento dep2 = new Departamento("VD", "Vendas");
            
       //instanciação de  um objeto da 
       //classe Projeto
       Projeto proj = new Projeto(100, "Segurança no Trabalho");
       proj.setDtInicio("18/10/2019");
       proj.setDtTermino("22/11/2019");	  
      
      
       
    
    
       //Estabelecer a associação binária entre um
       //objeto da classe Departaqmento com 1 ou mais (1..*)
       //objetos da classe FuncionarioHorista, FuncionarioMensalista
       //e FuncionarioComissionado
       dep1.addFuncionario(funcHor);
       dep1.addFuncionario(funcMen);
       dep2.addFuncionario(funcCom);
       
       System.out.println("O funcionario " + funcHor.getNome() +
                          " trabalha no departamento de " + 
                          funcHor.getDepartamento().getNome()); 
        
       
       System.out.println("O funcionario " + funcMen.getNome() +
                          " trabalha no departamento de " +
                          funcMen.getDepartamento().getNome());
       
      
       
       
       System.out.println("O funcionario " + funcCom.getNome() + 
                          " trabalha no departamento " +
                          funcCom.getDepartamento().getNome());
       
       
       dep1.listar();
       dep2.listar();
               
          
       //estabelecendo a associação binária
       //entre 1 objeto da classe Projeto
       //com 1 ou mais objetos da classe Funcionario 
       //(Horista, Mensalista, Comissionado)
       proj.addFuncionario(funcHor);
       proj.addFuncionario(funcMen);
       proj.addFuncionario(funcCom);
          
       proj.listar();
    }
}
