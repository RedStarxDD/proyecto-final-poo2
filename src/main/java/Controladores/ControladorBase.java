/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Main.Alumno;
import Main.Profesor;
import Main.Usuario;
import core.Controller;

/**
 *
 * @author user
 */
public class ControladorBase extends Controller{
    private InicioSesionControlador inicioSesionControlador=new InicioSesionControlador(this);
    private CursosControlador cursosControlador=new CursosControlador();
    private InicioProfesorControlador inicioProfesorControlador=new InicioProfesorControlador();

    @Override
    public void run() {
        inicioSesionControlador.run();
        cursosControlador.run();
        inicioProfesorControlador.run();
    }
    
    public void decidirUsuario(Usuario usuario){
        inicioSesionControlador.getVista().setVisible(false);
        
        if(usuario instanceof Alumno){
            cursosControlador.getVista().setVisible(true);
        }else if(usuario instanceof Profesor){
            inicioProfesorControlador.getVista().setVisible(true);
        }
    }
}
