/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Alumno;
import Modelos.Curso;
import Repositorios.CursoRepository;
import Vistas.Progreso;
import core.Controller;
import java.util.List;

/**
 *
 * @author user
 */
public class ProgresoControlador extends Controller{
    private Progreso vista;
    private ControladorBase base;

    @Override
    public void run() {
        vista=new Progreso(this);
    }

    public ProgresoControlador(ControladorBase base) {
        this.base = base;
    }

    public Progreso getVista() {
        return vista;
    }
    
    public void buscarProgreso(Alumno alumno){
        vista.eliimarFilas();
        for (Curso curso : alumno.getCursos()) {
            vista.añadirFilas(curso.getNombre(), curso.getProgreso());
        }       
        
    }
    
    public void mostrarInicio(){
        base.regresarProgreso();
    }
}
