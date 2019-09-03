package fatec.poo.model;

/**
 *
 * @author dimas
 */
public class Retangulo {
    private double altura;
    private double base;
    
    //definição do método construtor
    public Retangulo(double a, double b){
        altura = a;
        base = b;
    }
    
    
    public double getAltura(){
        return(altura);
    }
    
    public double getBase(){
        return(base);
    }
    
    public double calcArea(){
        return(altura * base);
    }
    
    public double calcPerimetro(){
        return(2*(altura + base));
    }
    
    public double calcDiagonal(){
        return(Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2)));
    }
}
