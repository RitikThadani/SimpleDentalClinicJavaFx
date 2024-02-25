package com.example.clinicatanyajavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.example.clinicatanyajavafx.MainControl.actualizarUsuario;
import static com.example.clinicatanyajavafx.PrincipalDentistaControl.selectedUser;

public class ControlCambioNombre {

    @FXML
    private TextField newnameField;

    @FXML
    private Button cancelButton;

    @FXML
    private Button changeButton;

    public void cambiarNombre(){
        actualizarUsuario(selectedUser,newnameField.getText());
        cerrarVentanaChan();
    }

    public void cerrarVentanaChan(){
        Stage ventanaPrincipal = (Stage) changeButton.getScene().getWindow();
        ventanaPrincipal.close();
    }

    public void cerrarVentanaCanc(){
        Stage ventanaPrincipal = (Stage) cancelButton.getScene().getWindow();
        ventanaPrincipal.close();
    }
}
