package colecoes;

public class Principal {

    public static void main(String[] args) {
       Proprietario p = new Proprietario();

        p.adicionarVeiculo(new Veiculo("RHA-2025", 63500));
        p.adicionarVeiculo(new Veiculo("XYZ-7741", 120000));
        p.adicionarVeiculo(new Veiculo("BRS-1123", 54000));
        p.adicionarVeiculo(new Veiculo("JTP-9854", 87000));
        p.adicionarVeiculo(new Veiculo("JTP-9854", 87000));
        p.adicionarVeiculo(new Veiculo("KLM-4587", 38000));
        p.adicionarVeiculo(new Veiculo("TXP-3201", 99000)); 

        p.setNome("Rhian Oliveira");

        System.out.println("=== Veiculos de " + p.getNome() + " ===");
        p.getVeiculos().forEach(v -> {
            System.out.println("Placa: " + v.getPlaca());
            System.out.println("Valor: R$ " + v.getValor());
            System.out.println("Hash: " + v.hashCode());
            System.out.println("========================");
        });

        System.out.println("Total de bens: R$ " + p.calcularValorTotal());
    }
}
