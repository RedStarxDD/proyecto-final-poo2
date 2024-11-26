/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Pregunta;
import Modelos.Tema;
import Repositorios.CursoProgressManager;
import Repositorios.PreguntaRepository;
import Servicios.CursoServicio;
import Vistas.PreguntasVista;
import core.Controller;
import java.util.List;

/**
 *
 * @author user
 */
public class PreguntasControlador extends Controller{
    private PreguntasVista vista;
    private ControladorBase base;
    private List<Pregunta> preguntas;
    private CursoServicio cursoServicio;
    
    @Override
    public void run() {
        vista=new PreguntasVista(this);
    }

    public PreguntasControlador(ControladorBase base) {
        this.base = base;
        cursoServicio=new CursoServicio();
    }

    public PreguntasVista getVista() {
        return vista;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }
      
    public void listarPreguntas(Tema tema){
        preguntas=cursoServicio.buscarPreguntaPorIdTema(tema.getId());
        vista.mostrarInfo();            
    }
    
    public void aumentarProgreso(int contador){
        cursoServicio.marcarPreguntaCompletada(preguntas.get(contador-1).getId());
        
    }
    
    public void mostrarTemas(){
        base.mostrarTemario();
    }
}
