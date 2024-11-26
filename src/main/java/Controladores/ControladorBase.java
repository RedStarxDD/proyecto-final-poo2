/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Alumno;
import Modelos.Curso;
import Modelos.Profesor;
import Modelos.Tema;
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
    private PreguntasControlador preguntasControlador=new PreguntasControlador(this);
    
    private Usuario usuario;
    private Curso curso;
    private Tema tema;

    @Override
    public void run() {
        inicioSesionControlador.run();
        cursosControlador.run();
        inicioProfesorControlador.run();
        tableroControlador.run();
        temarioControlador.run();
        tutoriasControlador.run();
        progresoControlador.run();
        preguntasControlador.run();
    }

    public void decidirUsuario(Usuario user) {
        inicioSesionControlador.getVista().setVisible(false);
        this.usuario=user;
        
        if (usuario instanceof Alumno) {
            //Aquí buscariamos los cursos del usuario y se lo pasaríamos al controlador
            cursosControlador.listarCursos(usuario.getId());
            cursosControlador.getVista().setVisible(true);
        } else {
            inicioProfesorControlador.getVista().setVisible(true);
        }
    }
    
    public void regresarCursos(){
        tableroControlador.getVista().setVisible(false);
        cursosControlador.getVista().setVisible(true);
    }
    
    public void mostrarTablero(Curso c){
        cursosControlador.getVista().setVisible(false);
        this.curso=c;
        tableroControlador.getVista().setVisible(true);
        tableroControlador.mostrarInfo(c);
    }
    
    public void regresarTablero(){
        if(tutoriasControlador.getVista().isVisible()) 
            tutoriasControlador.getVista().setVisible(false);
        if(temarioControlador.getVista().isVisible()) 
            temarioControlador.getVista().setVisible(false);
        tableroControlador.getVista().setVisible(true);
    }
    
    public void mostrarTemario(){
        if(tableroControlador.getVista().isVisible())
            tableroControlador.getVista().setVisible(false);
        if(preguntasControlador.getVista().isVisible())
            preguntasControlador.getVista().setVisible(false);
        
        temarioControlador.getVista().setVisible(true);
        temarioControlador.mostrarInfo(curso);
        //Aquí buscaríamos los temas del curso y se lo pasaríamos al controlador
    }
        
    public void mostrarTutorias(){
        tableroControlador.getVista().setVisible(false);
        tutoriasControlador.getVista().setVisible(true);
        tutoriasControlador.listarSesiones(curso);
    }
    
    public void mostrarProgreso(){
        if(tableroControlador.getVista().isVisible())
            tableroControlador.getVista().setVisible(false);
        if(inicioProfesorControlador.getVista().isVisible())
            inicioProfesorControlador.getVista().setVisible(false);
        
        if(usuario instanceof Profesor)
            progresoControlador.getVista().activarBuscador(true);
        else{
            progresoControlador.getVista().activarBuscador(false);
            progresoControlador.buscarProgreso((Alumno) usuario);
        }
        
        progresoControlador.getVista().setVisible(true);
    }
    
    public void regresarProgreso(){
        progresoControlador.getVista().setVisible(false);
        
        if(usuario instanceof Profesor)
            inicioProfesorControlador.getVista().setVisible(true);
        else
            tableroControlador.getVista().setVisible(true);
    }
    
    public void mostrarPreguntas(Tema t){
        this.tema=t;
        if(tema.getPreguntas().isEmpty()){
            preguntasControlador.getVista().mostrarAlerta();
        }else{
            temarioControlador.getVista().setVisible(false);
            preguntasControlador.getVista().setVisible(true);
            preguntasControlador.listarPreguntas(tema);           
        }
    }
}
