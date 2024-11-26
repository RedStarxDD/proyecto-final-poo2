/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Curso;
import Servicios.UsuarioServicio;
import Vistas.ProgresoVista;
import core.Controller;

/**
 *
 * @author user
 */
public class ProgresoControlador extends Controller{
    private ProgresoVista vista;
    private ControladorBase base;

    @Override
    public void run() {
        vista=new ProgresoVista(this);
    }

    public ProgresoControlador(ControladorBase base) {
        this.base = base;
    }

    public ProgresoVista getVista() {
        return vista;
    }
    
    public void buscarProgreso(String nombre){
        UsuarioServicio usuarioServicio=new UsuarioServicio();
        String id=usuarioServicio.buscarAlumnoPorNombre(nombre);
        vista.eliimarFilas();
            
        if(!id.isEmpty()){
            for (Curso curso : usuarioServicio.obtenerCursosAlumno(id)) {
                vista.añadirFilas(curso.getNombre(), curso.getProgreso());
            }                   
        }else{
            vista.mostrarMensaje("Ningún alumno encontrado");
        }
        
        
    }
    
    public void mostrarInicio(){
        base.regresarProgreso();
    }
}
