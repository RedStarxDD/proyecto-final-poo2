package Repositorios;

import Modelos.Mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Modelos.Curso;
import Modelos.Tema;
import Modelos.Sesion;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CursoRepository implements IRepository<Curso> {
    private final Mysql mysql;
    private final TemaRepository temaRepository;
    private final SesionRepository sesionRepository;

    public CursoRepository() {
        this.mysql = new Mysql();
        this.temaRepository = new TemaRepository();
        this.sesionRepository = new SesionRepository();
    }

    @Override
    public boolean create(Curso curso) {
        String sql = "INSERT INTO Curso (id, nombre, progreso) VALUES (?, ?, ?)";

        try (Connection conn = mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, curso.getId());
            stmt.setString(2, curso.getNombre());
            stmt.setDouble(3, curso.getProgreso());

            if (stmt.executeUpdate() > 0) {
                // Crear temas y sesiones asociados
                return crearTemasYSesiones(curso);
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean crearTemasYSesiones(Curso curso) {
        boolean temasCreados = curso.getTemas().stream()
                .allMatch(tema -> temaRepository.create(tema));

        boolean sesionesCreadas = curso.getSesiones().stream()
                .allMatch(sesion -> sesionRepository.create(sesion));

        return temasCreados && sesionesCreadas;
    }

    @Override
    public Optional<Curso> findById(String id) {
        String sql = "SELECT * FROM Curso WHERE id = ?";

        try (Connection conn = mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                List<Tema> temas = temaRepository.findByCursoId(id);
                List<Sesion> sesiones = sesionRepository.findByCursoId(id);

                return Optional.of(new Curso(
                        rs.getString("id"),
                        rs.getString("nombre"),
                        (ArrayList<Tema>) temas,
                        rs.getDouble("progreso"),
                        (ArrayList<Sesion>) sesiones
                ));
            }

            return Optional.empty();
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<Curso> findAll() {
        return List.of();
    }

    @Override
    public boolean update(Curso entity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

}
