
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

        FuncionarioHorista funchor = 
                new FuncionarioHorista(1010, "Pedro Silveira", "14/05/1978",
                        15.80); 
        FuncionarioMensalista funcmen = 
                new FuncionarioMensalista(1011, "João da Silva", "22/03/1993", 
                        3);
        funchor.apontarHoras(90);
        funcmen.apontarValSalMin(998.00);
        funchor.setCargo("Ninja");
        funcmen.setCargo("Shinobi");

        System.out.println("Funcionario Horista\n");
        System.out.println("Nome    =>  " +  funchor.getNome());
        System.out.println("Data Admissão    =>  " +  funchor.getDtAdmissao());
        System.out.println("Registro    =>  " +  funchor.getRegistro());
        System.out.println("Cargo    =>  " +  funchor.getCargo());
        System.out.println("Salario Bruto    =>  " +  df.format(funchor.calcSalBruto()));
        System.out.println("Gratificação          =>  " +  df.format(funchor.calcGratificacao()));
        System.out.println("Desconto          =>  " +  df.format(funchor.calcDesconto()));
        System.out.println("Salario Liquido  =>  " + df.format(funchor.calcSalLiquido()));

        System.out.println("Funcionario Mensalista\n");

        System.out.println("Nome    =>  " +  funcmen.getNome());
        System.out.println("Data Admissão    =>  " +  funcmen.getDtAdmissao());
        System.out.println("Registro    =>  " +  funcmen.getRegistro());
        System.out.println("Cargo    =>  " +  funcmen.getCargo());
        System.out.println("Salario Bruto    =>  " +  df.format(funcmen.calcSalBruto()));
        System.out.println("Desconto          =>  " +  df.format(funcmen.calcDesconto()));
        System.out.println("Salario Liquido  =>  " + df.format(funcmen.calcSalLiquido()));

    }
    
}
