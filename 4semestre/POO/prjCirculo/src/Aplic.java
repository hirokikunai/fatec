
import fatec.poo.model.Circulo;
import java.util.Scanner;

/**
 *
 * @author 0030481723013
 */
public class Aplic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Circulo objCirc = new Circulo();
        double medRaio;
        int opcao;
        
        System.out.println("Digite a medida do raio: ");
        medRaio = entrada.nextDouble();
        
        
        objCirc.setRaio(medRaio);
        
        do {
            System.out.println("\n\n1 - Exibir área");
            System.out.println("2 - Exibir perimetro");
            System.out.println("3 - Exibir diametro");
            System.out.println("4 - Sair");
            System.out.println("\n\n\t Digite a opção: ");
            opcao = entrada.nextInt();
        
            switch(opcao) {
                case 1: 
                    System.out.println("Área: " + objCirc.calcArea() + 
                            "\n Raio: " + objCirc.getRaio());
                    break;
                    
                case 2:
                    System.out.println("Base: " + objCirc.calcPerimetro()+ 
                            "\n Raio: " + objCirc.getRaio());
                    break;
            }

            
        } while (opcao != 4);

    }
    
}
