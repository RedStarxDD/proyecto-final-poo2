/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Curso;
import Modelos.Tema;
import Repositorios.TemaRepository;
import Vistas.Temario;
import core.Controller;
import java.util.List;

/**
 *
 * @author user
 */
public class TemarioControlador extends Controller{
    private Temario vista;
    private ControladorBase base;
    private List<Tema> temas;

    @Override
    public void run() {
        vista=new Temario(this);
    }

    public TemarioControlador(ControladorBase base) {
        this.base = base;
    }

    public Temario getVista() {
        return vista;
    }

    public List<Tema> getTemas() {
        return temas;
    }
    
    public void mostrarInfo(Curso curso){
        TemaRepository temaRepository=new TemaRepository();
        temas=temaRepository.findByCursoId(curso.getId());
        vista.mostrarInfo(curso.getNombre());
    }
    
    public void mostrarTablero(){
        base.regresarTablero();
    }
    public void mostrarPreguntas(int pos){
        base.mostrarPreguntas(temas.get(pos));
    }
}
