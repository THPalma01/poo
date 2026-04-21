
package br.com.fatec.model;

public class Produto {
    private int codProduto, qtdEstoque;
    double preco;
    private String descricao;
    
    
    @Override
    public String toString(){
        return getDescricao();
    }
    
     //=============================================================================================
    //==============================================================================================
    
    //HashCode e Equals
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.codProduto;
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
     //=============================================================================================
    //==============================================================================================
    
    
    //Construtores
    public Produto() {
    }
 
    public Produto(int codProduto, String descricao, double preco, int qtdEstoque) {
        this.codProduto = codProduto;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
    }
     //=============================================================================================
    //==============================================================================================
  
    //Getter e Setter
    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
   
}
