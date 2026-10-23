CREATE DATABASE IF NOT EXISTS biblioteca CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE biblioteca;

DROP TABLE IF EXISTS libro;

CREATE TABLE libro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    precio DECIMAL(6,2) NOT NULL,
    stock INT NOT NULL DEFAULT 10
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO libro (titulo, autor, precio, stock) VALUES
('Así es la puta vida', 'Jordi Wild', 16.50, 10),
('Capitán Calzoncillos', 'Dalas Review', 12.00, 5),
('Sueños de acero y neón', 'Dross', 14.50, 8),
('El libro troll', 'Dross', 18.00, 12),
('Yo soy el Berserk', 'Dalas Review', 11.50, 7),
('1984', 'George Orwell', 10.95, 20),
('La sombra del viento', 'Carlos Ruiz Zafón', 14.25, 15),
('Ensayo sobre la ceguera', 'José Saramago', 11.50, 6);
