
CREATE TABLE areas_comunes (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    capacidad INT NOT NULL CHECK (capacidad > 0),
    descripcion VARCHAR(255),
    activo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE reservas (
    id SERIAL PRIMARY KEY,
    area_id INT NOT NULL,
    residente_nombre VARCHAR(100) NOT NULL,
    residente_apartamento VARCHAR(20) NOT NULL,
    fecha DATE NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_fin TIME NOT NULL,
    cantidad_asistentes INT NOT NULL CHECK (cantidad_asistentes > 0),
    estado VARCHAR(20) NOT NULL DEFAULT 'CONFIRMADA', 
    CONSTRAINT fk_reserva_area FOREIGN KEY (area_id) REFERENCES areas_comunes(id),
    CONSTRAINT chk_horas CHECK (hora_fin > hora_inicio)
);


INSERT INTO areas_comunes (nombre, capacidad, descripcion, activo) VALUES
('Salón de Eventos A', 50, 'Salón con aire acondicionado y cocina', TRUE),
('Churrasquera Principal', 15, 'Área al aire libre con churrasquera', TRUE),
('Cancha de Pádel', 4, 'Cancha sintética iluminada', TRUE),
('Piscina Temática', 30, 'Área de piscina y camastros', TRUE);


INSERT INTO reservas (area_id, residente_nombre, residente_apartamento, fecha, hora_inicio, hora_fin, cantidad_asistentes, estado) VALUES
(1, 'Carlos Gómez', 'A-101', '2026-11-10', '14:00:00', '18:00:00', 30, 'CONFIRMADA'),
(1, 'Ana Martínez', 'B-202', '2026-11-12', '10:00:00', '14:00:00', 45, 'CONFIRMADA'),
(2, 'Roberto Paiz', 'C-301', '2026-11-10', '12:00:00', '16:00:00', 10, 'CONFIRMADA'),
(2, 'Lucía Fernández', 'A-104', '2026-11-11', '18:00:00', '21:00:00', 12, 'CONFIRMADA'),
(3, 'David López', 'B-105', '2026-11-10', '08:00:00', '10:00:00', 4, 'FINALIZADA'),
(3, 'María Rodríguez', 'C-402', '2026-11-10', '10:00:00', '12:00:00', 4, 'CONFIRMADA'),
(3, 'Jorge Ramos', 'A-303', '2026-11-11', '16:00:00', '18:00:00', 2, 'CANCELADA'),
(4, 'Sofía Castillo', 'B-404', '2026-11-12', '11:00:00', '15:00:00', 15, 'CONFIRMADA'),
(4, 'Pedro Morales', 'A-202', '2026-11-13', '09:00:00', '13:00:00', 20, 'CONFIRMADA'),
(1, 'Elena García', 'C-101', '2026-11-15', '19:00:00', '23:00:00', 40, 'CONFIRMADA');

Select * from areas_comunes;



