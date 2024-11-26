package Controladores;

import Repositorios.AlumnoRepository;
import Repositorios.ProfesorRepository;
import Repositorios.UsuarioRepository;
import Vistas.IniciodeSesiónVista;
import core.Controller;

public class InicioSesionControlador extends Controller {
    private IniciodeSesiónVista vista;
    private ControladorBase base;
    private final UsuarioRepository usuarioRepository=new UsuarioRepository();
    private final AlumnoRepository alumnoRepository=new AlumnoRepository();
    private final ProfesorRepository profesorRepository=new ProfesorRepository();

    @Override
    public void run() {
        vista = new IniciodeSesiónVista(this);
        vista.setVisible(true);
    }

    public InicioSesionControlador(ControladorBase base) {
        this.base = base;
    }

    public IniciodeSesiónVista getVista() {
        return vista;
    }

    public void buscarUsuario(String correo, char[] contra) {
        String contrasena = new String(contra);

        if (usuarioRepository.validarLogin(correo, contrasena)) {
            String id=usuarioRepository.findByCorreo(correo);
            
            if (usuarioRepository.determinarTipoDeUsuario(correo).equalsIgnoreCase("Alumno")) {
                base.decidirUsuario(alumnoRepository.findById(id).get());
            } else {
                base.decidirUsuario(profesorRepository.findById(id).get());
            }
        } else {
            vista.mostrarAlerta("Usuario o contraseña inválidos");
        }
    }
    
    public void alertarUsuario(String message){
        vista.mostrarAlerta(message);
    }
}