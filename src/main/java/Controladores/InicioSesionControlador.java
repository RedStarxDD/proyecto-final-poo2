/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Main.Alumno;
import Main.Profesor;
import Modelos.InicioSesionModelo;
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
        
        if (InicioSesionModelo.validarLogin(usuario, contrasena)) {
            if (InicioSesionModelo.determinarTipoDeUsuario(usuario).equalsIgnoreCase("Alumno")) {
                base.decidirUsuario(new Alumno(null, "1", usuario, contrasena, "Dante"));            
            } else {
                base.decidirUsuario(new Profesor(null, "1", usuario, contrasena, "Gianny"));
            }
        }else{
            System.out.println("No se encontró ningún usuario");
        }
    }
}
