
package fatec.poo.model;

/**
 *
 * @author 0030481723013
 */
public class Circulo {
    private double raio;
    private double pi = 3.1415;
    
    public void setRaio(double arg) {
        raio = arg;
    }
    
    public double getRaio() {
        return raio;
    }
    
    public double calcArea() {
        return (pi*(raio*raio));
    }
    
    public double calcPerimetro() {
        return (2*pi*raio);
    }
}
