/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma4_1703_colecoes;

import java.util.HashSet;

/**
 *
 * @author Aluno
 */
public class Pessoa2 {
    private String nome;
    //agregacao com coleção
    private HashSet<Telefone> telefones = new HashSet<>();
    
    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public HashSet<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(HashSet<Telefone> telefones) {
        this.telefones = telefones;
    }
    
    //métodos da classe
    public void addTelefone(Telefone t) {
        //adicionar um telefone na coleção
        telefones.add(t);
    }
    
    public Telefone removeTelefone(String numero) {
        //quem será procurado
        Telefone procura = new Telefone(numero, null);
        
        //varre todos os telefones
        for (Telefone aux : telefones) {
            //verifica se é igual
            if(aux.equals(procura)) {
                //atribui o objeto encontrado para a var 'procura'
                procura = aux;
                break; //não precisa continuar
            }
        }
    
        //remove o telefone
        telefones.remove(procura);
        //devolve o telefone removido
        return procura;
    }
    
    public String[] listaDeTelefone() {
        //devolve um ARRAY de String com todos os telefones
        //cria um array do tamanho da coleção
        String[] tels = new String[telefones.size()];
        //varre toda a coleção
        int i = 0;
        for (Telefone t : telefones) {
            //insere no array e já incrementa
            tels[i++] = t.getNumero();
        }
        
        //devolve
        return tels;
        

    }
}
