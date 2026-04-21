import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

public class Proprietario {
    private String nome, cpf;
    private HashSet<Veiculo> veiculos = new HashSet<>();

    public void addVeiculo(Veiculo v) {
        if(existeVeiculo(v)) { //se não existir duplicado
            JOptionPane.showMessageDialog(null, "Veículo duplicado");
            return;
        }
    
        if(veiculos.size() < 5) {
            //adiciona o veículo dentro da coleção
            veiculos.add(v);
        }
        else {
            int resp;
            resp = JOptionPane.showConfirmDialog(null, 
                    "Tem certeza que deseja adicionar mais um veículo? ", 
                    "Mensagem ao Usuário", JOptionPane.YES_NO_OPTION);
            if(resp == JOptionPane.YES_OPTION) {
                veiculos.add(v);
            }
        } 
    
    }

    public float valorBens() {
        //usando iterador
        Iterator<Veiculo> it = veiculos.iterator();
        
        float somatoria = 0;
        
        while(it.hasNext()) { //verifica se tem um próximo objeto
            Veiculo aux = it.next(); //pega o próximo objeto
            somatoria += aux.getValor();
        }
        
        //usando o foreach
        somatoria = 0;
        for (Veiculo aux : veiculos) {
            somatoria += aux.getValor();
        }
        
        return somatoria;
    }

    private boolean existeVeiculo(Veiculo v) {
        for (Veiculo aux : veiculos) {
            if(aux.getPlaca() == v.getPlaca())
                return true;
        }
        
        return false;
    }
     public void removeVeiculo(String placa) {
        boolean removido = veiculos.removeIf(proprietario -> proprietario.getPlaca().equalsIgnoreCase(placa));
        if (removido)
            System.out.println(" Veículo removido com sucesso.");
        else
            System.out.println(" Nenhum veículo encontrado com a placa informada! ");
    }
      public void listarVeiculos() {
        System.out.println(" Lista de Veiculos : ");
        for (Veiculo v  : veiculos) {
            System.out.println(v);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
   
    
}