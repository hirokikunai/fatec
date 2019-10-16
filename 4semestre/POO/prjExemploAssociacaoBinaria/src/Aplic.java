
import fatec.poo.model.Departamento;
import fatec.poo.model.FuncionarioComissionado;
import fatec.poo.model.FuncionarioHorista;
import fatec.poo.model.FuncionarioMensalista;


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
            
	  
      
      //Estabelecer a associação binária entre 1
      //objeto da classe FuncionarioHorista com
      //1 objeto da classe Departamento
      funcHor.setDepartamento(dep1);
      System.out.println("O funcionario " + funcHor.getNome() + 
              " trabalha no departamento " + funcHor.getDepartamento().getNome());

      
       
        
       //Estabelecer a associação binária entre 1
       //objeto da classe FuncionarioMensalista com
       //1 objeto da classe Departamento
       funcMen.setDepartamento(dep1);
       System.out.println("O funcionario " + funcMen.getNome() + 
              " trabalha no departamento " + funcMen.getDepartamento().getNome());
      
       
      
       
       //Estabelecer a associação binária entre 1
       //objeto da classe FuncionarioComissionado com
       //1 objeto da classe Departamento
       funcCom.setDepartamento(dep1);
       System.out.println("O funcionario " + funcCom.getNome() + 
              " trabalha no departamento " + funcCom.getDepartamento().getNome());       
       
    
    
       //Estabelecer a associação binária entre um
       //objeto da classe Departaqmento com 1 ou mais (1..*)
       //objetos da classe FuncionarioHorista, FuncionarioMensalista
       //e FuncionarioComissionado
       
        
       
    }
    
}
