package br.com.fatec.controller;

import br.com.fatec.model.Cliente;
import br.com.fatec.model.Venda;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent; 

public class VendaProdutosController implements Initializable {
    
    @FXML private Button btnIncluir;
    @FXML private Button btnExcluir;
    @FXML private Button btnConsultar;
    @FXML private Button btnLimpar;
    
    @FXML private ComboBox<Cliente> cbCliente;
    @FXML private TextField txtNumVenda;
    @FXML private TextField txtData;
    @FXML private TextField txtValor;
    @FXML private TextField txtQtde;
    @FXML private TextField txtCliente; 

    private ObservableList<Cliente> clientes = FXCollections.observableArrayList();
    private ObservableList<Venda> vendas = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarDados();
        cbCliente.setOnAction(event -> atualizarCodigo());
        txtCliente.setOnKeyReleased(event -> selecionarCliente());
    }    
    
    private void carregarDados() {
        for (int i = 1; i <= 10; i++) {
            Cliente c = new Cliente(i, "Cliente " + i);
            clientes.add(c);
        }
        cbCliente.setItems(clientes);
    }

    private void atualizarCodigo() {
        Cliente selecionado = cbCliente.getValue();
        
        if (selecionado != null) {
            int codigo = selecionado.getCodCliente();
            txtCliente.setText(String.valueOf(codigo));
        }
    }

    private void selecionarCliente() {
        try {
            if (txtCliente.getText().isEmpty()) {
                cbCliente.setValue(null);
                return;
            }

            int codigoDigitado = Integer.parseInt(txtCliente.getText());
            
            for (Cliente c : clientes) {
                if (c.getCodCliente() == codigoDigitado) {
                    cbCliente.setValue(c);
                    return; 
                }
            }
            cbCliente.setValue(null);
        } catch (NumberFormatException e) {
        }
    }

    @FXML 
    private void btnIncluir_Click(ActionEvent event) {
        if (cbCliente.getValue() == null) {
            mensagem("Selecione um cliente.");
            return;
        }
        
        try {
            int num = Integer.parseInt(txtNumVenda.getText());
            String data = txtData.getText();
            float valor = Float.parseFloat(txtValor.getText());
            int qtd = Integer.parseInt(txtQtde.getText());
            Cliente cli = cbCliente.getValue();

            Venda venda = new Venda(num, qtd, data, valor, cli);

            vendas.add(venda);
            
            mensagem("Venda incluída!");
            limparCampos(); 

        } catch (NumberFormatException e) {
            mensagem("Números incorretos.");
        }
    }
    
    @FXML 
    private void btnExcluir_Click(ActionEvent event) {
        if (txtNumVenda.getText().isEmpty()) {
            mensagem("Digite o número da venda");
            return;
        }
        
        try {
            int numProcurado = Integer.parseInt(txtNumVenda.getText());
            Venda vendaParaRemover = null;
    
            for (Venda v : vendas) {
                if (v.getNumVenda() == numProcurado) {
                    vendaParaRemover = v;
                    break; 
                }
            }
    
            if (vendaParaRemover != null) {
                vendas.remove(vendaParaRemover);
                mensagem("Venda removida.");
                limparCampos(); 
            } else {
                mensagem("Venda não encontrada.");
            }
        } catch (NumberFormatException e) {
             mensagem("O número da venda deve ser um valor inteiro");
        }
    }
    
    @FXML 
    private void btnConsultar_Click(ActionEvent event) {
        if (txtNumVenda.getText().isEmpty()) {
            mensagem("Digite o número da venda");
            return;
        }
        
        try {
            int numProcurado = Integer.parseInt(txtNumVenda.getText());
            boolean encontrou = false;
    
            for (Venda v : vendas) {
                if (v.getNumVenda() == numProcurado) {
                    
                    String resultado = "VENDA ENCONTRADA:\n\n" +
                                       "Número: " + v.getNumVenda() + "\n" +
                                       "Data: " + v.getData() + "\n" +
                                       "Valor: " + v.getValor() + "\n" +
                                       "Qtd Peças: " + v.getQtdPecas() + "\n" +
                                       "Cliente: " + v.getCliente().toString(); 
                    
                    mensagem(resultado); 
                    
                    encontrou = true;
                    break;
                }
            }
    
            if (!encontrou) {
                mensagem("Venda não encontrada.");
            }
        } catch (NumberFormatException e) {
            mensagem("O número da venda deve ser um valor inteiro");
        }
    }
    
    @FXML 
    private void btnLimpar_Click(ActionEvent event) {
        vendas.clear();
        limparCampos();
        mensagem("Todos os dados foram apagados.");
    }
    
    private void mensagem(String texto) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Informação");
        alerta.setHeaderText(null); 
        alerta.setContentText(texto);
        alerta.showAndWait();
    }
    
    private void limparCampos() {
        txtNumVenda.clear();
        txtData.clear();
        txtValor.clear();
        txtQtde.clear();
        txtCliente.clear();
        cbCliente.setValue(null);
        txtNumVenda.requestFocus(); 
    }
}