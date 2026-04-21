/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ma4_1703_colecoes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class Principal {

    public static void main(String[] args) {
        //Colecao_String();
        //Colecao_Objeto();
        Colecao_Agregacao();
    }
    
    /**
     * este método testa o uso de objetos dentro de uma coleção
     */
    public static void Colecao_Objeto() {
        LinkedList<Pessoa> pessoas = new LinkedList<>();
        
        //cria uma pessoa
        Pessoa p = new Pessoa("Pedro Antonio", "(11)98356 - 4598");
        //adiciona na coleção
        pessoas.add(p);
        
        //cria outra pessoa
        p = new Pessoa("Samuel Brito", "(17) 99345 - 7825");
        pessoas.add(p);
        
        //exibindo os dados
        listaDados(pessoas);
        
        //Procurando pessoas
        Scanner teclado = new Scanner(System.in);
        System.out.println("Informe o Nome a Procurar: ");
        String procura = teclado.nextLine();
        
        //cria o objeto para procura
        Pessoa pes = new Pessoa(procura, null);
        
        procura(pes, pessoas);
    }
    
    public static void Colecao_String() {
        //coleções usando String
        ArrayList <String> array_nomes = new ArrayList<>();
        HashSet <String> hash_nomes = new HashSet<>();
        
        //adicionando dados no List
        array_nomes.add("Carlos");
        array_nomes.add("Maria");
        array_nomes.add("Antonio");
        //insere na primeira posição
        array_nomes.add(0, "Zumira");
        
        //adicionando dados no Set
        hash_nomes.add("Carlos");
        hash_nomes.add("Maria");
        hash_nomes.add("Antonio");
        //insere na primeira posição (não tem como fazer, pois
                                    //não existe indice)
        //hash_nomes.add(0, "Zumira");
        hash_nomes.add("Zumira");

        //listar os dados
        listaDados(array_nomes);
        listaDados(hash_nomes);
        
        listaDadosGenerico(array_nomes);
        listaDadosGenerico(hash_nomes);
    } //aqui termina a coleção String
    
    public static void Colecao_Agregacao() {
        //cria uma pessoa
        Pessoa2 p = new Pessoa2();
        
        //cria 3 telefones e armazena em P
        Telefone t = new Telefone("(11)94025-1454", "Claro");
        p.addTelefone(t);
        
        t = new Telefone("(11)98711-0010", "Vivo");
        p.addTelefone(t);
        
        t = new Telefone("(11)92147-1487", "Tim");
        p.addTelefone(t);
        
        //listar todos os telefones
        for (String aux : p.listaDeTelefone()) {
            System.out.println("Telefone: " + aux);
        }
        
        //removendo um telefone
        p.removeTelefone("(11)98711-0010");
        
        System.out.println("Depois da Remoção");
        //listar todos os telefones
        for (String aux : p.listaDeTelefone()) {
            System.out.println("Telefone: " + aux);
        }
    }
    
    //Pesquisando Objetos
    /**
     * Este método faz uma pesquisa dentro de uma Coleção qualquer
     * LEMBRE-SE: Você terá que reprogramar os métodos 
     *            EQUALS() e HASHCODE()
     * Métodos utilizados:
     *  Contains() : Só verifica se existe
     *  IndexOf() : Devolve o indice do dado procurado, (-1) se não 
     *              encontrar
     * @param p 
     * @param dados 
     */
    public static void procura(Pessoa p, LinkedList<Pessoa> dados) {
        
        //comparação com o Contains()
        //somente verifica se a Pessoa 'p' existe em 'dados
        if(dados.contains(p)){
            System.out.println("Encontrei a Pessoa " + p.getNome());
            dados.forEach((aux) -> {
                //faz a comparação da Pessoa 'p' com a coleção
                if(aux.equals(p)) {
                    System.out.println("Telefone: " + aux.getTelefone());
                }
            });
        }
        else
            System.out.println(p.getNome() + " Não Encontrado!!!");
        
        //---------------------------------------------------------
        //comparação com indexOf()
        int posicao = dados.indexOf(p);
        if(posicao != -1) { //achou
            Pessoa aux = dados.get(posicao);
            System.out.println("Achou...");
            System.out.println("Telefone: " + aux.getTelefone());
        }
    }
    
    //listando coleções
    public static void listaDados(LinkedList<Pessoa> dado) {
        System.out.println("Listando Pessoas========================");
        for (Pessoa pessoa : dado) {
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Telefone: " + pessoa.getTelefone());
        }
    }
    
    public static void listaDadosGenerico(Collection<String> dado) {
        for (String aux : dado) {
            System.out.println("Nome: " + aux);
        }
    }
    
    public static void listaDados(ArrayList<String> dado) {
        //listando usando o comando foreach / enhanced for

        System.out.println("Listando ================ ");
        for (String aux : dado) {
            System.out.println("Nome: " + aux);
        }
    }
    
    public static void listaDados(HashSet<String> dado) {
        //listando usando o comando foreach / enhanced for
        System.out.println("Listando ================ ");
        /*
        for (String aux : dado) {
            System.out.println("Nome: " + aux);
        }
        */
        
        //usando expressões Lambda
        dado.forEach(aux -> 
            {
                System.out.println("Nome: " + aux);
            }
        );
    }
}
