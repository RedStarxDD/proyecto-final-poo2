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
    private InicioProfesorControlador inicioProfesorControlador = new InicioProfesorControlador(this);
    private CursosControlador cursosControlador = new CursosControlador(this);
    private TableroControlador tableroControlador=new TableroControlador(this);
    private TemarioControlador temarioControlador=new TemarioControlador(this);
    private TutoriasControlador tutoriasControlador=new TutoriasControlador(this);
    private ProgresoControlador progresoControlador=new ProgresoControlador(this);

    @Override
    public void run() {
        inicioSesionControlador.run();
        cursosControlador.run();
        inicioProfesorControlador.run();
        tableroControlador.run();
        temarioControlador.run();
        tutoriasControlador.run();
        progresoControlador.run();
    }

    public void decidirUsuario(Usuario usuario) {
        inicioSesionControlador.getVista().setVisible(false);
        String correo = usuario.getCorreo();
        
        if (usuario instanceof Alumno) {
            //Aquí buscariamos los cursos del usuario y se lo pasaríamos al controlador
            cursosControlador.listarCursos();
            cursosControlador.getVista().setVisible(true);
        } else {
            inicioProfesorControlador.getVista().setVisible(true);
        }
    }
    
    public void regresarCursos(){
        tableroControlador.getVista().setVisible(false);
        cursosControlador.getVista().setVisible(true);
    }
    
    public void mostrarTablero(String nombre){
        cursosControlador.getVista().setVisible(false);
        tableroControlador.getVista().setVisible(true);
        tableroControlador.mostrarInfo(nombre);
    }
    
    public void regresarTablero(){
        if(tutoriasControlador.getVista().isVisible()) 
            tutoriasControlador.getVista().setVisible(false);
        if(temarioControlador.getVista().isVisible()) 
            temarioControlador.getVista().setVisible(false);
        tableroControlador.getVista().setVisible(true);
    }
    
    public void mostrarTemario(String titulo){
        tableroControlador.getVista().setVisible(false);
        temarioControlador.getVista().setVisible(true);
        temarioControlador.mostrarInfo(titulo);
        //Aquí buscaríamos los temas del curso y se lo pasaríamos al controlador
    }
        
    public void mostrarTutorias(){
        tableroControlador.getVista().setVisible(false);
        tutoriasControlador.getVista().setVisible(true);
        tutoriasControlador.listarSesiones();
    }
    
    public void mostrarProgreso(){
        if(tableroControlador.getVista().isVisible())
            tableroControlador.getVista().setVisible(false);
        if(inicioProfesorControlador.getVista().isVisible())
            inicioProfesorControlador.getVista().setVisible(false);
        
        progresoControlador.getVista().setVisible(true);       
        progresoControlador.getVista().activarBuscador(false);
    }
    
    public void regresarProgreso(){
        progresoControlador.getVista().setVisible(false);
        
        //inicioProfesorControlador.getVista().setVisible(true);
        tableroControlador.getVista().setVisible(true);
    }
}
