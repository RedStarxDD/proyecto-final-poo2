/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Curso;
import Modelos.Sesion;
import Repositorios.SesionRepository;
import Vistas.Tutorias;
import core.Controller;
import java.util.List;

/**
 *
 * @author user
 */
public class TutoriasControlador extends Controller{
    private Tutorias vista;
    private ControladorBase base;
    private List<Sesion> sesiones;

    @Override
    public void run() {
        vista=new Tutorias(this);
    }

    public TutoriasControlador(ControladorBase base) {
        this.base = base;
    }
    
    public Tutorias getVista() {
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
}
