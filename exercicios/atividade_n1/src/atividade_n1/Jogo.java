package atividade_n1;

public class Jogo {
    private String nome;
    private int qtdJogadores;
    private boolean online;

    public Jogo() {}

    public Jogo(String nome, int qtdJogadores, boolean online) {
        this.nome = nome;
        this.qtdJogadores = qtdJogadores;
        this.online = online;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdJogadores() {
        return qtdJogadores;
    }

    public void setQtdJogadores(int qtdJogadores) {
        this.qtdJogadores = qtdJogadores;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public void exibirDados() {
        System.out.println("\n Jogo: ");;
        System.out.println("Nome: " + nome);
        System.out.println("Quantidade de Jogadores: " + qtdJogadores);
        System.out.println("Online: " + (online ? "Sim" : "Não"));
    }
}