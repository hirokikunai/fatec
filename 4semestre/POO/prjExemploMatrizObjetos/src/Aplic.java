
import fatec.poo.model.Retangulo;
import java.util.Scanner;

/**
 *
 * @author dimas
 */
public class Aplic {
    public static void main(String[] args) {
        double medAlt, medBase;
        int x;
        Scanner entrada = new Scanner(System.in);
        
        //Definição da matriz de objetos
        Retangulo[] matRet = new Retangulo[5];

        for (x=0; x < matRet.length; x++){
            System.out.println("Digite a medida da altura: ");
            medAlt = entrada.nextDouble();
            System.out.println("Digite a medida da base: ");
            medBase = entrada.nextDouble();
        
            //instanciação do objeto da classe Retangulo
            //chamada do método construtor
            matRet[x] = new Retangulo(medAlt,medBase);
        }
        
        
        for (x=0; x < matRet.length; x++){
            System.out.println("\n\nObjeto Retangulo " + (x+1));
            System.out.println("Altura: " + matRet[x].getAltura());
            System.out.println("Base: " + matRet[x].getBase());
            System.out.println("Área: " + matRet[x].calcArea());
            System.out.println("Perímetro: " + matRet[x].calcPerimetro());
            System.out.println("Diagonal: " + matRet[x].calcDiagonal());
        }
            
    }
    
}
