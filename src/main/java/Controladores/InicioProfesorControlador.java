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

    @Override
    public void run() {
        vista=new InicioProfesor(this);
    }

    public InicioProfesor getVista() {
        return vista;
    }
    
    
}
