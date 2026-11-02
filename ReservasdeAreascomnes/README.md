Reserva de Areas.


Angel Gabriel Rivas Arreola.
9941-25-23017.

Un condominio necesita administrar sus áreas comunes y las reservas hechas por los residentes se necesita un sistema para controlar y evitar duplicas.

Que tecnologia se uso:
Backend: Java 17, Spring Boot (Spring Data JPA, Spring Web, Spring Boot DevTools).


Base de Datos: PostgreSQL.


Frontend: Single Page Application (SPA) con HTML5, Tailwind CSS (CDN) y JavaScript vanilla (fetch API).


Gestor de Dependencias: Maven.


Pruebas de API: Postman / cURL..


Estructura general del sistema:

├── controller/  


├── service/     


│   └── impl/ 


├── repository/  


├── entity/   


├── dto/     


├── exception/   


└── scheduler/


Requisitos para ejecutar el proyecto.

DK 17 o superior instalado y configurado en el PATH.

Apache Maven 3.8+ (o el wrapper ./mvnw embebido).

PostgreSQL 14+ corriendo en el puerto por defecto 5432.

Navegador web moderno (Chrome, Firefox, Edge, Safari).

Configuración de PostgreSQL: creacion de una base de datos con postgrest


Instrucciones para iniciar el backend: Iniciar la aplicación Spring Boot y este iniciara en http://localhost:8080


Instrucciones para abrir el frontend:


Abre el archivo index.html del documento directamente en tu navegador web preference haciendo doble clic sobre él o arrastrándolo a una pestaña.


Asegúrate de que el indicador en la esquina superior derecha marque: Modo: conectado para saber que este funcionando.||


Descripción de los endpoints:

Método,Endpoint,Descripción,Body / Parámetros
GET,/api/reservas,Obtiene el listado completo de reservas,Ninguno
GET,/api/reservas/{id},Busca una reserva por su ID,Parámetro de ruta {id}
GET,/api/reservas/buscar-por-fecha,Filtra reservas por fecha,Query Param ?fecha=YYYY-MM-DD
GET,/api/reservas/buscar-por-residente,Filtra por nombre del residente,Query Param ?nombre=texto
POST,/api/reservas,Crea una nueva reserva,Body (ReservaSolicitudDTO)
PUT,/api/reservas/{id},Actualiza una reserva existente,Parámetro {id} + Body (ReservaSolicitudDTO)
DELETE,/api/reservas/{id},Cancela/Elimina una reserva,Parámetro de ruta {id}


Reglas principales del negocio:


Orden Cronológico Estricto: La horaFin debe ser posterior a la horaInicio.


Control de Traslape de Horarios: No se permite guardar una reserva en la misma área común y fecha si su rango de horas se cruza con otra reserva confirmada 

Control de Aforo Límite: La cantidadAsistentes enviada no puede sobrepasar la capacidad asignada a la entidad AreaComun.


Respuesta Centralizada a Errores: Excepciones capturadas por @RestControllerAdvice retornando respuestas estructuradas en formato JSON (400 Bad Request, 404 Not Found).

