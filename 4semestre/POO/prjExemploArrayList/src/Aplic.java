
import fatec.poo.model.Circulo;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author dimas
 */
public class Aplic {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);        
        ArrayList<Circulo> circulos = new ArrayList(); 
        //Instanciação objeto da classe ArrayList
        double medRaio;
        Circulo objCirc;

        System.out.println("Digite a medida do raio: ");
        medRaio = entrada.nextDouble();
        while (medRaio > 0){
           
            objCirc = new Circulo(medRaio);
            circulos.add(objCirc);
            
            System.out.println("Digite a medida do raio: ");
            medRaio = entrada.nextDouble();
        }
        
        for (int x=0; x<circulos.size(); x++){
            System.out.println("Objeto Circulo " + (x+1));
            System.out.println("Raio: " + circulos.get(x).getRaio());
            System.out.println("Area: " + circulos.get(x).calcArea());
            System.out.println("Diametro: " + circulos.get(x).calcDiametro());
            System.out.println("Perimetro: " + circulos.get(x).calcPerimetro());
        }
    }      
}








