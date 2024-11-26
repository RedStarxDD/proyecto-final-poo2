/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Pregunta;
import Modelos.Tema;
import Repositorios.CursoProgressManager;
import Repositorios.PreguntaRepository;
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
    
    @Override
    public void run() {
        vista=new PreguntasVista(this);
    }

    public PreguntasControlador(ControladorBase base) {
        this.base = base;
    }

    public PreguntasVista getVista() {
        return vista;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }
      
    public void listarPreguntas(Tema tema){
        PreguntaRepository preguntaRepository=new PreguntaRepository();
        preguntas=preguntaRepository.findByTemaId(tema.getId());
        vista.mostrarInfo();            
    }
    
    public void aumentarProgreso(int contador){
        CursoProgressManager cursoProgressManager=new CursoProgressManager();
        cursoProgressManager.marcarPreguntaCompletada(preguntas.get(contador-1).getId());
        
    }
    
    public void mostrarTemas(){
        base.mostrarTemario();
    }
}
