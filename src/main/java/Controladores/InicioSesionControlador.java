package Controladores;

import Servicios.UsuarioServicio;
import Vistas.IniciodeSesiónVista;
import core.Controller;

public class InicioSesionControlador extends Controller {
    private IniciodeSesiónVista vista;
    private ControladorBase base;

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
        UsuarioServicio usuarioServicio=new UsuarioServicio();

        if (usuarioServicio.validarLogin(correo, contrasena)) {
            String id=usuarioServicio.buscarPorCorreo(correo);
            
            if (usuarioServicio.determinarTipoDeUsuario(correo).equalsIgnoreCase("Alumno")) {
                base.decidirUsuario(usuarioServicio.buscarAlumnoPorId(id));
            } else {
                base.decidirUsuario(usuarioServicio.buscarProfesorPorId(id));
            }
        } else {
            vista.mostrarAlerta("Usuario o contraseña inválidos");
        }
    }
    
    public void alertarUsuario(String message){
        vista.mostrarAlerta(message);
    }
}