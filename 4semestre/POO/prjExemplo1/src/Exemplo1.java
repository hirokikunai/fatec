
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Exemplo1 {

    public static void main(String[] args) {
        Scanner Entrada = new Scanner(System.in);
        int Ra;
        double NtPrv1, NtPrv2, Media;
        String Nome;
        
        System.out.println("Digite o Ra: ");
        Ra = Entrada.nextInt();
        System.out.println("Digite o nome: ");
        Nome = Entrada.next(); // Entrada de uma sequencia de caracteres sem 
                               // espaços
        System.out.println("Digite a 1a Nota: ");
        NtPrv1 = Entrada.nextDouble();
        System.out.println("Digita a 2a Nota: ");
        NtPrv2 = Entrada.nextDouble();
        Media = (NtPrv1 + NtPrv2)/2;
        System.out.println("Media: " + Media);
        
        if (Media >= 6) {
            System.out.println("Situação aprovação");
        } else {
            System.out.println("Situação reprovado");
        }
    }
    
}
