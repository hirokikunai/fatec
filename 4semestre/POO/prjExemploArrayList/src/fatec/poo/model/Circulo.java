package fatec.poo.model;

/**
 *
 * @author dimas
 */
public class Circulo {
    private double raio;
    
    //Método construtor
    //tem o mesmo nome da classe
    //é executado após a instanciação do objeto
    //fornece um estado inicial para o objeto
    //instanciado a partir da atribuição de valores 
    //para um ou mais atributos
    public Circulo(double r){
        raio = r;
    }
    public double getRaio(){
        return(raio);
    }
    public double calcArea(){
        return(Math.PI * Math.pow(raio,2));
    }
    public double calcPerimetro(){
        return(2*Math.PI*raio);
    }
    public double calcDiametro(){
        return(2 * raio);
    }
}
