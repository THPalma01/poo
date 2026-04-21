package br.com.fatec.model;

public class Produto {
    
    private int codProduto, qtdEstoque;
    private double preco;
    private String descricao;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + this.codProduto;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        return this.codProduto == other.codProduto;
    }

    @Override
    public String toString() {
        return descricao;
    }

    public Produto() {
    }
    
    public Produto(int codProduto, int qtdEstoque, double preco, String descricao) {
        this.codProduto = codProduto;
        this.qtdEstoque = qtdEstoque;
        this.preco = preco;
        this.descricao = descricao;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
