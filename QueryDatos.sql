drop database escuela;
create database escuela;
use escuela;

CREATE TABLE IF NOT EXISTS Usuario (
                         id VARCHAR(50) PRIMARY KEY,
                         correo VARCHAR(100) NOT NULL UNIQUE,
                         contrasena VARCHAR(255) NOT NULL,
                         nombre VARCHAR(100) NOT NULL,
                         tipo_usuario VARCHAR(20) NOT NULL -- 'ALUMNO' o 'PROFESOR'
);

-- Tabla Alumno
CREATE TABLE IF NOT EXISTS Alumno (
                        id VARCHAR(50) PRIMARY KEY,
                        FOREIGN KEY (id) REFERENCES Usuario(id)
);

-- Tabla Profesor
CREATE TABLE IF NOT EXISTS Profesor (
                          id VARCHAR(50) PRIMARY KEY,
                          FOREIGN KEY (id) REFERENCES Usuario(id)
);

-- Tabla Curso
CREATE TABLE IF NOT EXISTS Curso (
                       id VARCHAR(50) PRIMARY KEY,
                       nombre VARCHAR(100) NOT NULL,
                       progreso DECIMAL(5,2) DEFAULT 0
);

-- Tabla de relación Alumno-Curso
CREATE TABLE IF NOT EXISTS Alumno_Curso (
                              alumno_id VARCHAR(50),
                              curso_id VARCHAR(50),
                              PRIMARY KEY (alumno_id, curso_id),
                              FOREIGN KEY (alumno_id) REFERENCES Alumno(id),
                              FOREIGN KEY (curso_id) REFERENCES Curso(id)
);

-- Tabla de relación Profesor-Alumno
CREATE TABLE IF NOT EXISTS Profesor_Alumno (
                                 profesor_id VARCHAR(50),
                                 alumno_id VARCHAR(50),
                                 PRIMARY KEY (profesor_id, alumno_id),
                                 FOREIGN KEY (profesor_id) REFERENCES Profesor(id),
                                 FOREIGN KEY (alumno_id) REFERENCES Alumno(id)
);

-- Tabla Tema
CREATE TABLE IF NOT EXISTS Tema (
                      id VARCHAR(50) PRIMARY KEY,
                      titulo VARCHAR(100) NOT NULL,
                      progreso DECIMAL(5,2) DEFAULT 0,
                      curso_id VARCHAR(50),
                      FOREIGN KEY (curso_id) REFERENCES Curso(id)
);

-- Tabla Pregunta
CREATE TABLE IF NOT EXISTS Pregunta (
                          id VARCHAR(50) PRIMARY KEY,
                          enunciado TEXT NOT NULL,
                          respuesta INTEGER NOT NULL,
                          completo BOOLEAN DEFAULT FALSE,
                          tema_id VARCHAR(50),
                          FOREIGN KEY (tema_id) REFERENCES Tema(id)
);

-- Tabla para almacenar las alternativas de las preguntas
CREATE TABLE IF NOT EXISTS Alternativa (
                             pregunta_id VARCHAR(50),
                             indice INTEGER,
                             texto TEXT NOT NULL,
                             PRIMARY KEY (pregunta_id, indice),
                             FOREIGN KEY (pregunta_id) REFERENCES Pregunta(id)
);

-- Tabla Sesion
CREATE TABLE IF NOT EXISTS Sesion (
                        id VARCHAR(50) PRIMARY KEY,
                        titulo VARCHAR(100) NOT NULL,
                        video VARCHAR(255) NOT NULL,
                        completo BOOLEAN DEFAULT FALSE,
                        curso_id VARCHAR(50),
                        FOREIGN KEY (curso_id) REFERENCES Curso(id)
);

-- EJECUTAR TAMBIEN
CREATE INDEX idx_usuario_correo ON Usuario(correo);
CREATE INDEX idx_curso_nombre ON Curso(nombre);
CREATE INDEX idx_tema_titulo ON Tema(titulo);
CREATE INDEX idx_sesion_titulo ON Sesion(titulo);

insert into curso values
('1', 'Historia', 0),
('2', 'Comunicación', 0),
('3', 'Álgebra', 0),
('4', 'Ciencia y Ambiente', 0);

insert into sesion values
('1', 'La Guerra del Pacífico', 'https://youtu.be/baGieJNeZqw?si=esRKoNJAfYmH5Bkp', false, '1'),
('2', 'Prehistoria', 'https://youtu.be/jRnD5OezBs0?si=T0j0lfRkHZ25DQ8y', false, '1');

insert into tema values
('1', 'La Guerra del Pacífico', 0, '1'),
('2', 'Prehistoria', 0, '1');

insert into pregunta values
('1', 'La guerra del pacífico se dio en el año: ', 1, false, '1'),
('2', 'Los países enfrentados fueron: ', 3, false, '1');

insert into alternativa values
('1', 1, '1879'),
('1', 2, '1817'),
('1', 3, '1870'),
('2', 1, 'Argentina y Chile'),
('2', 2, 'Bolivia y Perú'),
('2', 3, 'Chile, Bolivia y Perú');

insert into alumno_curso values
('1', '1'),
('1', '2'),
('1', '3'),
('1', '4');

insert into pregunta values
('3', 'Lugar donde tuvo origen el ser humano', 2, false, '2'),
('4', 'Período que inició hace 5 millones de años y terminó hacia el año 10,000 a.C', 2, false, '2'),
('5', '¿Qué invención marcó el término de la prehistoria?', 2, false, '2'),
('6', 'Es el primer metal que empleó el ser humano', 3, false, '2'),
('7', '¿Cuándo apareció el Homo sapiens sapiens?', 2, false, '2');

insert into alternativa values
('3', 1, 'América'),
('3', 2, 'África'),
('3', 3, 'Europa'),
('4', 1, 'Mesolítico'),
('4', 2, 'Paleolítico'),
('4', 3, 'Neolítico'),
('5', 1, 'La ganadería'),
('5', 2, 'La escritura.'),
('5', 3, 'El comercio'),
('6', 1, 'La piedra'),
('6', 2, 'La madera'),
('6', 3, 'El cobre'),
('7', 1, '10, 000 a 4, 000 a. C.'),
('7', 2, '160, 000 a 28, 000 a. C.'),
('7', 3, '28, 000, 000 a 10, 000 a. C');
