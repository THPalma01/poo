package br.com.fatec.controller;

import br.com.fatec.model.Atividade;
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


public class ProvaPOOController implements Initializable {
    
    @FXML
    private Button btnAdicionar;
    @FXML
    private Button btnRemover;
    @FXML
    private Button btnExibir;
    @FXML
    private Button btnTotal;
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtTitulo;
    @FXML
    private TextField txtTipo;
    @FXML
    private TextField txtVagas;
    @FXML
    private ComboBox <Atividade> cbAtividade;
    
    ObservableList <Atividade> atividades = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }   
    
    
    @FXML
    private void btnAdicionar_Click(ActionEvent event) {
        
        int codigo = 0;
        int vagas = 0;
        String titulo = txtTitulo.getText();
        String tipo = txtTipo.getText();
        
        if( txtTitulo.getText().isEmpty() || txtTipo.getText().isEmpty()) {
            showMessage("Preencha todos os campos");
            return;
        }
        
        try {
            codigo = Integer.parseInt(txtCodigo.getText());
            vagas = Integer.parseInt(txtVagas.getText()); 
            
            if (vagas <= 0) { 
                showMessage("Numero de vagas deve ser maior do que 0");
                return;
            } 
        } catch (NumberFormatException e) {
            showMessage("Os campos Codigo e Vagas devem conter numeros inteiros validos");
            return;
        }
        
        for (Atividade a : atividades) {
            if (a.getCodigo() == codigo) {
                showMessage("Já existe uma atividadde com o mesmo código");
                return;
            }
        }
        
        Atividade atividade = new Atividade(codigo, vagas, titulo, tipo);        
        atividades.add(atividade);
        cbAtividade.setItems(atividades);
        txtCodigo.clear();
        txtTitulo.clear();
        txtTipo.clear();
        txtVagas.clear();
        
        showMessage("Atividade adicionada com sucesso");
    }
    @FXML
    private void btnRemover_Click(ActionEvent event) {
        
        Atividade atividade = cbAtividade.getValue();
        
        if (atividade == null) {
            showMessage("Selecione uma atividade");
            return;
        }
        
        atividades.remove(atividade);
        txtCodigo.clear();
        txtTitulo.clear();
        txtTipo.clear();
        txtVagas.clear();
        
        showMessage("Atividade removida com sucesso");
    }
    @FXML
    private void btnExibir_Click(ActionEvent event) {
        
        Atividade atividade = cbAtividade.getValue();
        
        if (atividade == null) {
            showMessage("Selecione uma atividade");
            return;
        }
        
        txtCodigo.setText(Integer.toString(atividade.getCodigo()));
        txtTitulo.setText(atividade.getTitulo());
        txtTipo.setText(atividade.getTipo());
        txtVagas.setText(Integer.toString(atividade.getVagas()));
    }
    @FXML
    private void btnTotal_Click(ActionEvent event) {
        
        int totalVagas = 0;
    
        for (Atividade a : atividades) {
            totalVagas += a.getVagas();
        }
        
        String mensagem = "O total de vagas em todas as atividades cadastradas é de: " + totalVagas;
        showMessage(mensagem);
    }
    
    public void showMessage(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ALERTA");
        alert.setContentText(msg);
        alert.show();
    }
}
