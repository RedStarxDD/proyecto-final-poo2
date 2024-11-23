/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Alumno;
import Modelos.Curso;
import Modelos.Usuario;
import Vistas.Cursos;
import core.Controller;
import java.util.List;

/**
 *
 * @author user
 */
public class CursosControlador extends Controller{
    private Cursos vista;
    private ControladorBase base;
    private Usuario alumno;

    @Override
    public void run() {
        vista=new Cursos(this);
    }

    public CursosControlador(ControladorBase base) {
        this.base = base;
    }

    public Cursos getVista() {
        return vista;
    }

    public Usuario getAlumno() {
        return alumno;
    }

    public void setAlumno(Usuario alumno) {
        this.alumno = alumno;
    }

    public List<Curso> listarCursos(){
        List<Curso> cursos;
        Curso curso1=new Curso("1", "Razonamiento matemático", null, 0, null);
        Curso curso2=new Curso("2", "Historia", null, 0, null);
        cursos=List.of(curso1, curso2);
        return cursos;
        
        //Aquí se llamaría al sql y se retornaría una lista de cursos
    }
    
    public void abrirTablero(int idCurso){
        base.mostrarTablero(idCurso);
    }
}
