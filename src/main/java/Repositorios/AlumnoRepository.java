package Repositorios;

import Modelos.Mysql;
import Modelos.Alumno;
import Modelos.Curso;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlumnoRepository implements IRepository<Alumno> {
    private final Mysql mysql;
    private final UsuarioRepository usuarioRepository;
    private final CursoRepository cursoRepository;

    public AlumnoRepository() {
        this.mysql = new Mysql();
        this.usuarioRepository = new UsuarioRepository();
        this.cursoRepository = new CursoRepository();
    }

    @Override
    public boolean create(Alumno alumno) {
        // Primero creamos el usuario
        if (!usuarioRepository.create(alumno)) {
            return false;
        }

        // Luego creamos el alumno
        String sql = "INSERT INTO Alumno (id) VALUES (?)";

        try (Connection conn = mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, alumno.getId());

            if (stmt.executeUpdate() > 0) {
                // Insertamos los cursos del alumno
                return insertarCursosAlumno(alumno);
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean insertarCursosAlumno(Alumno alumno) {
        String sql = "INSERT INTO Alumno_Curso (alumno_id, curso_id) VALUES (?, ?)";

        try (Connection conn = mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (Curso curso : alumno.getCursos()) {
                stmt.setString(1, alumno.getId());
                stmt.setString(2, curso.getId());
                stmt.addBatch();
            }

            int[] results = stmt.executeBatch();
            return results.length == alumno.getCursos().size();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Alumno> findById(String id) {
        return usuarioRepository.findById(id).map(usuario -> {
            List<Curso> cursos = obtenerCursosAlumno(id);
            return new Alumno((ArrayList<Curso>) cursos, usuario.getId(), usuario.getCorreo(),
                    usuario.getContrasena(), usuario.getNombre());
        });
    }
    
    public Optional<Alumno> findByName(String name) {
        return usuarioRepository.findByName(name).map(usuario -> {
            List<Curso> cursos = obtenerCursosAlumno(name);
            return new Alumno((ArrayList<Curso>) cursos, usuario.getId(), usuario.getCorreo(),
                    usuario.getContrasena(), usuario.getNombre());
        });
    }

    public List<Curso> obtenerCursosAlumno(String alumnoId) {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT curso_id FROM Alumno_Curso WHERE alumno_id = ?";

        try (Connection conn = mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, alumnoId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                cursoRepository.findById(rs.getString("curso_id"))
                        .ifPresent(cursos::add);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cursos;
    }

    @Override
    public List<Alumno> findAll() {
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT id FROM Alumno";

        try (Connection conn = mysql.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                findById(rs.getString("id")).ifPresent(alumnos::add);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alumnos;
    }

    @Override
    public boolean update(Alumno alumno) {
        // Actualizamos primero el usuario
        if (!usuarioRepository.update(alumno)) {
            return false;
        }

        // Actualizamos los cursos
        try (Connection conn = mysql.getConnection()) {
            // Eliminamos los cursos actuales
            String deleteSql = "DELETE FROM Alumno_Curso WHERE alumno_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(deleteSql)) {
                stmt.setString(1, alumno.getId());
                stmt.executeUpdate();
            }

            // Insertamos los nuevos cursos
            return insertarCursosAlumno(alumno);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        try (Connection conn = mysql.getConnection()) {
            // Primero eliminamos las relaciones con cursos
            String deleteCursosSql = "DELETE FROM Alumno_Curso WHERE alumno_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(deleteCursosSql)) {
                stmt.setString(1, id);
                stmt.executeUpdate();
            }

            // Luego eliminamos el alumno
            String deleteAlumnoSql = "DELETE FROM Alumno WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(deleteAlumnoSql)) {
                stmt.setString(1, id);
                if (stmt.executeUpdate() > 0) {
                    // Finalmente eliminamos el usuario
                    return usuarioRepository.delete(id);
                }
            }

            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}