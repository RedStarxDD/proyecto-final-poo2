/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Modelos.Alumno;
import Modelos.Curso;
import Modelos.Profesor;
import Repositorios.AlumnoRepository;
import Repositorios.ProfesorRepository;
import Repositorios.UsuarioRepository;
import java.util.List;

/**
 *
 * @author user
 */
public class UsuarioServicio {
    private final UsuarioRepository usuarioRepository;
    private final AlumnoRepository alumnoRepository;
    private final ProfesorRepository profesorRepository;

    public UsuarioServicio() {
        this.usuarioRepository = new UsuarioRepository();
        this.alumnoRepository = new AlumnoRepository();
        this.profesorRepository = new ProfesorRepository();
    }
    
    public boolean validarLogin(String txtUser, String txtPass) {
        return usuarioRepository.validarLogin(txtUser, txtPass);
    }
    
    public String buscarPorCorreo(String correo){
        return usuarioRepository.findByCorreo(correo);
    }
    
    public String determinarTipoDeUsuario(String correo) {
        return usuarioRepository.determinarTipoDeUsuario(correo);
    }
    
    public Alumno buscarAlumnoPorId(String id){
        return alumnoRepository.findById(id).get();
    }
    public String buscarAlumnoPorNombre(String nombre){
        if(alumnoRepository.findByName(nombre).isPresent())
            return alumnoRepository.findByName(nombre).get().getId();
        else
            return "";
    }
    
    public Profesor buscarProfesorPorId(String id){
        return profesorRepository.findById(id).get();
    }
    
    public List<Curso> obtenerCursosAlumno(String alumnoId) {
        return alumnoRepository.obtenerCursosAlumno(alumnoId);
    }
}
