
package fatec.poo.model;
import java.math.MathContext;

/**
 *
 * @author 0030481723013
 */
public class Circulo {
    private double raio;
    //private double pi = 3.1415;
    
    public void setRaio(double arg) {
        raio = arg;
    }
    
    public double getRaio() {
        return raio;
    }
    
    public double calcArea() {
        return (Math.PI*(raio*raio));
    }
    
    public double calcPerimetro() {
        return (2*Math.PI*raio);
    }
    
    public double calcDiametro() {
        return (2*raio);
    }
}
