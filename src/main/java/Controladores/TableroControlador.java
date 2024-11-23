/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Curso;
import Modelos.Sesion;
import Modelos.Tema;
import Vistas.Tablero;
import core.Controller;
import java.util.List;

/**
 *
 * @author user
 */
public class TableroControlador extends Controller{
    private Tablero vista;
    private Curso curso;
    
    @Override
    public void run() {
        vista=new Tablero(this);
    }

    public Tablero getVista() {
        return vista;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public void mostrarInfo(int id){
        Curso curso=new Curso(String.valueOf(id), "Razonamiento matemático", null, 0, null);
        vista.mostrarTitulo(curso.getNombre());
        //Aqui se buscaría el curso con el id respectivo en la base de datos
    }
}
