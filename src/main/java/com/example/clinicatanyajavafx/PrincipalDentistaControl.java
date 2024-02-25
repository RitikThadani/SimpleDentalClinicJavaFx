package com.example.clinicatanyajavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import static com.example.clinicatanyajavafx.LoginDentistControl.dentistaEnUso;
import static com.example.clinicatanyajavafx.MainControl.*;

//public class PrincipalDentistaControl implements Initializable {
public class PrincipalDentistaControl {

    @FXML
    private TableView<Usuario> tablaUs=new TableView<>();

    @FXML
    private ComboBox optionBox;

    @FXML
    private Button backButton;

    @FXML
    private Label editLabel;

    @FXML
    private Pane panelPerfil;

    public static Usuario selectedUser;

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        optionBox.getItems().addAll("Client List","Register");
//
//        TableColumn<Usuario, String> dni = new TableColumn<>("DNI");
//        dni.setCellValueFactory(new PropertyValueFactory<>("dni"));
//        TableColumn<Usuario, String> nombre = new TableColumn<>("Name");
//        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
//        TableColumn<Usuario, String> apellidos = new TableColumn<>("Surname");
//        apellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
//        tablaUs.getColumns().addAll(dni, nombre, apellidos);
//        ArrayList<Usuario> listado = getUsuarios();
//        tablaUs.getItems().addAll(listado);
//
//        editLabel.setText(dentistaEnUso);
//    }

    public void init(String nombrePersona){
        optionBox.getItems().addAll("Client List","Register");

        TableColumn<Usuario, String> dni = new TableColumn<>("DNI");
        dni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        TableColumn<Usuario, String> nombre = new TableColumn<>("Name");
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        TableColumn<Usuario, String> apellidos = new TableColumn<>("Surname");
        apellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        tablaUs.getColumns().addAll(dni, nombre, apellidos);
        ArrayList<Usuario> listado = getUsuarios();
        tablaUs.getItems().addAll(listado);

        editLabel.setText(nombrePersona);
    }


    /**
     * Método que se usa para que se actualice la ventana según la opción del ComboBox seleccionada.
     */

    public void seleccion(){
        if(optionBox.getSelectionModel().isSelected(0)){
            tablaUs.setVisible(true);
        } else if(optionBox.getSelectionModel().isSelected(1)){
            tablaUs.setVisible(false);
        }
    }

    /**
     * Método para eliminar un usuario seleccionado de la tabla.
     * Después se actualiza la tabla.
     */

    public void eliminar() {
        int selectedRow = tablaUs.getSelectionModel().getSelectedIndex();
        if (tablaUs.getSelectionModel().getSelectedIndex() != -1) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Warning!");
            alert.setHeaderText("Are you sure you want to delete this user?");

            ButtonType siButton = new ButtonType("Yes!");
            ButtonType noButton = new ButtonType("No!");

            alert.getButtonTypes().setAll(siButton, noButton);

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == siButton) {
                Usuario usuario = tablaUs.getSelectionModel().getSelectedItem();
                deleteUser(usuario);
                actualizarTabla();
            }
        }
    }

    /**
     * Método para actualizar la tabla.
     */

    public void actualizarTabla(){
        tablaUs.getItems().clear();
        ArrayList<Usuario> listado = getUsuarios();
        tablaUs.getItems().addAll(listado);
    }

    /**
     * Método para abrir la pestaña para modificar al usuario seleccionado.
     */

    public void abrirMod(){
        int selectedRow = tablaUs.getSelectionModel().getSelectedIndex();
        if (tablaUs.getSelectionModel().getSelectedIndex() != -1) {
            selectedUser=tablaUs.getSelectionModel().getSelectedItem();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CambioNombre.fxml"));
            Parent root;
            try {
                root = fxmlLoader.load();
                Stage ventana = new Stage();
                Scene scene = new Scene(root);
                ventana.setTitle("Change Name!");
                ventana.setScene(scene);
                ventana.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            Alert a  = new Alert(Alert.AlertType.ERROR);
            a.setContentText("You must select an user to modify!");
            a.setTitle("Warning!");
            a.setHeaderText(null);
            a.showAndWait();
        }
    }

    /**
     * Método para cancelar el registro. Nos permitirá volver a la ventana inicial.
     */

    public void goBack(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginDentist.fxml"));
        Parent root;
        try {
            root = fxmlLoader.load();
            Stage ventana = new Stage();
            Scene scene = new Scene(root);
            ventana.setTitle("Hi!");
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

    public void cerrarVentanaCanc(){
        Stage ventanaPrincipal = (Stage) backButton.getScene().getWindow();
        ventanaPrincipal.close();
    }

    public void desplegar(){
        if(panelPerfil.isVisible()){
            panelPerfil.setVisible(false);
        }else if(!(panelPerfil.isVisible())){
            panelPerfil.setVisible(true);
        }
    }
}
