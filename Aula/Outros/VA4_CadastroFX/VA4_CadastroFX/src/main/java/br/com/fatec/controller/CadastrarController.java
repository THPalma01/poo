
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

/**
 * FXML Controller class
 *
 * @author guilh
 */
public class CadastrarController implements Initializable {

    @FXML
    private Button btn_cadastrar;
    @FXML
    private Button btn_exibir;
    @FXML
    private Button btn_remover;
    @FXML
    private Button btn_somar;
    @FXML
    private ComboBox<Produto> cmb_prods;

    /**
     * Initializes the controller class.
     */
    
    
     //variáveis auxiliares
    //Cria a coleção para armazenar os dados da combo
    private ObservableList<Produto> produtos =
            FXCollections.observableArrayList();
    @FXML
    private TextField txt_cod;
    @FXML
    private TextField txt_qtd;
    @FXML
    private TextField txt_preco;
    @FXML
    private TextField txt_descricao;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    
    
    //Botão pra cadastrar
    @FXML
   private void btn_cadastrar_Click(ActionEvent event) {
       int codigo, qtdEstoque;
       double preco;
       String Descricao = txt_descricao.getText();
       
        try {
            codigo = Integer.parseInt(txt_cod.getText());
            preco = Integer.parseInt(txt_preco.getText());
            qtdEstoque = Integer.parseInt(txt_qtd.getText());
            
            if (Descricao.isEmpty()){
                mensagem("Preencha a descrição !");
            }
      
            
        Produto p = new Produto(codigo, Descricao, preco, qtdEstoque);

        produtos.add(p);
        cmb_prods.setItems(produtos);

        txt_cod.clear();
        txt_descricao.clear();
        txt_preco.clear();
        txt_qtd.clear();
         }
        
    catch(NumberFormatException ex){
            mensagem("Por favor insira numeros nos campos: Codigo, preço e quantidade em estoque");
            return;
    }
   
}
   
    //Botão pra exibir
    @FXML
    private void btn_exibir_Click(ActionEvent event) {
        if(cmb_prods.getValue() == null){
            mensagem("Por favor, selecione um produto");
           
        }else{
            Produto p = cmb_prods.getValue();
            mensagem("Código: " + p.getCodProduto() + "\n" +
                     "Descricao :" + p.getDescricao() + "\n" +
                     "Preço: " + p.getPreco() + "\n" + 
                     "Quantidade em estoque: " + p.getQtdEstoque());
        }
    }
    
    
    //Botão pra remover
    @FXML
    private void btn_remover_Click(ActionEvent event) {
        if(cmb_prods.getValue() == null){
            mensagem("Selecione um item para apagar");
        }
        else{
          Produto p = cmb_prods.getValue();
          produtos.remove(p);
        }
    }
    
    //Botão pra somar
    @FXML
    private void btn_somar_Click(ActionEvent event) {
        double soma = 0.0;
      
        for (Produto p : cmb_prods.getItems()){
            soma += p.getPreco() ;
        }
        
        mensagem("Preço total dos itens: " + soma);
    }
    
    
     private void mensagem(String msg) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Mensagem");
        alerta.setHeaderText(msg);
        alerta.setContentText("");
        alerta.showAndWait(); //exibe a mensage
    }
    
}




