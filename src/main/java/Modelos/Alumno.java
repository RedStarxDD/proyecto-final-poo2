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
public class Alumno extends Usuario {
    private ArrayList<Curso> cursos;

    // Constructor
    public Alumno(ArrayList<Curso> cursos, String id, String correo, String contrasena, String nombre) {
        super(id, correo, contrasena, nombre); // Llamada al constructor de la clase padre (Usuario)
        this.cursos = cursos != null ? cursos : new ArrayList<>();
    }

    // Constructor sin cursos para cuando se crea un nuevo alumno
    public Alumno(String id, String correo, String contrasena, String nombre) {
        this(new ArrayList<>(), id, correo, contrasena, nombre);
    }

    // Getters y Setters
    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos != null ? cursos : new ArrayList<>();
    }

    public void agregarCurso(Curso curso) {
        if (curso != null && !cursos.contains(curso)) {
            cursos.add(curso);
        }
    }

    public void eliminarCurso(Curso curso) {
        cursos.remove(curso);
    }

    public boolean estaCursando(String cursoId) {
        return cursos.stream()
                .anyMatch(curso -> curso.getId().equals(cursoId));
    }

    public double getProgresoTotal() {
        if (cursos.isEmpty()) return 0.0;

        return cursos.stream()
                .mapToDouble(Curso::getProgreso)
                .average()
                .orElse(0.0);
    }

}
