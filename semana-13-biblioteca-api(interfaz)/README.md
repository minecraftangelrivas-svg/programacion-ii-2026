## Interfaz web

Dirección de acceso: http://localhost:8080 


Tecnologías utilizadas: HTML, CSS, Bootstrap (CDN), JavaScript (Fetch API). 


  
Funcionalidades disponibles: 



Consulta automática de libros al cargar la página. 

Formulario reactivo para registrar nuevos libros con validaciones HTML. 

Eliminación interactiva de libros con ventana de confirmación. 

Notificaciones en pantalla (Alertas) sobre el resultado de las operaciones. 



Endpoints consumidos: 


GET /api/libros: Recuperación de todos los registros. 

POST /api/libros: Envío de objeto JSON para guardado. 

DELETE /api/libros/{id}: Eliminación física por clave primaria. 


  
Instrucciones de ejecución: 


Asegurarse de tener en ejecución el servidor PostgreSQL con la base de datos biblioteca_personal. 

Ejecutar el proyecto Spring Boot desde el IDE o mediante la terminal (./mvnw spring-boot:run). 


Abrir el navegador e ingresar a http://localhost:8080. 
