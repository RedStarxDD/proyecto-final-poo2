/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorios;

import Modelos.Mysql;
import core.Model;
import core.View;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InicioSesionRepositorio implements Model{
    
    // Método para validar el login usando PreparedStatement para mayor seguridad
    public static boolean validarLogin(String txtUser, String txtPass) {
        Mysql mysql = new Mysql();
        Connection connection = mysql.getConnection();
        String sql = "SELECT * FROM Usuario WHERE correo = ? AND contrasena = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, txtUser);
            preparedStatement.setString(2, txtPass);
            ResultSet query = preparedStatement.executeQuery();
            if (query.next()) {
                System.out.println("Inicio de sesión exitoso");
                return true;
            } else {
                System.out.println("Usuario o Contraseña incorrecta");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Método para insertar un usuario en la tabla Usuario y devolver el ID generado
    private static int insertarUsuario(Connection connection, String correo, String contrasena, String nombre) throws SQLException {
        String sql = "INSERT INTO Usuario (correo, contrasena, nombre) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, correo);
            stmt.setString(2, contrasena);
            stmt.setString(3, nombre);
            stmt.executeUpdate();

            // Obtener el ID generado
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Retorna el ID generado
                } else {
                    throw new SQLException("Fallo al insertar usuario, no se pudo obtener el ID.");
                }
            }
        }
    }

    // Método para insertar en Alumno
    private static void insertarAlumno(Connection connection, int userId, String listaCursos) throws SQLException {
        String sql = "INSERT INTO Alumno (id, listaCursos) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setString(2, listaCursos); // JSON con cursos
            stmt.executeUpdate();
        }
    }

    // Método para insertar en Profesor
    private static void insertarProfesor(Connection connection, int userId, String listaAlumnos) throws SQLException {
        String sql = "INSERT INTO Profesor (id, listaAlumnos) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setString(2, listaAlumnos); // JSON con alumnos
            stmt.executeUpdate();
        }
    }
// Método para verificar si un correo ya existe en la base de datos

    private static boolean existeCorreo(Connection connection, String correo) throws SQLException {
        String sql = "SELECT id FROM Usuario WHERE correo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, correo);
            ResultSet resultSet = stmt.executeQuery();
            return resultSet.next(); // Retorna true si encuentra un usuario con el mismo correo
        }
    }

    // Método principal para registrar un usuario y asociarlo como Alumno o Profesor
    public static boolean registrarUsuario(String correo, String nombre, String contrasena, boolean esAlumno, String listaDatos) {
        Mysql mysql = new Mysql();
        try (Connection connection = mysql.getConnection()) {
            connection.setAutoCommit(false); // Iniciar transacción

            // Verificar si el correo ya existe
            if (existeCorreo(connection, correo)) {
                System.out.println("Error: Ya existe un usuario registrado con el correo " + correo);
                return false;
            }

            // Insertar en Usuario y obtener el ID generado
            int userId = insertarUsuario(connection, correo, contrasena, nombre);

            // Insertar en Alumno o Profesor dependiendo del tipo de usuario
            if (esAlumno) {
                insertarAlumno(connection, userId, listaDatos); // listaDatos es el JSON de cursos
            } else {
                insertarProfesor(connection, userId, listaDatos); // listaDatos es el JSON de alumnos
            }

            connection.commit(); // Confirmar transacción
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                mysql.getConnection().rollback(); // Revertir en caso de error
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        }
        return false;
    }

    public static String determinarTipoDeUsuario(String correo) {
    Mysql mysql = new Mysql();
    Connection connection = mysql.getConnection();

    try {
        // Obtener el ID del usuario basado en el correo
        String sqlUsuario = "SELECT id FROM Usuario WHERE correo = ?";
        int userId = -1;

        try (PreparedStatement stmtUsuario = connection.prepareStatement(sqlUsuario)) {
            stmtUsuario.setString(1, correo);
            ResultSet rsUsuario = stmtUsuario.executeQuery();
            if (rsUsuario.next()) {
                userId = rsUsuario.getInt("id");
            } else {
                return "Usuario no encontrado con el correo proporcionado";
            }
        }

        // Verificar si el usuario es Alumno
        String sqlAlumno = "SELECT * FROM Alumno WHERE id = ?";
        try (PreparedStatement stmtAlumno = connection.prepareStatement(sqlAlumno)) {
            stmtAlumno.setInt(1, userId);
            ResultSet rsAlumno = stmtAlumno.executeQuery();
            if (rsAlumno.next()) {
                return "Alumno";
            }
        }

        // Verificar si el usuario es Profesor
        String sqlProfesor = "SELECT * FROM Profesor WHERE id = ?";
        try (PreparedStatement stmtProfesor = connection.prepareStatement(sqlProfesor)) {
            stmtProfesor.setInt(1, userId);
            ResultSet rsProfesor = stmtProfesor.executeQuery();
            if (rsProfesor.next()) {
                return "Profesor";
            }
        }

        return "Usuario no encontrado en tablas de Alumno o Profesor";
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return "Error al determinar el tipo de usuario";
    }

    /*public static void main(String[] args) {
        // Prueba de registro de usuario como Alumno y Profesor
        registrarUsuario("correoAlumno@example.com", "AlumnoEjemplo", "password123", true, "[\"Curso1\", \"Curso2\"]");
        registrarUsuario("correoProfesor@example.com", "ProfesorEjemplo", "password123", false, "[\"Alumno1\", \"Alumno2\"]");
    }*/

    @Override
    public void attach(View view) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void detach(View view) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void notifyViews() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
