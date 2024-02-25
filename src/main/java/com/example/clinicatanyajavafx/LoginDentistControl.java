package com.example.clinicatanyajavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.clinicatanyajavafx.MainControl.*;

public class LoginDentistControl {

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passField;

    @FXML
    private Button cancelButton;

    @FXML
    private Button loginButton;

    public static String dentistaEnUso;

    /**
     * Método para loguear al dentista, comprueba si existe, y si es así se procede a la siguiente ventana; en caso
     * contrario saltará un aviso:
     */

    public void loguear(){
        if(dentistaExiste(userField.getText(),passField.getText())){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PrincipalDentista.fxml"));
            Parent root;
            try {
                root = fxmlLoader.load();
                PrincipalDentistaControl controlador=fxmlLoader.getController();
                controlador.init(dentistaEnUso=getNombreDentista(userField.getText()));
                Stage ventana = new Stage();
                Scene scene = new Scene(root);
                ventana.setTitle("Welcome!");
                ventana.setScene(scene);
                ventana.show();
                cerrarVentanaLog();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            Alert a  = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Incorrect username or password!");
            a.setTitle("Warning!");
            a.setHeaderText(null);
            a.showAndWait();
        }
    }

    /**
     * Método para cancelar el registro. Nos permitirá volver a la ventana inicial.
     */

    public void cancelar(){
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

    /**
     * Método que cierra la ventana.
     */

    /*
    Para cerrar con el boton de "Cancel".
     */

    public void cerrarVentanaCanc(){
        Stage ventanaPrincipal = (Stage) cancelButton.getScene().getWindow();
        ventanaPrincipal.close();
    }

    /*
    Para cerrar con el boton de "Login".
     */

    public void cerrarVentanaLog(){
        Stage ventanaPrincipal = (Stage) loginButton.getScene().getWindow();
        ventanaPrincipal.close();
    }
}
