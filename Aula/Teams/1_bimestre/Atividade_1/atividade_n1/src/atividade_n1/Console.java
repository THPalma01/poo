package atividade_n1;

public class Console {
    private String nome;
    private int anoLancamento;
    private Fabricante fabricante; 
    private Jogo jogo;             

    public Console() {}

    public Console(String nome, int anoLancamento, String nomeFabricante) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.fabricante = new Fabricante(nomeFabricante);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }
    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Jogo getJogo() {
        return jogo;
    }
    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public void dados() {
        System.out.println("\nConsole e Fabricante: ");
        System.out.println("Console: " + nome);
        System.out.println("Ano de Lancamento: " + anoLancamento);
        System.out.println("Fabricante: " + fabricante.getNome());
        if (jogo != null) {
            jogo.exibirDados();
        }
    }
}