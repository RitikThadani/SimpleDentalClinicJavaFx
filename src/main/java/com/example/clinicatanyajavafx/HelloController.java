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

import static com.example.clinicatanyajavafx.MainControl.usuarioExiste;

/**
 * Clase que controla nuestra interfaz principal.
 */

public class HelloController{
    @FXML
    private TextField userField;

    @FXML
    private PasswordField passField;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    private Button dentistButton;

    /**
     * Método para loguear al usuario, comprueba si existe, y si es así se procede a la siguiente ventana; en caso
     * contrario saltará un aviso:
     */

    public void loguear(){
        if(usuarioExiste(userField.getText(),passField.getText())){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PrincipalUser.fxml"));
            Parent root;
            try {
                root = fxmlLoader.load();
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
     * Método para abrir la pestaña para registrarse.
     */

    public void abrirRegistrar(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Registro.fxml"));
        Parent root;
        try {
            root = fxmlLoader.load();
            Stage ventana = new Stage();
            Scene scene = new Scene(root);
            ventana.setTitle("Register!");
            ventana.setScene(scene);
            ventana.show();
            cerrarVentanaRegis();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método para abrir la pestaña para loguear a los dentistas.
     */

    public void abrirDent(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginDentist.fxml"));
        Parent root;
        try {
            root = fxmlLoader.load();
            Stage ventana = new Stage();
            Scene scene = new Scene(root);
            ventana.setTitle("Hi!");
            ventana.setScene(scene);
            ventana.show();
            cerrarVentanaDent();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Métodos que cierran la ventana.
     */

    /*
    Para cerrar con el boton de "Register".
     */

    public void cerrarVentanaRegis(){
        Stage ventanaPrincipal = (Stage) registerButton.getScene().getWindow();
        ventanaPrincipal.close();
    }

    /*
    Para cerrar con el boton de "Login".
     */

    public void cerrarVentanaLog(){
        Stage ventanaPrincipal = (Stage) loginButton.getScene().getWindow();
        ventanaPrincipal.close();
    }

    /*
    Para cerrar con el boton de "Dentist".
     */

    public void cerrarVentanaDent(){
        Stage ventanaPrincipal = (Stage) dentistButton.getScene().getWindow();
        ventanaPrincipal.close();
    }

}