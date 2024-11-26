/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vistas.Progreso;
import core.Controller;

/**
 *
 * @author user
 */
public class ProgresoControlador extends Controller{
    private Progreso vista;
    private ControladorBase base;

    @Override
    public void run() {
        vista=new Progreso(this);
    }

    public ProgresoControlador(ControladorBase base) {
        this.base = base;
    }

    public Progreso getVista() {
        return vista;
    }
    
    public void buscarProgreso(){
        
    }
    
    public void mostrarInicio(){
        base.regresarProgreso();
    }
}
