
import fatec.poo.model.QuartoHotel;
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 *
 * @author bruno
 */
public class Aplic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("R$ 00.00");
        int opcao, numQuarto;
        double valorDiaria;
        
        System.out.println("Insira o numero do quarto a reservar: ");
        numQuarto = entrada.nextInt();
        System.out.println("Insira valor da diária");
        valorDiaria = entrada.nextDouble();
        
        QuartoHotel objQuarto = new QuartoHotel(numQuarto,valorDiaria);   
        
        do {
            System.out.println("\n\nHotel Recanto do Sossego");
            System.out.println("\n\n1 - Consultar Quarto");
            System.out.println("2 - Reservar Quarto");
            System.out.println("3 - Liberar Quarto");
            System.out.println("4 - Consultar Faturamento");
            System.out.println("5 - Sair");
            System.out.println("\n\n\t Digite a opção: ");
            opcao = entrada.nextInt();
        
            switch(opcao) {
                case 1: 
                    System.out.println("Situacao: " + (objQuarto.getSituacao()? "Ocupado" : "Livre"));
                    break;
                case 2: 
                    if (objQuarto.getSituacao()) {
                        System.out.println("O quarto já foi reservado" );
                    } else {
                        System.out.println("Insira o RG do hóspede: ");
                        objQuarto.reservar(entrada.nextInt());
                    }
                    break;
                case 3:
                    if (objQuarto.getSituacao()){
                        System.out.println("Insira o número de diárias: ");
                        System.out.println("Valor a pagar: " + df.format(objQuarto.liberar(entrada.nextInt())));
                    } else {
                        System.out.println("O quarto já está livre" );
                    }
                    break;
                case 4:
                    System.out.println("O faturamento do quarto é: " + df.format(objQuarto.getTotalFaturado()));
                    break;
            }
        } while (opcao != 5);
    }
}
