/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Omar Rafael
 */
public class CursoService {

    private static final Mysql mysql = new Mysql();

    public static int insertarCurso(String nombre, String temas, double progreso, String sesiones) {
        String sql = "INSERTE INTO Curso( nombre, temas, progreso, sesiones) VALUES (?, ?, ?, ?)";

        try (Connection connection = mysql.getConnection(); PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setString(1, nombre);
            pst.setString(2, temas);
            pst.setDouble(3, progreso);
            pst.setString(4, sesiones);
            return pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int asignarAlumnoCurso(int alumnoId, int curosId) {
        String sql = "INSERT INTO Alumno_Curso (alumno_id, curso_id) VALUES (?, ?)";
        try (Connection connection = mysql.getConnection(); PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, alumnoId);
            pst.setInt(2, curosId);
            return pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
