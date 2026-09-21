SELECT id, codigo, nombre, categoria, precio, stock
FROM producto;

SELECT id, codigo, nombre, categoria, precio, stock
FROM producto 
WHERE categoria = 'ELECTRONICA';


SELECT id, codigo, nombre, categoria, precio, stock
FROM producto 
WHERE stock <= 3;


SELECT id, codigo, nombre, categoria, precio, stock, activo
FROM producto 
WHERE activo = TRUE AND stock > 0;


SELECT id, codigo, nombre, categoria, precio, stock, activo
FROM producto 
WHERE codigo = 'PR-008';





SELECT id, codigo, nombre, categoria, precio, stock
FROM producto 
ORDER BY precio DESC;




SELECT codigo, nombre, stock FROM producto WHERE codigo = 'PR-001';

UPDATE producto SET stock = stock - 2 
WHERE codigo = 'PR-001';

SELECT codigo, nombre, stock FROM producto WHERE codigo = 'PR-001';




SELECT codigo, nombre, stock, activo FROM producto WHERE stock = 0;

UPDATE producto SET activo = FALSE 
WHERE stock = 0;

SELECT codigo, nombre, stock, activo FROM producto WHERE activo = FALSE;



INSERT INTO producto (codigo, nombre, categoria, precio, stock)
VALUES ('TEMP-001', 'Producto Temporal', 'PRUEBA', 10.00, 1);

SELECT codigo, nombre, categoria, precio, stock 
FROM producto 
WHERE codigo = 'TEMP-001';

DELETE FROM producto 
WHERE codigo = 'TEMP-001';


SELECT codigo, nombre, categoria, precio, stock 
FROM producto 
WHERE codigo = 'TEMP-001';