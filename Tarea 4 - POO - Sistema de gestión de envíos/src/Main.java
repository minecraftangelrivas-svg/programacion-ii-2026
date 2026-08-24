import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\nSISTEMA DE ENVÍOS");
            System.out.println("1. Registrar envío nacional");
            System.out.println("2. Registrar envío internacional");
            System.out.println("3. Salir");

            opcion = scanner.nextInt();

            if (opcion == 1 || opcion == 2) {
                // Valida que no esté vacío
                String codigo = "";
                while (codigo.trim().isEmpty()) {// trim quita espacios extras y isEmpty revisa si quedó vacío
                    System.out.print("Ingrese el cdigo del envío: ");
                    codigo = scanner.nextLine();
                    if (codigo.trim().isEmpty()) {
                        System.out.println("Error: El codigo esta vacio.");
                    }
                }
                String nombre = ""; //aqui tambien validamos que no este vacio pero en el caso de nombre
                while (nombre.trim().isEmpty()) {
                    System.out.print("Ingrese el nombre del destinatario: ");
                    nombre = scanner.nextLine();
                    if (nombre.trim().isEmpty()) {
                        System.out.println("Error: El nombre esta vacio.");
                    }
                }

                double peso = 0;//VALIDAMOS QUE SEA MAYOR A CERO
                while (peso <= 0) {
                    System.out.print("Ingrese el peso en kg (> 0): ");
                    peso = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar el Enter
                    if (peso <= 0) {
                        System.out.println("Error: El peso debe ser mayor a cero.");
                    }
                }

                if (opcion == 1) {
                    String departamento = "";
                    while (departamento.trim().isEmpty()) {
                        System.out.print("Ingrese el departamento: ");
                        departamento = scanner.nextLine();
                        if (departamento.trim().isEmpty()) {
                            System.out.println("Error: El departamento esta vacio.");
                        }
                    }

                    double distancia = 0;
                    while (distancia <= 0) {
                        System.out.print("Ingrese la distancia en km debe ser mayor de 0: ");
                        distancia = scanner.nextDouble();
                        if (distancia <= 0) {
                            System.out.println("Error: La distancia debe ser mayor a cero.");
                        }
                    }

                    EnvioNacional envioN = new EnvioNacional(codigo, nombre, peso, departamento, distancia);
                    System.out.println("\nCosto calculado exitosamente.");
                    envioN.Resumen(true);


                }
