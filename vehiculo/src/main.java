import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class main {
    private static ArrayList<vehiculo> listaVehiculos = new ArrayList<>();
    private static HashSet<String> placasRegistradas = new HashSet<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;

        do {
            mostrarMenu();
            System.out.print("Ingrese una opción: ");
            String entrada = scanner.nextLine();
            try {
                opcion = Integer.parseInt(entrada);
                switch (opcion) {
                    case 1:
                        registrarVehiculo();
                        break;
                    case 2:
                        mostrarTodosVehiculos();
                        break;
                    case 3:
                        buscarVehiculoPorPlaca();
                        break;
                    case 4:
                        mostrarVehiculoMayorCosto();
                        break;
                    case 5:
                        mostrarTotalGeneral();
                        break;
                    case 6:
                        mostrarTotalPorTipo();
                        break;
                    case 7:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (NumberFormatException error) {
                System.out.println("Debe ingresar un número entero.");
            } finally {
                System.out.println("--------------------------------------------------");
            }
        } while (opcion != 7);
    }

    private static void mostrarMenu() {
        System.out.println("\n====== SISTEMA DE GESTIÓN DE ESTACIONAMIENTO ======");
        System.out.println("1. Registrar vehículo");
        System.out.println("2. Mostrar todos los vehículos registrados");
        System.out.println("3. Buscar un vehículo por placa");
        System.out.println("4. Mostrar vehículo con el mayor costo");
        System.out.println("5. Mostrar el total general recaudado");
        System.out.println("6. Mostrar el total recaudado por tipo de vehículo");
        System.out.println("7. Salir");
    }

    private static void registrarVehiculo() {
        System.out.println("\n====== REGISTRO DE VEHÍCULO ======");

        System.out.print("Ingrese la placa: ");
        String placa = scanner.nextLine().trim().toUpperCase();

        // Placa no vacía
        if (placa.isEmpty()) {
            System.out.println(" Error la placa no puede estar vacía.");
            return;
        }

        // Evitar duplicados
        if (placasRegistradas.contains(placa)) {
            System.out.println(" Error la placa '" + placa + "' ya se encuentra registrada en el sistema.");
            return;
        }

        System.out.print("Ingrese el nombre del propietario: ");
        String propietario = scanner.nextLine().trim();

        // Propietario no vacío
        if (propietario.isEmpty()) {
            System.out.println(" Error el nombre del propietario no puede estar vacío.");
            return;
        }

        System.out.print("Ingrese la hora de ingreso (ej. 08:30): ");
        String horaIngreso = scanner.nextLine().trim();

        int horasUt = 0;


        System.out.print("Ingrese la cantidad de horas utilizadas: ");
        String entradaHoras = scanner.nextLine();

        try {
            horasUt = Integer.parseInt(entradaHoras);

            if (horasUt <= 0) {
                System.out.println(" Error las horas utilizadas deben ser mayores a cero.");
                return;
            }
        } catch (NumberFormatException error) {
            System.out.println("Debe ingresar un número entero.");
            return;
        } finally {
            System.out.println("Verificación de entrada de horas completada.");
        }

        System.out.println("Seleccione el tipo de vehículo:");
        System.out.println("1. Automóvil");
        System.out.println("2. Motocicleta");
        System.out.print("Opción: ");

        String entradaTipo = scanner.nextLine();
        int tipo = 0;

        try {
            tipo = Integer.parseInt(entradaTipo);
        } catch (NumberFormatException error) {
            System.out.println("Debe ingresar un número entero.");
            return;
        }

        vehiculo nuevoVehiculo = null;

        // Validación: Tipo de vehículo válido
        if (tipo == 1) {
            nuevoVehiculo = new automovil(placa, propietario, horaIngreso, horasUt);
        } else if (tipo == 2) {
            nuevoVehiculo = new motocicleta(placa, propietario, horaIngreso, horasUt);
        } else {
            System.out.println(" Error tipo de vehículo inválido.");
            return;
        }

        // Guardar en colecciones
        listaVehiculos.add(nuevoVehiculo);
        placasRegistradas.add(placa);

        System.out.println(" Vehículo registrado exitosamente.");
    }

    private static void mostrarTodosVehiculos() {
        System.out.println("\n====== VEHÍCULOS REGISTRADOS ======");
        if (listaVehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        for (vehiculo v : listaVehiculos) {
            v.mostrarInformacion();

        }
    }

    private static void buscarVehiculoPorPlaca() {
        System.out.print("\nIngrese la placa a buscar: ");
        String placa = scanner.nextLine().trim().toUpperCase();

        for (vehiculo v : listaVehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                System.out.println("\nVehículo encontrado:");
                v.mostrarInformacion();
                return;
            }
        }
        System.out.println(" No se encontró ningún vehículo con la placa: " + placa);
    }

    private static void mostrarVehiculoMayorCosto() {
        if (listaVehiculos.isEmpty()) {
            System.out.println("\nNo hay vehículos registrados.");
            return;
        }

        vehiculo mayor = listaVehiculos.get(0);
        for (vehiculo v : listaVehiculos) {
            if (v.calcularCosto() > mayor.calcularCosto()) {
                mayor = v;
            }
        }

        System.out.println("\n====== VEHÍCULO QUE GENERÓ EL MAYOR COSTO ======");
        mayor.mostrarInformacion();
    }

    private static void mostrarTotalGeneral() {
        double total = 0;
        for (vehiculo v : listaVehiculos) {
            total += v.calcularCosto();
        }
        System.out.printf("\nTotal General Recaudado: Q%.2f\n", total);
    }

    private static void mostrarTotalPorTipo() {
        HashMap<String, Double> totalesPorTipo = new HashMap<>();


        totalesPorTipo.put("Automóvil", 0.0);
        totalesPorTipo.put("Motocicleta", 0.0);


        for (vehiculo v : listaVehiculos) {
            String tipo = v.getTipoVehiculo();
            double costoActual = totalesPorTipo.getOrDefault(tipo, 0.0);
            totalesPorTipo.put(tipo, costoActual + v.calcularCosto());
        }

        System.out.println("\n====== TOTAL RECAUDADO POR TIPO DE VEHÍCULO ======");
        for (String tipo : totalesPorTipo.keySet()) {
            System.out.println(tipo + ": Q" + totalesPorTipo.get(tipo));
        }
    }
}