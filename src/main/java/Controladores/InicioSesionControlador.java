/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Main.Alumno;
import Main.Profesor;
import Main.Usuario;
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
    
    public void buscarUsuario(String usuario, String contra){
        if(usuario.equals("dante")){
            base.decidirUsuario(new Alumno(null, "1", usuario, contra, "Dante"));            
        }else{
            base.decidirUsuario(new Profesor(null, "1", usuario, contra, "Gianny"));
        }
    }
}
