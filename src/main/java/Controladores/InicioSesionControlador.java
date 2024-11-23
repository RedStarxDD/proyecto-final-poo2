/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Alumno;
import Modelos.Profesor;
import Repositorios.InicioSesionRepositorio;
import core.Controller;
import Vistas.IniciodeSesión;

/**
 *
 * @author user
 */
public class InicioSesionControlador extends Controller{
    private IniciodeSesión vista;
    private ControladorBase base;

    @Override
    public void run() {
        vista=new IniciodeSesión(this);
        vista.setVisible(true);
    }

    public InicioSesionControlador(ControladorBase base) {
        this.base = base;
    }

    public IniciodeSesión getVista() {
        return vista;
    }
    
    public void buscarUsuario(String usuario, char[] contra){
        String contrasena=new String(contra);
        
        if (InicioSesionRepositorio.validarLogin(usuario, contrasena)) {
            if (InicioSesionRepositorio.determinarTipoDeUsuario(usuario).equalsIgnoreCase("Alumno")) {
                base.decidirUsuario(new Alumno(null, "1", usuario, contrasena, "Dante"));            
            } else {
                base.decidirUsuario(new Profesor(null, "1", usuario, contrasena, "Gianny"));
            }
        }else{
            System.out.println("No se encontró ningún usuario");
        }
    }
}
