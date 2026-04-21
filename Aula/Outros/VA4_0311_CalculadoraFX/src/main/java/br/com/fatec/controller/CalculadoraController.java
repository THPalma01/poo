/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.fatec.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class CalculadoraController implements Initializable {

    @FXML
    private TextField txtNumero1;
    @FXML
    private TextField txtNumero2;
    @FXML
    private TextField txtResultado;
    @FXML
    private Button btnSomar;
    @FXML
    private Button btnSubtrair;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnSomar_Click(ActionEvent event) {
        int n1, n2, resultado;
        
        //tenta fazer a conversão
        try {
        n1 = Integer.parseInt(txtNumero1.getText());
        n2 = Integer.parseInt(txtNumero2.getText());
        }
        
        catch (NumberFormatException ex) { //deu errado
            mensagem("Digite somente números\n" + ex.getMessage());
            return; //sai fora
        }
        
        resultado = n1 + n2;
        
        txtResultado.setText(Integer.toString(resultado));
    }

    @FXML
    private void btnSubtrair_Click(ActionEvent event) {
        int n1, n2, resultado;
        
        try {
        n1 = Integer.parseInt(txtNumero1.getText());
        n2 = Integer.parseInt(txtNumero2.getText());
        }
        
        catch (NumberFormatException ex) { //deu errado
            mensagem("Digite somente números\n" + ex.getMessage());
            return; //sai fora
        }
        
        resultado = n1 - n2;
        
        txtResultado.setText(Integer.toString(resultado));
    }
    
    private void mensagem(String msg) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Mensagem");
        alerta.setHeaderText(msg);
        alerta.setContentText("");
        
        alerta.showAndWait(); //exibe a mensagem
    }
    
}