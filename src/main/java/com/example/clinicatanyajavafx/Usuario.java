package com.example.clinicatanyajavafx;

import javax.persistence.*;

/**
 * Clase Usuario.
 */

@Entity
@Table(name = "usuarios")
public class Usuario {

    /**
     * Atributos de la clase usuario.
     */

    @Id
    @Column(name = "DNI", length = 9)
    private String dni;

    @Column(name = "nombre", length = 20)
    private String nombre;

    @Column(name = "apellidos", length = 20)
    private String apellidos;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "userName", length = 20)
    private String userName;

    @Column(name = "contra", length = 20)
    private String contra;

    /**
     * Constructor vacío.
     */

    public Usuario() {
    }

    /**
     * Constructor con todos los campos.
     * @param dni
     * @param nombre
     * @param apellidos
     * @param email
     * @param userName
     * @param contra
     */

    public Usuario(String dni, String nombre, String apellidos, String email, String userName, String contra) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.userName = userName;
        this.contra = contra;
    }

    /*
    Getters y Setters.
     */

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
}
