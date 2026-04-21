import java.util.*;
import javax.swing.JOptionPane;
public class Veiculo {
    private String placa;
    private float valor;

    public Veiculo() {
    }

    public Veiculo(String placa, float valor) {
        this.placa = placa;
        this.valor = valor;
    }
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
       @Override
    public String toString() {
    return String.format(placa, valor);
    }
    
}