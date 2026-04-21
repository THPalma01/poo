package atividade02;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Cadastro de Produto ");

        System.out.println("\nCadastro de MEDICAMENTO ");

        System.out.print("Codigo: ");
        int codMed = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Descricao: ");
        String descMed = scanner.nextLine();

        System.out.print("Preco inicial (R$): ");
        float precoMed = scanner.nextFloat();
        scanner.nextLine();

        System.out.print("Principio Ativo: ");
        String princAtivo = scanner.nextLine();

        System.out.print("Tarja Preta? (true/false): ");
        boolean tarjaPreta = scanner.nextBoolean();
        scanner.nextLine();

        Medicamento meuMedicamento = new Medicamento(descMed, precoMed, princAtivo, tarjaPreta);
        meuMedicamento.setCodigo(codMed);

        System.out.println("\n Informacoes Iniciais do Medicamento ");
        System.out.println(meuMedicamento);

        System.out.print("\nValor de aumento a ser aplicado ao Medicamento: ");
        float valorAumentoMed = scanner.nextFloat();
        meuMedicamento.aumento(valorAumentoMed);

        System.out.println("\n Informaooes do Medicamento Apos Aumento ");
        System.out.println(meuMedicamento);
        
        System.out.println("\n\nCadastro de Produto de HIGIENE ");
        
        System.out.print("Codigo: ");
        int codHig = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Descricao: ");
        String descHig = scanner.nextLine();

        System.out.print("Preco inicial: ");
        float precoHig = scanner.nextFloat();
        scanner.nextLine();

        System.out.print("Uso (ex: Corporal, Bucal): ");
        String usoHig = scanner.nextLine();

        Higiene minhaHigiene = new Higiene(descHig, precoHig, usoHig);
        minhaHigiene.setCodigo(codHig);

        System.out.println("\n Informacoes Iniciais do Produto de Higiene ");
        System.out.println(minhaHigiene);
        
        System.out.print("\nValor de aumento a ser aplicado ao Produto de Higiene: ");
        float valorAumentoHig = scanner.nextFloat();
        minhaHigiene.aumento(valorAumentoHig);

        System.out.println("\n Informacoes do Produto de Higiene Apos Aumento ");
        System.out.println(minhaHigiene);

        scanner.close();
    }
}
