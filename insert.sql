-- Insertar un usuario de tipo 'ALUMNO'
INSERT INTO Usuario (id, correo, contrasena, nombre, tipo_usuario)
VALUES ('11', 'jairo@example.com', 'contra', 'Juan Pérez', 'ALUMNO');

-- Insertar un usuario de tipo 'PROFESOR'
INSERT INTO Usuario (id, correo, contrasena, nombre, tipo_usuario)
VALUES ('12', 'maria@example.com', 'contrasena456', 'María Gómez', 'PROFESOR');

-- Insertar un alumno (debe existir previamente en la tabla Usuario)
INSERT INTO Alumno (id)
VALUES ('11');

-- Insertar un profesor (debe existir previamente en la tabla Usuario)
INSERT INTO Profesor (id)
VALUES ('12');

-- Insertar un curso
INSERT INTO Curso (id, nombre)
VALUES ('13', 'Matemáticas 101');

-- Relacionar a un alumno con un curso
INSERT INTO Alumno_Curso (alumno_id, curso_id)
VALUES ('11', '13');

-- Relacionar un profesor con un alumno
INSERT INTO Profesor_Alumno (profesor_id, alumno_id)
VALUES ('12', '11');

-- Insertar un tema relacionado con un curso
INSERT INTO Tema (id, titulo, curso_id)
VALUES ('14', 'Álgebra Básica', '13');

-- Inserta una pregunta en la tabla Pregunta
INSERT INTO Pregunta (id, enunciado, respuesta, tema_id)
VALUES ('12', '¿Qué es el álgebra?', 1, '14');


-- Insertar alternativas para una pregunta
INSERT INTO Alternativa (pregunta_id, indice, texto)
VALUES ('12', 1, 'Una rama de las matemáticas'),
       ('12', 2, 'Una disciplina artística'),
       ('12', 3, 'Un tipo de música');

-- Insertar una sesión para un curso
INSERT INTO Sesion (id, titulo, video, curso_id)
VALUES ('15', 'Introducción al álgebra', 'video_intro.mp4', '13');


-------------------------------------------------------------------------------------------------------------------

-- 1. Marcar la pregunta como completada
UPDATE Pregunta
SET completo = TRUE
WHERE id = ?;

-- 2. Obtener el tema_id de la pregunta

SELECT tema_id FROM Pregunta WHERE id = ?;

-- 3. Actualizar el progreso del tema
UPDATE Tema
SET progreso = (
    SELECT (COUNT(CASE WHEN completo = TRUE THEN 1 END) * 100.0 / COUNT(*))
    FROM Pregunta
    WHERE tema_id = ?
)
WHERE id = ?;

-- 4. Obtener el curso_id del tema
SELECT curso_id FROM Tema WHERE id = ?;

-- 5. Actualizar el progreso del curso
UPDATE Curso
SET progreso = (
    SELECT AVG(progreso)
    FROM Tema
    WHERE curso_id = ?
)
WHERE id = ?;

-- 6. Actualizar el progreso de un tema
UPDATE Tema
SET progreso = (
    SELECT (COUNT(CASE WHEN completo = TRUE THEN 1 END) * 100.0 / COUNT(*))
    FROM Pregunta
    WHERE tema_id = ?
)
WHERE id = ?;

-- 7. Actualizar el progreso de un curso de acuerdo a sus temas
UPDATE Curso
SET progreso = (
    SELECT AVG(progreso)
    FROM Tema
    WHERE curso_id = ?
)
WHERE id = ?;

-- 8. Actualizar el progreso de un curso en especifico
-- 1. Reiniciar todas las preguntas de los temas del curso
UPDATE Pregunta
SET completo = FALSE
WHERE tema_id IN (
    SELECT id FROM Tema WHERE curso_id = ?
);

-- 2. Reiniciar el progreso de los temas
UPDATE Tema
SET progreso = 0
WHERE curso_id = ?;

-- 3. Reiniciar el progreso del curso
UPDATE Curso
SET progreso = 0
WHERE id = ?;
