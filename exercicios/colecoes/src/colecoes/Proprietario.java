package colecoes;

import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

public class Proprietario {
    private String nome;
    private String cpf;
    private Set<Veiculo> veiculos = new HashSet<>();

    public void adicionarVeiculo(Veiculo v) {
        if (existeVeiculo(v)) {
            JOptionPane.showMessageDialog(null, "Veiculo duplicado: " + v.getPlaca());
            return;
        }

        if (veiculos.size() < 5) {
            veiculos.add(v);
        } else {
            int resp = JOptionPane.showConfirmDialog(
                    null,
                    "Você ja possui " + veiculos.size() + " veiculos.\nDeseja incluir mais este mesmo?",
                    "Confirmacao",
                    JOptionPane.YES_NO_OPTION
            );
            if (resp == JOptionPane.YES_OPTION) {
                veiculos.add(v);
            }
        }
    }

    public void excluirVeiculo(Veiculo v) {
        if (veiculos.remove(v)) {
            JOptionPane.showMessageDialog(null, "Veiculo removido: " + v.getPlaca());
        } else {
            JOptionPane.showMessageDialog(null, "Veiculo não encontrado: " + v.getPlaca());
        }
    }

    public float calcularValorTotal() {
        float total = 0;
        for (Veiculo v : veiculos) {
            total += v.getValor();
        }
        return total;
    }

    private boolean existeVeiculo(Veiculo v) {
        for (Veiculo aux : veiculos) {
            if (aux.getPlaca().equalsIgnoreCase(v.getPlaca())) {
                return true;
            }
        }
        return false;
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

    public Set<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Set<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}
