/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Sesion;
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
    
    public void listarSesiones(){
        List<Sesion> sesionesTemp;
        Sesion sesion1=new Sesion("1", "Conteo de cuadriláteros", "", false);
        Sesion sesion2=new Sesion("2", "Operaciones con fracciones", "", false);
        sesionesTemp=List.of(sesion1,sesion2);
        sesiones=sesionesTemp;
        vista.mostrarInfo();
    }
    
    public void mostrarTemario(){
        base.regresarTablero();
    }
}
