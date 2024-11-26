package Repositorios;

import Modelos.Mysql;
import Modelos.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepository implements IRepository<Usuario> {
    private final Mysql mysql;

    public UsuarioRepository() {
        this.mysql = new Mysql();
    }

    @Override
    public boolean create(Usuario usuario) {
        String sql = "INSERT INTO Usuario (id, correo, contrasena, nombre, tipo_usuario) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getId());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getContrasena());
            stmt.setString(4, usuario.getNombre());
            stmt.setString(5, usuario.getClass().getSimpleName().toUpperCase());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Usuario> findById(String id) {
        String sql = "SELECT * FROM Usuario WHERE id = ?";

        try (Connection conn = mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getString("id"),
                        rs.getString("correo"),
                        rs.getString("contrasena"),
                        rs.getString("nombre")
                );
                return Optional.of(usuario);
            }

            return Optional.empty();
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
    
    public String findByCorreo(String correo) {
        String sql = "SELECT * FROM Usuario WHERE correo = ?";

        try (Connection conn = mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, correo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("id");
            }

            return "";
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";

        try (Connection conn = mysql.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getString("id"),
                        rs.getString("correo"),
                        rs.getString("contrasena"),
                        rs.getString("nombre")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    @Override
    public boolean update(Usuario usuario) {
        String sql = "UPDATE Usuario SET correo = ?, contrasena = ?, nombre = ? WHERE id = ?";

        try (Connection conn = mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getCorreo());
            stmt.setString(2, usuario.getContrasena());
            stmt.setString(3, usuario.getNombre());
            stmt.setString(4, usuario.getId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM Usuario WHERE id = ?";

        try (Connection conn = mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean validarLogin(String txtUser, String txtPass) {

        String sql = "SELECT * FROM Usuario WHERE correo = ? AND contrasena = ?";
        try (Connection connection = mysql.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

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

    public String determinarTipoDeUsuario(String correo) {

        try (Connection connection=mysql.getConnection()){
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
}