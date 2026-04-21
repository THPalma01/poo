package br.com.fatec.model;

public class Cliente {
    
    private int codCliente;
    private String nome;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.codCliente;
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
        final Cliente other = (Cliente) obj;
        return this.codCliente == other.codCliente;
    }

    @Override
    public String toString() {
        return codCliente + " - " + nome;
    }

    public Cliente() {
    }

    public Cliente(int codCliente, String nome) {
        this.codCliente = codCliente;
        this.nome = nome;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
