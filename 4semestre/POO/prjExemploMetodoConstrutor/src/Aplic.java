
import fatec.poo.model.Retangulo;
import java.util.Scanner;

/**
 *
 * @author dimas
 */
public class Aplic {
    public static void main(String[] args) {
        double medAlt, medBase;
        Scanner entrada = new Scanner(System.in);
       

        System.out.println("Digite a medida da altura: ");
        medAlt = entrada.nextDouble();
        System.out.println("Digite a medida da base: ");
        medBase = entrada.nextDouble();
        
        //instanciação do objeto da classe Retangulo
        //chamada do método construtor
        Retangulo objRet = new Retangulo(medAlt,medBase);
        
        
        
        System.out.println("\n\nAltura: " + objRet.getAltura());
        System.out.println("Base: " + objRet.getBase());
        System.out.println("Área: " + objRet.calcArea());
        System.out.println("Perímetro: " + objRet.calcPerimetro());
        System.out.println("Diagonal: " + objRet.calcDiagonal());
    
            
    }
    
}
