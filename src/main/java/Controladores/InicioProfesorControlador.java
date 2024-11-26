/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vistas.InicioProfesorVista;
import core.Controller;

/**
 *
 * @author user
 */
public class InicioProfesorControlador extends Controller{
    private InicioProfesorVista vista;
    private ControladorBase base;

    @Override
    public void run() {
        vista=new InicioProfesorVista(this);
    }

    public InicioProfesorControlador(ControladorBase base) {
        this.base = base;
    }

    public InicioProfesorVista getVista() {
        return vista;
    }
    
    public void mostrarProgreso(){
        base.mostrarProgreso();
    }
   
}
