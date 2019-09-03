import fatec.poo.model.Aluno;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class prjAluno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.0");
        Aluno objAluno = new Aluno();
        int opcao;
     
        System.out.println("Digite o RA do aluno:");
        objAluno.setRa(entrada.nextInt());
        System.out.println("Digite a nota da 1a Prova:");
        objAluno.setNotaProva1(entrada.nextDouble());
        System.out.println("Digite a nota da 2a Prova:");
        objAluno.setNotaProva2(entrada.nextDouble());
        System.out.println("Digite a nota do 1o Trabalho:");
        objAluno.setNotatrabalho1(entrada.nextDouble());
        System.out.println("Digite a nota do 2o Trabalho:");
        objAluno.SetNotaTrabalho2(entrada.nextDouble());
               
        do{
           System.out.println("\n\n1 - Exibir Média das Provas");
           System.out.println("2 - Exibir Média dos Trabalhos");
           System.out.println("3 - Exibir Média Final");
           System.out.println("4 - Sair");
           System.out.print("\n\n\t Digite a opcao: ");
           opcao = entrada.nextInt();           
           
           System.out.println("\n\nRa: " + objAluno.getRa());           
           switch(opcao){                                     
                case 1: System.out.println("Nota 1a. Prova    : " + df.format(objAluno.getNotaProva1()));
                        System.out.println("Nota 2a. Prova    : " + df.format(objAluno.getNotaProva2()));
                        System.out.println("Média das Provas  : " + df.format(objAluno.calcMediaProva()));
                        break;            
                case 2: System.out.println("Nota 1o. Trabalho : " + df.format(objAluno.getNotaTrabalho1()));
                        System.out.println("Nota 2o. Trabalho : " + df.format(objAluno.getNotaTrabalho2()));
                        System.out.println("Média dos Trabalhos: " + df.format(objAluno.calcMediaTrab()));                        
                        break;
                case 3: System.out.println("Nota 1a. Prova    : " + df.format(objAluno.getNotaProva1()));
                        System.out.println("Nota 2a. Prova    : " + df.format(objAluno.getNotaProva2()));
                        System.out.println("Nota 1o. Trabalho : " + df.format(objAluno.getNotaTrabalho1()));
                        System.out.println("Nota 2o. Trabalho : " + df.format(objAluno.getNotaTrabalho2()));
                        System.out.println("Média Final       : " + df.format(objAluno.calcMediaFinal()));                        
                        System.out.println(objAluno.isAprovado()? "Aprovado": "Reprovado");                        

                        break;
           }
       }while (opcao < 4);   
        
        
    }
    
}
