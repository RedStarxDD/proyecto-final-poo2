package Repositorios;

import Modelos.Mysql;
import Modelos.Pregunta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PreguntaRepository implements IRepository<Pregunta> {
    private final Mysql mysql;

    public PreguntaRepository() {
        this.mysql = new Mysql();
    }

    @Override
    public boolean create(Pregunta pregunta) {
        String sql = "INSERT INTO Pregunta (id, enunciado, respuesta, completo, tema_id) VALUES (?, ?, ?, ?, ?)";
        String sqlAlternativas = "INSERT INTO Alternativa (pregunta_id, indice, texto) VALUES (?, ?, ?)";

        try (Connection conn = mysql.getConnection()) {
            // Insertar pregunta
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, pregunta.getId());
                stmt.setString(2, pregunta.getEnunciado());
                stmt.setInt(3, pregunta.getRespuesta());
                stmt.setBoolean(4, pregunta.isCompleto());

                if (stmt.executeUpdate() <= 0) {
                    return false;
                }
            }

            // Insertar alternativas
            try (PreparedStatement stmt = conn.prepareStatement(sqlAlternativas)) {
                String[] alternativas = pregunta.getAlternativas();
                for (int i = 0; i < alternativas.length; i++) {
                    stmt.setString(1, pregunta.getId());
                    stmt.setInt(2, i);
                    stmt.setString(3, alternativas[i]);
                    stmt.addBatch();
                }

                int[] results = stmt.executeBatch();
                return results.length == alternativas.length;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public List<Pregunta> findByTemaId(String temaId) {
        List<Pregunta> preguntas = new ArrayList<>();
        String sql = "SELECT * FROM Pregunta WHERE tema_id = ?";

        try (Connection conn = mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, temaId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String preguntaId = rs.getString("id");
                String[] alternativas = obtenerAlternativas(preguntaId);

                preguntas.add(new Pregunta(
                        preguntaId,
                        rs.getString("enunciado"),
                        alternativas,
                        rs.getInt("respuesta"),
                        rs.getBoolean("completo")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return preguntas;
    }

    private String[] obtenerAlternativas(String preguntaId) {
        List<String> alternativas = new ArrayList<>();
        String sql = "SELECT texto FROM Alternativa WHERE pregunta_id = ? ORDER BY indice";

        try (Connection conn = mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, preguntaId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                alternativas.add(rs.getString("texto"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alternativas.toArray(new String[0]);
    }

    @Override
    public Optional<Pregunta> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<Pregunta> findAll() {
        return List.of();
    }

    @Override
    public boolean update(Pregunta entity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}