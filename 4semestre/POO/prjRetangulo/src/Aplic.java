
import fatec.poo.model.Retangulo;
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
        Retangulo objRet = new Retangulo();
        double medAltura;
        double medBase;
        int opcao;
        
        System.out.println("Digite a medida da altura: ");
        medAltura = entrada.nextDouble();
        
        System.out.println("Digite a medida da base: ");
        medBase = entrada.nextDouble();
        
        objRet.setAltura(medAltura);
        objRet.setBase(medBase);
        
        do {
            System.out.println("\n\n1 - Exibir área retangulo");
            System.out.println("2 - Exibir perimetro retangulo");
            System.out.println("3 - Sair");
            System.out.println("\n\n\t Digite a opção: ");
            opcao = entrada.nextInt();
        
            switch(opcao) {
                case 1: 
                    System.out.println("Área: " + objRet.calcArea() + 
                            "\n Altura: " + objRet.getAltura() + 
                            "\n Base: " + objRet.getBase());
                    break;
                    
                case 2:
                    System.out.println("Base: " + objRet.calcPerimetro()+ 
                            "\n Altura: " + objRet.getAltura() + 
                            "\n Base: " + objRet.getBase());
                    break;
            }

            
        } while (opcao != 3);

        
        
        
    }
    
}
