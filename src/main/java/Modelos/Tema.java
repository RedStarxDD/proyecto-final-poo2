/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.List;

/**
 *
 * @author user
 */
public class Tema {
    private String id, titulo;
    private List<Pregunta> preguntas;
    private double progreso;

    public Tema(String id, String titulo, List<Pregunta> preguntas, double progreso) {
        this.id = id;
        this.titulo = titulo;
        this.preguntas = preguntas;
        this.progreso = progreso;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public double getProgreso() {
        return progreso;
    }

    public void setProgreso(double progreso) {
        this.progreso = progreso;
    }
    
    
}
