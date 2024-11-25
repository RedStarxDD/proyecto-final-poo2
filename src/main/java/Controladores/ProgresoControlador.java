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

    @Override
    public void run() {
        vista=new Progreso(this);
    }

    public Progreso getVista() {
        return vista;
    }
    
    public void buscarProgreso(){
        
    }
}
