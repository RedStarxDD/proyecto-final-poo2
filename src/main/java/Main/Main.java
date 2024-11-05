/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

import Controladores.ControladorBase;
import java.awt.List;

/**
 *
 * @author user
 */
public class Main {

    public static void main(String[] args) {
        ControladorBase controladorBase=new ControladorBase();
        controladorBase.run();
        
        Usuario alumno=new Alumno(null, "1", "dante.uchofen", "123", "Dante");
        Usuario profesor=new Profesor(null, "1", "gianny.alfaro", "987", "Gianny");
    }
}
