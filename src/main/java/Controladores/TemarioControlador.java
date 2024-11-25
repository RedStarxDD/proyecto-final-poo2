/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Curso;
import Modelos.Tema;
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
    
    public void mostrarInfo(String titulo){
        List<Tema> temasTemp;
        Tema tema1=new Tema("1", "Conteo de cuadriláteros", null, 0);
        Tema tema2=new Tema("2", "Fracciones", null, 0);
        temasTemp=List.of(tema1,tema2);
        temas=temasTemp;
        vista.mostrarInfo(titulo);
    }
    
    public void mostrarTablero(){
        base.regresarTablero();
    }
    public void mostrarTutorias(){
        base.mostrarTutorias();
    }
}
