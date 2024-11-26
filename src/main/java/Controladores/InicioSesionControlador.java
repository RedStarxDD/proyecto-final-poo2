package Controladores;

import Modelos.Alumno;
import Modelos.Profesor;
import Modelos.Usuario;
import Repositorios.AlumnoRepository;
import Repositorios.ProfesorRepository;
import Repositorios.UsuarioRepository;
import Vistas.IniciodeSesión;
import core.Controller;

public class InicioSesionControlador extends Controller {
    private IniciodeSesión vista;
    private ControladorBase base;
    private final UsuarioRepository usuarioRepository=new UsuarioRepository();
    private final AlumnoRepository alumnoRepository=new AlumnoRepository();
    private final ProfesorRepository profesorRepository=new ProfesorRepository();

    @Override
    public void run() {
        vista = new IniciodeSesión(this);
        vista.setVisible(true);
    }

    public InicioSesionControlador(ControladorBase base) {
        this.base = base;
    }

    public IniciodeSesión getVista() {
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
            System.out.println("No se encontró ningún usuario");
        }
    }
    
    public void alertarUsuario(String message){
        vista.alertaUsuario(message);
    }
    public void alertarContra(String message){
        vista.alertaContra(message);
    }
}