
import fatec.poo.model.FuncionarioHorista;
import fatec.poo.model.FuncionarioMensalista;
import java.text.DecimalFormat;


/**
 *
 * @author bruno
 */
public class Aplic {
    public static void main(String[] args) {
        //Instanciação 
        DecimalFormat df = new DecimalFormat("R$ 00.00");

        FuncionarioHorista funchor= new FuncionarioHorista(1010,
                                                          "Pedro Silveira",
                                                          "14/05/1978",
                                                          15.80); 
        FuncionarioMensalista funcmen = new FuncionarioMensalista(1011, 
                                                              "João da Silva",
                                                                      "22/03/1993", 3);
        funchor.apontarHoras(90);
        funcmen.apontarValSalMin(998.00);

        System.out.println("Funcionario Horista\n");

        System.out.println("Salario Bruto    =>  " +  df.format(funchor.calcSalBruto()));
        System.out.println("Desconto          =>  " +  df.format(funchor.calcDesconto()));
        System.out.println("Salario Liquido  =>  " + df.format(funchor.calcSalLiquido()));

        System.out.println("Funcionario Mensalista\n");

        System.out.println("Salario Bruto    =>  " +  df.format(funcmen.calcSalBruto()));
        System.out.println("Desconto          =>  " +  df.format(funcmen.calcDesconto()));
        System.out.println("Salario Liquido  =>  " + df.format(funcmen.calcSalLiquido()));

    }
    
}
