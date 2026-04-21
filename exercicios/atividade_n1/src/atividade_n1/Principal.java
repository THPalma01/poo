package atividade_n1;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Diite o nome do console: ");
        String nomeConsole = scanner.nextLine();
        System.out.print("Digite o ano de lancamento do console: ");
        int anoLancamento = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha
        System.out.print("Digite o nome do fabricante: ");
        String nomeFabricante = scanner.nextLine();

        Console console = new Console(nomeConsole, anoLancamento, nomeFabricante);

        System.out.print("Digite o nome do jogo: ");
        String nomeJogo = scanner.nextLine();
        System.out.print("Digite a quantidade de jogadores: ");
        int qtdJogadores = scanner.nextInt();
        System.out.print("O jogo e online? (true/false): ");
        boolean online = scanner.nextBoolean();

        Jogo jogo = new Jogo(nomeJogo, qtdJogadores, online);
        console.setJogo(jogo);

        console.dados();

        scanner.close();
    }
}