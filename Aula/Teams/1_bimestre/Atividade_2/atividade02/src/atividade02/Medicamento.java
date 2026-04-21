package atividade02;

public class Medicamento extends Produto {
    private String princAtivo;
    private boolean TarjaPreta;

    public Medicamento(String descricao, float preco, String princAtivo, boolean TarjaPreta) {
        super(descricao, preco);
        this.princAtivo = princAtivo;
        this.TarjaPreta = TarjaPreta;
    }

    public String getPrincAtivo() {
        return princAtivo;
    }

    public void setPrincAtivo(String princAtivo) {
        this.princAtivo = princAtivo;
    }

    public boolean isTarjaPreta() {
        return TarjaPreta;
    }

    public void setTarjaPreta(boolean TarjaPreta) {
        this.TarjaPreta = TarjaPreta;
    }

    @Override
    public void aumento(float valor) {
        super.aumento(valor);
        float precoAtual = this.getPreco();
        float aumentoDezPorcento = precoAtual * 0.10f;
        this.setPreco(precoAtual + aumentoDezPorcento);
    }

    @Override
    public String toString() {
        return super.toString() + "\n  Medicamento [Principio Ativo: " + princAtivo + ", Tarja Preta: " + (TarjaPreta ? "Sim" : "Nao") + "]";
    }
}