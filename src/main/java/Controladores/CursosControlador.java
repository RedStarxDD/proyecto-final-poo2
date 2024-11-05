/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Vistas.Cursos;
import core.Controller;

/**
 *
 * @author user
 */
public class CursosControlador extends Controller{
    private Cursos vista;

    @Override
    public void run() {
        vista=new Cursos(this);
    }

    public Cursos getVista() {
        return vista;
    }
    
    
}
