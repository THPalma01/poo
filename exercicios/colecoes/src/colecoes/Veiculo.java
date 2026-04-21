package colecoes;

import java.util.Objects;

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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Veiculo veiculo = (Veiculo) obj;
        return placa != null && placa.equalsIgnoreCase(veiculo.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa == null ? "" : placa.toUpperCase());
    }

    @Override
    public String toString() {
        return "Placa: " + placa + " | Valor: R$ " + valor;
    }
}
