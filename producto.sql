CREATE TABLE producto (

id  BIGINT GENERATED ALWAYS AS IDENTITY,
codigo  VARCHAR(15) NOT NULL,
nombre	VARCHAR(80) NOT NULL,
categoria VARCHAR(40) NOT NULL,
precio NUMERIC(8, 2) NOT NULL,
stock	INTEGER NOT NULL,
activo BOOLEAN NOT NULL DEFAULT TRUE,

CONSTRAINT pk_producto PRIMARY KEY (id),
    CONSTRAINT uk_producto_codigo UNIQUE (codigo),
    CONSTRAINT ck_producto_precio CHECK (precio > 0),
    CONSTRAINT ck_producto_stock CHECK (stock >= 0)
);


INSERT INTO producto( 
codigo,
nombre,
categoria,
precio, 
stock)
VALUES 
    ('PR-001', 'Teclado Mecánico', 'ELECTRONICA', 350.00, 15),
    ('PR-002', 'Mouse Inalámbrico', 'ELECTRONICA', 125.50, 25),
    ('PR-003', 'Monitor 24"', 'ELECTRONICA', 200.00, 0),--STOCK DE 0 
	
    ('PR-004', 'Cafetera Programable', 'HOGAR', 150.00, 2),--STOCK ENTRE 1 Y 3    
    ('PR-005', 'Licuadora Industrial', 'HOGAR', 280.00, 8),
    ('PR-006', 'Juego de Sartenes', 'HOGAR', 299.99, 10),
	
    ('PR-007', 'Silla Ergonómica', 'OFICINA', 50.00, 5),
    ('PR-008', 'Escritorio de Madera', 'OFICINA', 500.00, 4);
COMMIT;


SELECT id, codigo,nombre,categoria,precio, stock
FROM producto;


SELECT id, codigo, nombre,categoria,precio, stock
FROM producto WHERE categoria = 'ELECTRONICA';

SELECT id, codigo, nombre,categoria,precio, stock
FROM producto ORDER BY precio DESC;

SELECT id, codigo, nombre,categoria,precio, stock
FROM producto WHERE stock <= 3;

SELECT id, codigo, nombre,categoria,precio, stock, activo
FROM producto WHERE activo = TRUE AND stock > 0;

SELECT id, codigo, nombre,categoria,precio, stock, activo
FROM producto WHERE codigo ='PR-008';





SELECT codigo, nombre, stock
FROM producto
WHERE codigo = 'PR-001';

UPDATE producto SET stock = stock - 2
WHERE codigo = 'PR-001';

SELECT codigo, nombre, stock FROM producto
WHERE codigo = 'PR-001';








SELECT codigo, nombre, stock, activo FROM producto
WHERE stock = 0;

UPDATE producto SET activo = FALSE
WHERE stock = 0;

SELECT codigo, nombre, stock, activo FROM producto
WHERE activo = FALSE;







INSERT INTO producto (codigo, nombre, categoria, precio, stock)
VALUES ('TEMP-001', 'Producto Temporal', 'PRUEBA', 10.00, 1);

SELECT codigo, nombre, categoria, precio, stock FROM producto
WHERE codigo = 'TEMP-001';

DELETE FROM producto WHERE codigo = 'TEMP-001';

SELECT codigo, nombre, categoria, precio, stock FROM producto
WHERE codigo = 'TEMP-001';






INSERT INTO producto (codigo, nombre, categoria, precio, stock)
VALUES ('PR-001', 'Teclado Duplicado', 'ELECTRONICA', 200.00, 5);


INSERT INTO producto (codigo, nombre, categoria, precio, stock)
VALUES ('PR-009', 'Teclado Mecánico', 'ELECTRONICA', 380.00, 5);



INSERT INTO producto (codigo, nombre, categoria, precio, stock)
VALUES ('PR-010', 'Audífonos Gaming', 'ELECTRONICA', 150.00, -5);

INSERT INTO producto (codigo, nombre, categoria, precio, stock)
VALUES ('PR-010', 'Audífonos', 'ELECTRONICA', 150.00, 10);


SELECT id, codigo, nombre, categoria, precio, stock, activo
FROM producto;
