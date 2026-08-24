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
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            if (opcion == 1 || opcion == 2) {
                // Valida que no esté vacío
                String codigo = "";
                while (codigo.trim().isEmpty()) {// trim quita espacios extras y isEmpty revisa si quedó vacío
                    System.out.print("Ingrese el código del envío: ");
                    codigo = scanner.nextLine();
                    if (codigo.trim().isEmpty()) {
                        System.out.println("Error: El código no puede estar vacío.");
                    }
                }
            }
        }
    }