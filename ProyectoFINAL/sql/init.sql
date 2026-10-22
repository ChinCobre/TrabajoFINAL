-- Script de inicialización para la aplicación de la Biblioteca

CREATE DATABASE IF NOT EXISTS biblioteca CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE biblioteca;

-- Borramos la tabla si ya existía para permitir reejecuciones limpias
DROP TABLE IF EXISTS libros;

-- Creación de la tabla de libros
CREATE TABLE libros (
    isbn VARCHAR(20) PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    precio DECIMAL(6,2) NOT NULL CHECK (precio >= 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Insertar datos de ejemplo (mínimo 8 libros para probar todas las búsquedas)
INSERT INTO libros (isbn, titulo, autor, precio) VALUES
('9788420471839', 'Así es la vida', 'Jordi Wild', 16.50),
('9788420633145', 'Capitán Calzoncillos', 'Dalas Review', 12.00),
('9788408035698', 'Sueños de acero y neón', 'Dross', 14.50),
('9788401352836', 'El libro troll', 'Dross', 18.00),
('9788420651101', 'Yo soy el Berserk', 'Dalas Review', 11.50),
('9788497592208', '1984', 'George Orwell', 10.95),
('9788408004349', 'La sombra del viento', 'Carlos Ruiz Zafón', 14.25),
('9788423351602', 'Ensayo sobre la ceguera', 'José Saramago', 11.50);