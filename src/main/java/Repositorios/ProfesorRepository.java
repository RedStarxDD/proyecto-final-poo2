package Repositorios;

import Modelos.Mysql;
import Modelos.Profesor;
import Modelos.Alumno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProfesorRepository implements IRepository<Profesor> {
    private final Mysql mysql;
    private final UsuarioRepository usuarioRepository;
    private final AlumnoRepository alumnoRepository;

    public ProfesorRepository() {
        this.mysql = new Mysql();
        this.usuarioRepository = new UsuarioRepository();
        this.alumnoRepository = new AlumnoRepository();
    }

    @Override
    public boolean create(Profesor profesor) {
        if (!usuarioRepository.create(profesor)) {
            return false;
        }

        String sql = "INSERT INTO Profesor (id) VALUES (?)";

        try (Connection conn = mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, profesor.getId());

            if (stmt.executeUpdate() > 0) {
                return insertarAlumnosProfesor(profesor);
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean insertarAlumnosProfesor(Profesor profesor) {
        String sql = "INSERT INTO Profesor_Alumno (profesor_id, alumno_id) VALUES (?, ?)";

        try (Connection conn = mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (Alumno alumno : profesor.getAlumnos()) {
                stmt.setString(1, profesor.getId());
                stmt.setString(2, alumno.getId());
                stmt.addBatch();
            }

            int[] results = stmt.executeBatch();
            return results.length == profesor.getAlumnos().size();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Optional<Profesor> findById(String id) {
        return usuarioRepository.findById(id).map(usuario -> {
            List<Alumno> alumnos = obtenerAlumnosProfesor(id);
            return new Profesor((ArrayList<Alumno>) alumnos, usuario.getId(), usuario.getCorreo(),
                    usuario.getContrasena(), usuario.getNombre());
        });
    }


    private List<Alumno> obtenerAlumnosProfesor(String profesorId) {
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT alumno_id FROM Profesor_Alumno WHERE profesor_id = ?";

        try (Connection conn = mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, profesorId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                alumnoRepository.findById(rs.getString("alumno_id"))
                        .ifPresent(alumnos::add);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alumnos;
    }

    @Override
    public List<Profesor> findAll() {
        return List.of();
    }

    @Override
    public boolean update(Profesor entity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
