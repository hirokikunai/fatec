package fatec.poo.model;

/**
 *
 * @author bruno
 */
public class Aluno {
    private double NotaProva1, NotaProva2, NotaTrabalho1, NotaTrabalho2;
    private Integer RA;
    
    public void setRa(int r){
        RA=r;
    }

    public void setNotaProva1(double p1){
        NotaProva1 = p1;
    }
    
    public void setNotaProva2(double p2){
        NotaProva2 = p2;
    }
    
    public void setNotatrabalho1(double t1){
        NotaTrabalho1 = t1;
    }
    
    public void SetNotaTrabalho2(double t2){
        NotaTrabalho2 = t2;
    }    
    
    public int getRa(){
        return(RA);
    }
    
    public double getNotaProva1(){
        return(NotaProva1);
    }
    
    public double getNotaProva2(){
        return(NotaProva2);
    }
    
    public double getNotaTrabalho1(){
        return(NotaTrabalho1);
    }
    
    public double getNotaTrabalho2(){
        return(NotaTrabalho2);
    }
    
    public double calcMediaProva(){
        return(0.75  * (NotaProva1 + 2 * NotaProva2)/3);
    }
    
    public double calcMediaTrab(){
        return(0.25 * (NotaTrabalho1 + NotaTrabalho2)/2);
    }
    
    public double calcMediaFinal(){
        return(calcMediaProva() + calcMediaTrab());
    } 
    
    public boolean isAprovado() {
        return (this.calcMediaFinal()>=6);            
    }
    
}
