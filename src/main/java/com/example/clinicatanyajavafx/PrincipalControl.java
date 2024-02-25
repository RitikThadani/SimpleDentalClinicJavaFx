package com.example.clinicatanyajavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PrincipalControl {

    @FXML
    private Button backButton;

    /**
     * Método para cancelar el registro. Nos permitirá volver a la ventana inicial.
     */

    public void goBack(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Inicio.fxml"));
        Parent root;
        try {
            root = fxmlLoader.load();
            Stage ventana = new Stage();
            Scene scene = new Scene(root);
            ventana.setTitle("Hello!");
            ventana.setScene(scene);
            ventana.show();
            cerrarVentanaCanc();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void cerrarVentanaCanc(){
        Stage ventanaPrincipal = (Stage) backButton.getScene().getWindow();
        ventanaPrincipal.close();
    }
}
