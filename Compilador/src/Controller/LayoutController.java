/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author luis.oliveira
 */
public class LayoutController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtInfixa;
    
    @FXML
    private TextField txtPosfixa;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void converte() {
      txtPosfixa.setText(txtInfixa.getText());
      /*Alert alerta = new Alert(AlertType.ERROR);
      alerta.setTitle("Compilador está iniciado com sucesso!");
      alerta.setHeaderText(null);
      alerta.setContentText("O Brasil é nosso!");
      alerta.showAndWait();*/
    }
}
