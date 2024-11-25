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
    private List<Curso> cursos;

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

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public void listarCursos(){
        List<Curso> cursosTemp;
        Curso curso1=new Curso("1", "Razonamiento matemático", null, 0, null);
        Curso curso2=new Curso("2", "Historia", null, 0, null);
        cursosTemp=List.of(curso1, curso2);
        cursos=cursosTemp;
        vista.mostrarInfo();
        //Aquí se llamaría al sql y se retornaría una lista de cursos
    }
    
    public void abrirTablero(String idCurso){
        base.mostrarTablero(idCurso);
    }
}
