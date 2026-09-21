CREATE TABLE vehiculo (

id  BIGINT GENERATED ALWAYS AS IDENTITY,
placa  VARCHAR(20) NOT NULL,
propietario VARCHAR(80) NOT NULL,
tipo VARCHAR(30) NOT NULL,
hora_ingreso INT NOT NULL,
hora_utilizadas INT NOT NULL,
costo NUMERIC(10, 2) NOT NULL,
activo BOOLEAN DEFAULT TRUE,

CONSTRAINT pk_vehiculo PRIMARY KEY (id),
    CONSTRAINT uk_vehiculo_placa UNIQUE (placa),
    CONSTRAINT ck_vehiculo_hora_ingreso CHECK (hora_ingreso > 0),
	CONSTRAINT ck_vehiculo_hora_utilizadas CHECK (hora_utilizadas > 0),
    CONSTRAINT ck_vehiculo_costo CHECK (costo >= 0)
);

INSERT INTO vehiculo (
    placa,
    propietario,
    tipo,
    hora_ingreso,
    hora_utilizadas,
	costo
)
VALUES
('P-001', 'ANGEL', 'AUTOMOVIL', 12, 2, 20.00),
    ('P-002', 'ANGEL', 'MOTOCICLETA', 10, 5, 50.00),
    ('P-003', 'ANGEL', 'AUTOMOVIL', 13, 1, 20.00),
    ('P-004', 'MYNOR', 'AUTOMOVIL', 16, 4, 20.00),
    ('P-005', 'ANGEL', 'AUTOMOVIL', 15, 2, 20.00);
   
COMMIT;


SELECT id, placa, propietario, tipo, hora_ingreso, hora_utilizadas, costo, activo
FROM vehiculo;

SELECT id, placa, propietario, tipo, costo
FROM vehiculo WHERE tipo = 'AUTOMOVIL';

SELECT id, placa, propietario, tipo, costo
FROM vehiculo WHERE costo > 20.00;

SELECT id, placa, propietario, tipo, costo
FROM vehiculo ORDER BY costo DESC;

UPDATE vehiculo SET propietario = 'ANGEL GOMEZ', costo = 25.00
WHERE placa = 'P-001';

UPDATE vehiculo SET activo = FALSE
WHERE placa = 'P-002';


DELETE FROM vehiculo WHERE placa = 'P-005';


SELECT id, placa, propietario, tipo, costo, activo 
FROM vehiculo;


INSERT INTO vehiculo (placa, propietario, tipo, hora_ingreso, hora_utilizadas, costo)
VALUES ('P-001', 'CARLOS PRUEBA', 'AUTOMOVIL', 14, 2, 20.00);


INSERT INTO vehiculo (placa, propietario, tipo, hora_ingreso, hora_utilizadas, costo)
VALUES ('P-999', 'MARIO PRUEBA', 'AUTOMOVIL', 10, -3, 20.00);