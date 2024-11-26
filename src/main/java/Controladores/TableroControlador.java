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
    private ControladorBase base;
    
    @Override
    public void run() {
        vista=new Tablero(this);
    }

    public TableroControlador(ControladorBase base) {
        this.base = base;
    }

    public Tablero getVista() {
        return vista;
    }
    
    public void mostrarInfo(Curso curso){      
        vista.mostrarTitulo(curso.getNombre());
    }
    
    public void mostrarTemario(){
        base.mostrarTemario();
    }
    public void mostrarCursos(){
        base.regresarCursos();
    }
    public void mostrarTutorias(){
        base.mostrarTutorias();
    }
    public void mostrarProgreso(){
        base.mostrarProgreso();
    }
}
