ANGEL GABRIEL RIVAS ARREOLA 9941-25-23017.
Este codigo crea una solicitud de ingreso de datos de varios vehiculos para luego guardarlos y mostrarlor luego muestra la joranada mostrando los datos .

Metodos:
1. public static double calcularPago( Se uso para calcular el pago sin el recargo y es parte de sobre carga)
2. public static double calcularPago( Se uso para calcular el pago con recargo y es parte de sobre carga)
3. public static void mostrarComprobante( para mostra los datos de ingresados, mostrar totales y descuentos de cada vehiculo)
4. public static double calcularDescuento( Se uso para calcular el descuento y para saber si hay decuento o no hay entonces es 0.00)
5. public static double obtenerTarifa ( Se uso para determinar la tarifa del vehiculo ingresado cada uno tiene una tarifa diferente esto se determino mediante un switch)
6. public static String obtenerNombreVehiculo (Se uso para determinar el tipo de vehiculo que se ingreso )

Explicación de aplicacion de la sobrecarga:
La sobre carga se utilizo en estos dos metodos public static double calcularPago la unico que se cambiaron los parametros de ellos aqui un ejemplo de los parametros cambiados
1. public static double calcularPago(int horas, double tarifa, double recargo)
2. public static double calcularPago(int horas, double tarifa)
Se ouede ver que son el mismo nombre de metodo pero diferentes parametros lo cual lo hace una sobre carga cada uno se aplicon con una funcion similiar pero diferente.

Casos de prueba utilizados.

Ingrese cantidad de vehiculos 3

--- Vehículo #1 ---
Número de placa: 512sas
Tipo de vehículo 1.Moto, 2.Auto, 3.Pickup: 1
Cantidad de horas estacionadas: 9
¿Perdió el ticket? (S/N): S

=====================================
        COMPROBANTE DE PAGO
=====================================
Placa: 512sas
Tipo: Motocicleta
Horas Estacionadas: 9
Tarifa por hora: Q5.0
-------------------------------------
Subtotal: Q45.0
Descuento : Q6.75
-------------------------------------
Total: Q95.0
=====================================


--- Vehículo #2 ---
Número de placa: 5s4dsa
Tipo de vehículo 1.Moto, 2.Auto, 3.Pickup: 2
Cantidad de horas estacionadas: 5
¿Perdió el ticket? (S/N): N

=====================================
        COMPROBANTE DE PAGO
=====================================
Placa: 5s4dsa
Tipo: Automóvil
Horas Estacionadas: 5
Tarifa por hora: Q8.0
-------------------------------------
Subtotal: Q40.0
Descuento: Q0.00
-------------------------------------
Total: Q40.0
=====================================


--- Vehículo #3 ---
Número de placa: 241s2d1a
Tipo de vehículo 1.Moto, 2.Auto, 3.Pickup: 3
Cantidad de horas estacionadas: 9
¿Perdió el ticket? (S/N): S

=====================================
        COMPROBANTE DE PAGO
=====================================
Placa: 241s2d1a
Tipo: Pickup o camioneta
Horas Estacionadas: 9
Tarifa por hora: Q12.0
-------------------------------------
Subtotal: Q108.0
Descuento : Q16.2
-------------------------------------
Total: Q158.0
=====================================



=====================================
        RESUMEN DE LA JORNADA
=====================================
Cantidad de motocicletas: 1
Cantidad de automóviles: 1
Cantidad de pickups o camionetas: 1
Cantidad de tickets perdidos: 2
Total de dinero recaudado: Q293.0
-------------------------------------
Vehículo con el pago más alto: 241s2d1a
Pago máximo: Q158.0
=====================================


Indicación de si realizaste el reto opcional.
No se realizo el reto opcional si lo intente pero me perdi para ser honesto.
