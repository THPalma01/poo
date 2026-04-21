
public class Principal {

    public static void main(String[] args) {
        Proprietario proprietario = new Proprietario();
        
        proprietario.addVeiculo(new Veiculo("AAA-123", 40000));
        proprietario.addVeiculo(new Veiculo("BBB-123", 50000));
        proprietario.addVeiculo(new Veiculo("CCC-123", 60000));
        proprietario.addVeiculo(new Veiculo("DDD-123", 70000));
        proprietario.addVeiculo(new Veiculo("EEE-123", 80000));
        proprietario.addVeiculo(new Veiculo("FFF-123", 90000));
        proprietario.addVeiculo(new Veiculo("FFF-123", 90000));
        proprietario.addVeiculo(new Veiculo("GGG-123", 100000));
        proprietario.listarVeiculos();

}
   
    }