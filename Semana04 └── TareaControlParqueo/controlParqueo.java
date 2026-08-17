import java.util.Scanner;


public class controlParqueo {

    public static double calcularPago(int horas, double tarifa){

        return tarifa * horas;
    }

    public static double calcularPago(int horas, double tarifa, double recargo){
         return tarifa *horas + recargo;

    }



    public static void mostrarComprobante(String placa,String tipo,int horas,double tarifa,double sub,double desc, double total){

        System.out.println("=====================================");
        System.out.println("        COMPROBANTE DE PAGO");
        System.out.println("=====================================");

        System.out.println("Placa: " + placa) ;
        System.out.println("Tipo: " + tipo) ;
        System.out.println("Horas Estacionadas: " + horas) ;
        System.out.println("Tarifa por hora: Q" + tarifa) ;

        System.out.println("-------------------------------------");

        System.out.println("Subtotal: Q" + sub) ;
        if (desc > 0) {
            System.out.println("Descuento : Q" + desc);
        } else {
            System.out.println("Descuento: Q0.00");
        }

        System.out.println("-------------------------------------");

        System.out.println("Total: Q" + total);

        System.out.println("=====================================");

    }


    public static double calcularDescuento(double a, int horas){
       if(horas > 8) {
           return a * 0.15;
       }else
           return 0.00;

    }


    public static double obtenerTarifa(int tipoVehiculo){
        switch (tipoVehiculo) {
            case 1:
                return 5.00;

            case 2:
                return 8.00;

            case 3:
                return 12.00;
            default:
                return 0.00;  // Por si acaso

        }

    }

    public static String obtenerNombreVehiculo(int tipoVehiculo){
        switch (tipoVehiculo) {
            case 1:
                return "Motocicleta";

            case 2:
                return "Automóvil";

            case 3:
                return "Pickup o camioneta";

            default:
                return "Desconocido";  // Por si acaso

        }

    }


    public static void main(String[] args) {

        int motos = 0;
        int autos = 0;
        int pickups = 0;
        int ticketsperdidos = 0;
        double totalRecaudado = 0;
        double pagomaximo = 0;
        String placamaximo = "";

        Scanner entrada = new Scanner(System.in);
        double recargo = 50.00;
        int numerovehiculos,tipo, hora = 0;
        double subtotal = 0;
        char ticket;// para validar si es N o S
        String placa="", nombre="";

        System.out.println("Bienvenido a tu parqueo de confianza ");
        System.out.println("==================TARIFA==================");
        System.out.print("Tipo de Vehiculo   ");
        System.out.println("  Tarifa por Hora");
        System.out.println("Motocicleta           Q5.00");
        System.out.println("Automóvil             Q8.00");
        System.out.println("Pickup o camioneta    Q12.00");
        System.out.println("Si el vehículo permanece más de 8 horas, se aplica un descuento del 15 % sobre el pago del tiempo estacionado.");
        System.out.println("Si perdió el ticket, se agregan Q50.00 a su pago.");
          do {
              System.out.print("Ingrese cantidad de vehiculos ");
              numerovehiculos  = entrada.nextInt();

          }while(numerovehiculos <= 0); // lo repite si es menor o igual a cero


        for (int i = 1; i <= numerovehiculos; i++) {
            System.out.println("\n--- Vehículo #" + i + " ---");


            System.out.print("Número de placa: ");
            placa = entrada.next();

            do {
                System.out.print("Tipo de vehículo 1.Moto, 2.Auto, 3.Pickup: ");
                tipo = entrada.nextInt();
                if (tipo < 1 || tipo > 3) {
                    System.out.println("ERROR: Tipo inválido. Debe ser 1, 2 o 3.");
                }
            } while (tipo < 1 || tipo > 3);

            double tarifa = obtenerTarifa(tipo);// llamo a metodo para poner la tarifa
            nombre = obtenerNombreVehiculo(tipo);// llamo a metodo para tener el nombre


            do {
                System.out.print("Cantidad de horas estacionadas: ");
                hora = entrada.nextInt();
                if (hora <= 0) {
                    System.out.println("ERROR: Las horas deben ser mayores a 0.");
                }
            } while (hora <= 0);


            do {
                System.out.print("¿Perdió el ticket? (S/N): ");
                ticket = entrada.next().charAt(0);
                if (ticket != 'S' && ticket != 'N') {
                    System.out.println("ERROR: Debe ingresar 'S' o 'N'.");
                }
            } while (ticket != 'S' && ticket != 'N');

            subtotal = calcularPago(hora,tarifa);
            double descuento = calcularDescuento(subtotal,hora);
            double total;
            if (ticket == 'S') {  // Si perdió el ticket
                total = calcularPago(hora, tarifa, recargo);
            } else {  // No perdió el ticket
                total = calcularPago(hora, tarifa);
            }


            totalRecaudado += total;

            if (tipo == 1) {// Contador de tipo de vehículo
                motos++;
            } else if (tipo == 2) {
                autos++;
            } else if (tipo == 3) {
                pickups++;
            }

            if (ticket == 'S') {// Contador de tickets perdidos
                ticketsperdidos++;
            }

            if (total > pagomaximo) {// Vehículo con pago más alto
                pagomaximo = total;
                placamaximo = placa;
            }

            mostrarComprobante(placa,nombre,hora,tarifa,subtotal,descuento,total);

        }

        System.out.println("\n=====================================");
        System.out.println("        RESUMEN DE LA JORNADA");
        System.out.println("=====================================");
        System.out.println("Cantidad de motocicletas: " + motos);
        System.out.println("Cantidad de automóviles: " + autos);
        System.out.println("Cantidad de pickups o camionetas: " + pickups);
        System.out.println("Cantidad de tickets perdidos: " + ticketsperdidos);
        System.out.println("Total de dinero recaudado: Q" + totalRecaudado);
        System.out.println("-------------------------------------");
        System.out.println("Vehículo con el pago más alto: " + placamaximo);
        System.out.println("Pago máximo: Q" + pagomaximo);
        System.out.println("=====================================");

    }
}
