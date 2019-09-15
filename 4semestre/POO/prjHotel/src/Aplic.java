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
        QuartoHotel[] Hotel;
        Hotel = new QuartoHotel[10];
        int opcao, numQuarto;
        double valorDiaria;
        
        for (int contador = 0; contador < 10; contador++) {
            System.out.println("Insira o numero do quarto a reservar: ");
            numQuarto = entrada.nextInt();
            System.out.println("Insira valor da diária");
            valorDiaria = entrada.nextDouble();
            Hotel[contador] = new QuartoHotel(numQuarto,valorDiaria);
        }
        

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
                    System.out.println("Insira o número do quarto: ");
                    numQuarto = entrada.nextInt();
                    for (int contador = 0; contador < 10; contador++) {
                        if (Hotel[contador].getNumQuarto() == numQuarto){
                            System.out.println("Situacao: " + (Hotel[contador].getSituacao()? "Ocupado" : "Livre"));
                        }else{
                            System.out.println("O número desse quarto não foi cadastrado" );
                        }
                    }                    
                    break;
                case 2: 
                    System.out.println("Insira o número do quarto: ");
                    numQuarto = entrada.nextInt();
                    for (int contador = 0; contador < 10; contador++) {
                        if (Hotel[contador].getNumQuarto() == numQuarto){
                            if (Hotel[contador].getSituacao()) {
                                System.out.println("O quarto já foi reservado" );
                            } else {
                                System.out.println("Insira o RG do hóspede: ");
                                Hotel[contador].reservar(entrada.nextInt());
                            }
                        }else{
                            System.out.println("O número desse quarto não foi cadastrado" );
                        }
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

