/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Profesor extends Usuario{
    private ArrayList<Alumno> alumnos;

    public Profesor(ArrayList<Alumno> alumnos, String id, String correo, String contrasena, String nombre) {
        super(id, correo, contrasena, nombre);
        this.alumnos = alumnos;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
    
}
