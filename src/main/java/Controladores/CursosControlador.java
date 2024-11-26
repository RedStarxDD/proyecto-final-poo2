/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Curso;
import Repositorios.AlumnoRepository;
import Vistas.CursosVista;
import core.Controller;
import java.util.List;

/**
 *
 * @author user
 */
public class CursosControlador extends Controller{
    private CursosVista vista;
    private ControladorBase base;
    private List<Curso> cursos;

    @Override
    public void run() {
        vista=new CursosVista(this);
    }

    public CursosControlador(ControladorBase base) {
        this.base = base;
    }

    public CursosVista getVista() {
        return vista;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public void listarCursos(String id){
        AlumnoRepository alumnoRepository=new AlumnoRepository();
        cursos=alumnoRepository.obtenerCursosAlumno(id);
        vista.mostrarInfo();
    }
    
    public void abrirTablero(int pos){       
        base.mostrarTablero(cursos.get(pos));
    }
}
