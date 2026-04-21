package atividade02;

public class Produto {
    private int codigo;
    private String descricao;
    private float preco;

    public Produto(String descricao, float preco) {
        this.descricao = descricao;
        this.preco = preco;
        this.codigo = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void aumento(float valor) {
        this.preco += valor;
    }

    @Override
    public String toString() {
        return "Produto [Codigo: " + codigo + ", Descricao: " + descricao + ", Preco: " + String.format("%.2f", preco) + "]";
    }
}
