package Repositorios;

import Modelos.Mysql;
import Modelos.Tema;
import Modelos.Pregunta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TemaRepository implements IRepository<Tema> {
    private final Mysql mysql;
    private final PreguntaRepository preguntaRepository;

    public TemaRepository() {
        this.mysql = new Mysql();
        this.preguntaRepository = new PreguntaRepository();
    }

    public List<Tema> findByCursoId(String cursoId) {
        List<Tema> temas = new ArrayList<>();
        String sql = "SELECT * FROM Tema WHERE curso_id = ?";

        try (Connection conn = mysql.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cursoId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                List<Pregunta> preguntas = preguntaRepository.findByTemaId(rs.getString("id"));
                temas.add(new Tema(
                        rs.getString("id"),
                        rs.getString("titulo"),
                        preguntas,
                        rs.getDouble("progreso")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return temas;
    }

    @Override
    public boolean create(Tema entity) {
        return false;
    }

    @Override
    public Optional<Tema> findById(String id) {
        return Optional.empty();
    }

    @Override
    public List<Tema> findAll() {
        return List.of();
    }

    @Override
    public boolean update(Tema entity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
