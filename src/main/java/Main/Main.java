/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

import Controladores.ControladorBase;

/**
 *
 * @author user
 */
public class Main {

    public static void main(String[] args) {
        /*AlumnoRepository alumnoRepository=new AlumnoRepository();
        alumnoRepository.create(new Alumno(null,"1","romer@gmail.com","contra","jose perales"));
        ProfesorRepository profesorRepository=new ProfesorRepository();
        profesorRepository.create(new Profesor(new ArrayList<>(),"2","jose@gmail.com","contra","manuel"));*/
                
        ControladorBase controladorBase=new ControladorBase();
        controladorBase.run();
    }
}
