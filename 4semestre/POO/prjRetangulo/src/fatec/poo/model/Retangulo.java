
package fatec.poo.model;

/**
 *
 * @author 0030481723013
 */
public class Retangulo {
    private double base;
    private double altura;
    
    public void setAltura(double arg) {
        altura = arg;
    }
    
    public void setBase(double arg) {
        base = arg;
    }
    
    public double getBase() {
        return base;
    }
        
    public double getAltura() {
        return altura;
    }
    
    public double calcArea() {
        return base*altura;
    }
    
    public double calcPerimetro() {
        return (2 * (base + altura));
    }
    
}
