/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Curso;
import Modelos.Sesion;
import Repositorios.SesionRepository;
import Servicios.CursoServicio;
import Vistas.TutoriasVista;
import core.Controller;
import java.awt.Desktop;
import java.net.URI;
import java.util.List;

/**
 *
 * @author user
 */
public class TutoriasControlador extends Controller{
    private TutoriasVista vista;
    private ControladorBase base;
    private List<Sesion> sesiones;

    @Override
    public void run() {
        vista=new TutoriasVista(this);
    }

    public TutoriasControlador(ControladorBase base) {
        this.base = base;
    }
    
    public TutoriasVista getVista() {
        return vista;
    }

    public List<Sesion> getSesiones() {
        return sesiones;
    }
    
    public void listarSesiones(Curso curso){
        SesionRepository sesionRepository=new SesionRepository();       
        sesiones=sesionRepository.findByCursoId(curso.getId());
        vista.mostrarInfo();
    }
    
    public void mostrarTemario(){
        base.regresarTablero();
    }
    
    public void abrirVideo(int id) {
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(new URI(sesiones.get(id).getVideo()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
