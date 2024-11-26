/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author user
 */
public class Usuario {
    private String id;
    private String correo;
    private String contrasena;
    private String nombre;

    public Usuario(String id, String correo, String contrasena, String nombre) {
        this.id = id;
        this.correo = correo;
        this.contrasena = contrasena;
        this.nombre = nombre;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método para validar el correo
    public boolean tieneCorreoValido() {
        return correo != null && correo.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    // Método para validar la contraseña (ejemplo: mínimo 8 caracteres)
    public boolean tieneContrasenaValida() {
        return contrasena != null && contrasena.length() >= 8;
    }


}
