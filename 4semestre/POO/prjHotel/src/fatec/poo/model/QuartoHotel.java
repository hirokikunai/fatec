package fatec.poo.model;

/**
 *
 * @author bruno
 */
public class QuartoHotel {
    private int _NumQuarto;
    private double _ValorDiaria;
    private int _NumRG;
    private boolean _Situacao;
    private double _TotalFaturado;
    
    public QuartoHotel(int NumQuarto, double ValorDiaria){
        this._NumQuarto = NumQuarto;
        this._ValorDiaria = ValorDiaria;
        this._Situacao = false;        
    }
    
    public void reservar (int NumRG) {
        this._NumRG = NumRG;
        this._Situacao = true;
    }
    
    public double liberar (int Dias) {
        double ValorASerPago;
        ValorASerPago = Dias*this._ValorDiaria;
        this._TotalFaturado += (this._TotalFaturado + ValorASerPago);
        this._NumRG = 0;
        this._Situacao = false;
        return ValorASerPago;      
    }
    
    public boolean getSituacao(){
        return this._Situacao;
    }
    
    public double getTotalFaturado() {
        return this._TotalFaturado;
    }
    
    public int getNumQuarto(){
        return this._NumQuarto;
    }
    
    
    
    
    
}
