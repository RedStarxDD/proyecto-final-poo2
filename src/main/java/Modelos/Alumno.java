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
public class Alumno extends Usuario{
    private ArrayList<Curso> cursos;

    public Alumno(ArrayList<Curso> cursos, String id, String correo, String contrasena, String nombre) {
        super(id, correo, contrasena, nombre);
        this.cursos = cursos;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }
    
    
}
