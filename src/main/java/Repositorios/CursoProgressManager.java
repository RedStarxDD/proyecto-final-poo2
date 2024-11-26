package Repositorios;

import Modelos.Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CursoProgressManager {
    private final Mysql conexion;

    public CursoProgressManager() {
        this.conexion = new Mysql();
    }

    /**
     * Marca una pregunta como completada y actualiza el progreso del tema y curso
     */
    public boolean marcarPreguntaCompletada(String preguntaId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = conexion.getConnection();
            conn.setAutoCommit(false); // Iniciamos transacción

            // 1. Marcar la pregunta como completada
            String updatePregunta = "UPDATE Pregunta SET completo = TRUE WHERE id = ?";
            stmt = conn.prepareStatement(updatePregunta);
            stmt.setString(1, preguntaId);
            stmt.executeUpdate();

            // 2. Obtener el tema_id de la pregunta
            String getTemaId = "SELECT tema_id FROM Pregunta WHERE id = ?";
            stmt = conn.prepareStatement(getTemaId);
            stmt.setString(1, preguntaId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String temaId = rs.getString("tema_id");

                // 3. Calcular y actualizar el progreso del tema
                actualizarProgresoTema(conn, temaId);

                // 4. Obtener el curso_id del tema y actualizar su progreso
                String getCursoId = "SELECT curso_id FROM Tema WHERE id = ?";
                stmt = conn.prepareStatement(getCursoId);
                stmt.setString(1, temaId);
                rs = stmt.executeQuery();

                if (rs.next()) {
                    String cursoId = rs.getString("curso_id");
                    actualizarProgresoCurso(conn, cursoId);
                }
            }

            conn.commit();
            return true;
        } catch (SQLException e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Actualiza el progreso de un tema basado en sus preguntas completadas
     */
    private void actualizarProgresoTema(Connection conn, String temaId) throws SQLException {
        String updateTemaProgress = """
            UPDATE Tema 
            SET progreso = (
                SELECT (COUNT(CASE WHEN completo = TRUE THEN 1 END) * 100.0 / COUNT(*))
                FROM Pregunta 
                WHERE tema_id = ?
            )
            WHERE id = ?
        """;

        PreparedStatement stmt = conn.prepareStatement(updateTemaProgress);
        stmt.setString(1, temaId);
        stmt.setString(2, temaId);
        stmt.executeUpdate();
    }

    /**
     * Actualiza el progreso de un curso basado en el progreso de sus temas
     */
    private void actualizarProgresoCurso(Connection conn, String cursoId) throws SQLException {
        String updateCursoProgress = """
            UPDATE Curso 
            SET progreso = (
                SELECT AVG(progreso)
                FROM Tema 
                WHERE curso_id = ?
            )
            WHERE id = ?
        """;

        PreparedStatement stmt = conn.prepareStatement(updateCursoProgress);
        stmt.setString(1, cursoId);
        stmt.setString(2, cursoId);
        stmt.executeUpdate();
    }

    /**
     * Reinicia el progreso de un curso específico
     */
    public boolean reiniciarProgresoCurso(String cursoId) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = conexion.getConnection();
            conn.setAutoCommit(false);

            // 1. Reiniciar todas las preguntas de los temas del curso
            String resetPreguntas = """
                UPDATE Pregunta 
                SET completo = FALSE 
                WHERE tema_id IN (
                    SELECT id FROM Tema WHERE curso_id = ?
                )
            """;
            stmt = conn.prepareStatement(resetPreguntas);
            stmt.setString(1, cursoId);
            stmt.executeUpdate();

            // 2. Reiniciar progreso de los temas
            String resetTemas = "UPDATE Tema SET progreso = 0 WHERE curso_id = ?";
            stmt = conn.prepareStatement(resetTemas);
            stmt.setString(1, cursoId);
            stmt.executeUpdate();

            // 3. Reiniciar progreso del curso
            String resetCurso = "UPDATE Curso SET progreso = 0 WHERE id = ?";
            stmt = conn.prepareStatement(resetCurso);
            stmt.setString(1, cursoId);
            stmt.executeUpdate();

            conn.commit();
            return true;
        } catch (SQLException e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

