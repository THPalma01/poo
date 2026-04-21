package br.com.fatec.controller;

import br.com.fatec.model.Produto;
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

public class ProdController implements Initializable {

    @FXML
    private Button btnAdicionar;
    @FXML
    private Button btnRemover;
    @FXML
    private Button btnExibir;
    @FXML
    private Button btnSomar;
    @FXML
    private ComboBox<Produto> cbProduto;
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtQtde;
    @FXML
    private TextField txtDescricao;
    @FXML
    private TextField txtPreco;

    private ObservableList<Produto> produtos = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbProduto.setItems(produtos);
    }

    @FXML
    private void btnAdicionar_Click(ActionEvent event) {
        int codigo, qtd;
        double preco;
        String descricao = txtDescricao.getText();

        try {
            codigo = Integer.parseInt(txtCodigo.getText());
            qtd = Integer.parseInt(txtQtde.getText());
            preco = Double.parseDouble(txtPreco.getText()); 

            if (descricao.isEmpty()) {
                mensagem("Preencha a descrição!");
                return; 
            }

            Produto p = new Produto(codigo, qtd, preco, descricao);
            produtos.add(p);
            limparCampos();
            mensagem("Produto cadastrado com sucesso!");

        } catch (NumberFormatException e) {
            mensagem("Erro: Verifique se Código, Qtd e Preço são números válidos.");
        }
    }

    @FXML
    private void btnRemover_Click(ActionEvent event) {
        Produto produtoSelecionado = cbProduto.getValue();

        if (produtoSelecionado != null) {
            produtos.remove(produtoSelecionado);
            mensagem("Produto removido!");
            cbProduto.getSelectionModel().clearSelection();
        } else {
            mensagem("Selecione um produto na lista para remover.");
        }
    }

    @FXML
    private void btnExibir_Click(ActionEvent event) {
        Produto p = cbProduto.getValue();

        if (p != null) {
            String msg = "Código: " + p.getCodProduto() + "\n"
                    + "Descrição: " + p.getDescricao() + "\n"
                    + "Preço: R$ " + p.getPreco() + "\n"
                    + "Estoque: " + p.getQtdEstoque();
            
            mensagem(msg);
        } else {
            mensagem("Selecione um produto para exibir os detalhes.");
        }
    }

    @FXML
    private void btnSomar_Click(ActionEvent event) {
        double soma = 0.0;

        for (Produto p : produtos) {
            soma += p.getPreco() * p.getQtdEstoque(); 
        }

        mensagem("Valor total em estoque: R$ " + soma);
    }

    private void mensagem(String msg) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Aviso");
        alerta.setHeaderText(null); 
        alerta.setContentText(msg);
        alerta.showAndWait();
    }
    
    private void limparCampos() {
        txtCodigo.clear();
        txtDescricao.clear();
        txtPreco.clear();
        txtQtde.clear();
    }
}