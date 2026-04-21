/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma4_1703_colecoes;

import java.util.Objects;

/**
 *
 * @author Aluno
 */
public class Telefone {
    private String numero;
    private String operadora;
    
    //Tem que reprogramar sempre o EQUALS e HASHCODE, quando a classe
    //fizer parte de uma coleção

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.numero);
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
        final Telefone other = (Telefone) obj;
        return Objects.equals(this.numero, other.numero);
    }

    //getters e setters
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }
    
    //contrutores
    public Telefone() {
    }

    public Telefone(String numero, String operadora) {
        this.numero = numero;
        this.operadora = operadora;
    }
    
    
  
    
    
}
