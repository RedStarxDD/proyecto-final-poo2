package Repositorios;

import Modelos.Mysql;
import Modelos.Sesion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SesionRepository implements IRepository<Sesion> {
    private final Mysql mysql;

    public SesionRepository() {
        this.mysql = new Mysql();
    }

    @Override
    public boolean create(Sesion sesion) {
        String sql = "INSERT INTO Sesion (id, titulo, video, completo, curso_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sesion.getId());
            stmt.setString(2, sesion.getTitulo());
            stmt.setString(3, sesion.getVideo());
            stmt.setBoolean(4, sesion.isCompleto());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Sesion> findByCursoId(String cursoId) {
        List<Sesion> sesiones = new ArrayList<>();
        String sql = "SELECT * FROM Sesion WHERE curso_id = ?";

        try (Connection conn = mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cursoId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                sesiones.add(new Sesion(
                        rs.getString("id"),
                        rs.getString("titulo"),
                        rs.getString("video"),
                        rs.getBoolean("completo")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sesiones;
    }


    @Override
    public Optional<Sesion> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<Sesion> findAll() {
        return List.of();
    }

    @Override
    public boolean update(Sesion entity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}