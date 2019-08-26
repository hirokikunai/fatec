/**
 *
 * @author bruno
 */
public class Exemplo {
    public static void main(String[] args) {
        /**
        *  Definição de uma matriz
        *  formanda por 4 elementos
        *  do tipo double
        */
        int size = 10;

        /* Definição do ponteiro */
        double[] MatNum; 
        double Media = 0;
        int cont;
        
        
        /* Alocação da matriz*/
        MatNum = new double[size]; 
        
        for (cont = 0; cont < MatNum.length; cont++) {
            MatNum[cont] = Math.random() * 100;
        }
        
        for (cont = 0; cont < MatNum.length; cont++) {
            Media = Media + MatNum[cont];
            System.out.println("MatNum[" + cont + "]" + MatNum[cont]);
        }
        
        Media = Media / size;
        System.out.println("\n\nMedia: " + Media);
                   
    }
    
}
