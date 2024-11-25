/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vistas.InicioProfesor;
import core.Controller;

/**
 *
 * @author user
 */
public class InicioProfesorControlador extends Controller{
    private InicioProfesor vista;
    private ControladorBase base;

    @Override
    public void run() {
        vista=new InicioProfesor(this);
    }

    public InicioProfesorControlador(ControladorBase base) {
        this.base = base;
    }

    public InicioProfesor getVista() {
        return vista;
    }
    
    public void mostrarProgreso(){
        base.mostrarProgreso();
    }
   
}
