Arquitectura por capas.


No se puede administrar los libro de una biblioteca personal se busaca hacer una apirest para poner administrarlos de manera automatica y almacenarlos 
de manera Permanente en un base de datos correctamente


La tecnología utilizada fue Spring Boot, Maven, Spring Data JPA y PostgreSQL todo esto conectado con una apirest la cual puede comunicar del cliente al controlador luego a un repository 
dirigido a la base de datos la cual se relaciona a la entidad libro para vincular a la tabla libro de la base de datos


Estructura del proyecto.


semana-13-biblioteca-api/

├── src/
│   ├── main/

│   │   ├── java/

│   │   │   └── com/

│   │   │       └── estudiante/

│   │   │           └── semana13bibliotecaapi/

│   │   │               ├── Entity/

│   │   │               │   └── Libro.java   

│   │   │               ├── repository/

│   │   │               │   └── LibroRepository.java   

│   │   │               ├── controller/

│   │   │               │   └── LibroController.java  

│   │   │               └── Semana13BibliotecaApiApplication.java  

│   │   └── resources/

│   │       ├── application.properties     

│   │       ├── static/

│   │       └── templates/

│   └── test/

│       └── java/ 

├── target/    

├── pom.xml   

└── README.md


Configuración general de la base de datos.


spring.application.name=biblioteca-api
server.port=8080


spring.datasource.url=jdbc:postgresql://localhost:5432/biblioteca_personal
spring.datasource.username=postgres
spring.datasource.password=TU_CONTRASENA_AQUI
spring.datasource.driver-class-name=org.postgresql.Driver


spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true


Tabla de endpoints.


Método HTTP , Endpoint,                 Descripción / Operación                          Código 
GET,/api/libros                       Listar todos los libros                            200 OK
GET,/api/libros/{id}                  Buscar un libro específico por su ID               200 OK / 404 Not Found
POST,/api/libros                      Registrar un nuevo libro                           201 Created
PUT,/api/libros/{id}                  Actualizar un libro existente por ID               200 OK / 404 Not Found
DELETE,/api/libros/{id}               Eliminar un libro por su ID                        204 No Content / 404 Not Found
GET,/api/libros/categoria/{categoria} Buscar libros por una categoría específica         200 OK
GET,/api/libros/disponibles       Listar únicamente los libros que están disponibles     200 OK


Instrucciones para ejecutar la aplicación.

1. Verificar que el puerto y la base de datos de postgrest
2. abrir el archivo Semana13BibliotecaApiApplication.java y ponerlo a correr (run o ejecutar)
3. verificar que si arranque confirmando el logo de spring-boot en la terminal o consola
4. Estara listo para recibir peticiones

Angel Gabriel Rivas Arreola 
9941-25-23017
