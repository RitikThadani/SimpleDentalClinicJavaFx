package com.example.clinicatanyajavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.clinicatanyajavafx.MainControl.*;

/**
 * Clase RegistroControl, que controla toda la interfaz que tiene que ver con los registros.
 */

public class RegistroControl {

    @FXML
    private TextField dniField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;

    @FXML
    private Button cancelButton;

    /**
     * Método que se utiliza para insertar en la base de datos siempre que al llamar usuarioReptido (para comprobar si
     * el usuario ya está en uso) se devuelva false. Si se devuelve true, se desplegará una ventana con un aviso.
     */

    public void insertar(){
        if(usuarioRepetido(usernameField.getText())) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("The DNI/username already exists!");
            a.setTitle("Warning!");
            a.setHeaderText(null);
            a.showAndWait();
        }else if(dniRepetido(dniField.getText())) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("The DNI/username already exists!");
            a.setTitle("Warning!");
            a.setHeaderText(null);
            a.showAndWait();
        }else{
            Usuario us1=new Usuario(dniField.getText(),nameField.getText(),surnameField.getText(),emailField.getText(),
                    usernameField.getText(),passwordField.getText());
            insertUsuario(us1);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Inicio.fxml"));
            Parent root;
            try {
                root = fxmlLoader.load();
                Stage ventana = new Stage();
                Scene scene = new Scene(root);
                ventana.setTitle("Hello!");
                ventana.setScene(scene);
                ventana.show();
                cerrarVentana();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
            cerrarVentana();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método que cierra la ventana.
     */

    public void cerrarVentana(){
        Stage ventanaPrincipal = (Stage) cancelButton.getScene().getWindow();
        ventanaPrincipal.close();
    }
}
