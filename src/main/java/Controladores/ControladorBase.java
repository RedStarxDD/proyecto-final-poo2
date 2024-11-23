/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Repositorios.InicioSesionRepositorio;
import Modelos.Alumno;
import Modelos.Profesor;
import Modelos.Usuario;
import core.Controller;


public class ControladorBase extends Controller {

    private InicioSesionControlador inicioSesionControlador = new InicioSesionControlador(this);
    private InicioProfesorControlador inicioProfesorControlador = new InicioProfesorControlador();
    private CursosControlador cursosControlador = new CursosControlador(this);
    private TableroControlador tableroControlador=new TableroControlador();

    @Override
    public void run() {
        inicioSesionControlador.run();
        cursosControlador.run();
        inicioProfesorControlador.run();
        tableroControlador.run();
    }

    public void decidirUsuario(Usuario usuario) {
        inicioSesionControlador.getVista().setVisible(false);
        String correo = usuario.getCorreo();
        
        if (usuario instanceof Alumno) {
            cursosControlador.setAlumno(usuario);
            cursosControlador.getVista().setVisible(true);
        } else {
            inicioProfesorControlador.getVista().setVisible(true);
        }
    }
    
    public void mostrarTablero(int id){
        cursosControlador.getVista().setVisible(false);
        tableroControlador.getVista().setVisible(true);
        tableroControlador.mostrarInfo(id);
    }
}
