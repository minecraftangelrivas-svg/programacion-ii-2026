control-despensa-api.



En una despensa se tiene un problema por la falta de control al momento de consultar y analizar los productos almacenados en la despensa de un hogar.


Tecnologías utilizadas:

Lenguaje de programacion java, Spring Boot, gestor Maven, arquitectura de software y servidores web(servidor de aplicaciones).


Requisitos para ejecutar el proyecto:

JDK: Java 17 o superior instalado y configurado

IDE / Editor: IntelliJ IDEA

Gestor de dependencias: Apache Maven

Navegador Web / Cliente HTTP: Navegador web como Chrome, Edge, Firefox.

Estructura principal:

com.estudiante.controldespensaapi/

├── ControlDespensaApiApplication.java

└── despensa/

    ├── controller/
    
    │   └── ProductoController.java
    
    └── model/
    
        ├── Producto.java
        
        └── ResumenInventario.java

  
Explicación de las clases:

ControlDespensaApiApplication.java (Es la clase principal de la aplicación.)
Se encarga de inicializar el framework Spring Boot, arrancar el servidor embebido y activar el escaneo automático de componentes

Producto.java (Entidad de modelo de datos principal.) 
Define la estructura de un producto de la despensa con sus atributos (id, nombre, categoria, cantidad, precioUnitario).

ResumenInventario.java (Objeto de Transferencia de Datos)
Representa la estructura personalizada para la respuesta del endpoint de resumen

ProductoController.java (Controlador REST de la aplicación) 
esta clase expone todos los endpoints HTTP de la API. Inicializa la lista de 6 productos en memoria y contiene la lógica para responder a las peticiones GET

Instrucciones para ejecutar la aplicación:
Abre el proyecto control-despensa-api 

Haz clic derecho sobre el archivo ControlDespensaApiApplication.java y selecciona Run ControlDespensaApiApplication.

Verifica en la consola de IntelliJ que el servidor Tomcat haya iniciado en el puerto 8080.

Una vez iniciada la aplicación, abre cualquier navegador web e ingresa a la siguiente URL para comprobar que responde correctamente: http://localhost:8080/api/productos


Ejemplos de respuestas JSON:

Consulta de todos los productos (GET /api/productos)
Código HTTP: 200 OK
JSON

[
 {
    "id": 100,
    "nombre": "Leche",
    "categoria": "Lácteos",
    "cantidad": 5,
    "precioUnitario": 2.5
  },
  {
    "id": 25,
    "nombre": "Queso Blanco",
    "categoria": "Lácteos",
    "cantidad": 2,
    "precioUnitario": 4.0
  },
  {
    "id": 33,
    "nombre": "Arroz",
    "categoria": "Granos",
    "cantidad": 10,
    "precioUnitario": 1.8
  },
  {
    "id": 42,
    "nombre": "Frijoles Negros",
    "categoria": "Granos",
    "cantidad": 3,
    "precioUnitario": 2.0
  },
  {
    "id": 547,
    "nombre": "Detergente Líquido",
    "categoria": "Limpieza",
  "cantidad": 4,
    "precioUnitario": 8.5
  },
  {
    "id": 64,
    "nombre": "Jugo de Naranja",
    "categoria": "Bebidas",
    "cantidad": 6,
    "precioUnitario": 3.0
  }
]


Búsqueda por ID existente (GET /api/productos/33)
Código HTTP: 200 OK
JSON

{
  "id": 33,
  "nombre": "Arroz",
  "categoria": "Granos",
  "cantidad": 10,
  "precioUnitario": 1.8
}

estos serian algunos ejemplos

Angel Gabriel Riva Arreola
9941-25-23017
